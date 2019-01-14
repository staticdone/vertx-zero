package io.vertx.up.micro.discovery;

import io.vertx.circuitbreaker.CircuitBreaker;
import io.vertx.circuitbreaker.CircuitBreakerOptions;
import io.vertx.core.*;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.RequestOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.FileUpload;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.multipart.MultipartForm;
import io.vertx.servicediscovery.Record;
import io.vertx.servicediscovery.ServiceDiscovery;
import io.vertx.servicediscovery.ServiceReference;
import io.vertx.servicediscovery.types.HttpEndpoint;
import io.vertx.up.log.Annal;
import io.vertx.up.micro.matcher.Arithmetic;
import io.vertx.up.micro.matcher.CommonArithmetic;
import io.vertx.zero.marshal.Visitor;
import io.vertx.zero.micro.config.CircuitVisitor;
import io.zero.epic.Ut;
import io.zero.epic.fn.Fn;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class ServiceJet {
    private static final Annal LOGGER = Annal.get(ServiceJet.class);
    private static final Visitor<CircuitBreakerOptions> VISITOR =
            Ut.singleton(CircuitVisitor.class);
    private static CircuitBreakerOptions OPTIONS;

    static {
        Fn.outUp(() -> {
            if (null == OPTIONS) {
                OPTIONS = VISITOR.visit();
            }
        }, LOGGER);
    }

    private final transient Arithmetic arithmetic = Ut.singleton(CommonArithmetic.class);
    private final transient HttpServerOptions options;
    private transient ServiceDiscovery discovery;
    private transient CircuitBreaker breaker;

    private ServiceJet(final HttpServerOptions options) {
        this.options = options;
    }

    public static ServiceJet create(final HttpServerOptions options) {
        return new ServiceJet(options);
    }

    public ServiceJet connect(final Vertx vertx) {
        this.discovery = ServiceDiscovery.create(vertx);
        final String name = this.options.getHost() + this.options.getPort();
        this.breaker = CircuitBreaker.create(name, vertx, OPTIONS);
        return this;
    }

    private Future<List<Record>> getEndPoints() {
        final Future<List<Record>> future = Future.future();
        this.discovery.getRecords(record -> record.getType().equals(HttpEndpoint.TYPE),
                future.completer());
        return future;
    }

    public Handler<RoutingContext> handle() {
        // Run with circuit breaker
        return context -> this.breaker.execute(future -> this.getEndPoints().setHandler(res -> {
            if (res.succeeded()) {
                final List<Record> records = res.result();
                // Find the record hitted. ( Include Path variable such as /xx/yy/:zz/:xy )
                final Record hitted = this.arithmetic.search(records, context);
                // Complete actions.
                if (null == hitted) {
                    /**
                     * Service Not Found ( 404 )
                     * Situation 1:
                     * Zero engine could not find the uri that client provided.
                     * After sync operations, you can call future.complete directly.
                     **/
                    Output.sync404Error(this.getClass(), context);
                    future.complete();
                } else {
                    // Get service reference
                    final ServiceReference reference = this.discovery.getReference(hitted);
                    // Set callback completer
                    final Consumer<Void> consumer = (nil) -> {
                        reference.release();    // release service reference
                        future.complete();      // execute future complete operation
                    };
                    /**
                     * Service Found
                     * Situation 1:
                     * Here matching successfully when gateway get request.
                     **/
                    this.doRequest(context, reference, hitted, consumer);
                }
            } else {
                // Future failed
                future.fail(res.cause());
            }
        }));
    }

    private RequestOptions getOptions(final Record record, final String normalizedUri) {
        final RequestOptions options = new RequestOptions();
        options.setURI(normalizedUri);
        // Extract host / port
        final JsonObject location = record.getLocation();
        options.setHost(location.getString("host"));
        options.setPort(location.getInteger("port"));
        return options;
    }

    private void doRequest(final RoutingContext context,
                           final ServiceReference reference,
                           final Record record,
                           final Consumer<Void> consumer) {
        {
            final HttpServerRequest rctRequest = context.request();
            final HttpMethod method = rctRequest.method();
            final String uri = Output.normalizeUri(context);

            final WebClient client = reference.getAs(WebClient.class);
            final RequestOptions options = this.getOptions(record, uri);
            LOGGER.info("[ ZERO ] Found remote host: {0}, port: {1}, uri: {2}",
                    options.getHost(), String.valueOf(options.getPort()), options.getURI());
            /*
             * Here client got from service reference, it means that it's not needed to use requestAbs
             * request instead.
             * requestAbs: it means used absolute URI instead of uri address
             */
            final HttpRequest<Buffer> request = client.request(method, options);
            /*
             * Headers processing ( copy all the headers from request, perfect redirect );
             */
            final MultiMap headers = rctRequest.headers();
            headers.forEach((item) -> request.putHeader(item.getKey(), item.getValue()));
            /*
             * Default timeout parameters set to 5s
             */
            request.timeout(5000);
            /*
             * dispatching request
             * 1. Pure Request
             * 2. MultiPart
             */
            if (rctRequest.isExpectMultipart()) {
                /*
                 * Multi Part
                 */
                final Set<FileUpload> fileUploads = context.fileUploads();
                if (!fileUploads.isEmpty()) {
                    final FileUpload fileUpload = fileUploads.iterator().next();
                    final MultipartForm body = MultipartForm.create()
                            .binaryFileUpload(
                                    fileUpload.name(),
                                    fileUpload.fileName(),
                                    fileUpload.uploadedFileName(),
                                    fileUpload.contentType());
                    request.headers().forEach((item) -> LOGGER.info("[ ZERO ] Headers: {0} = {1}",
                            item.getKey(), item.getValue()));
                    request.sendMultipartForm(body, this.replyContent(context, consumer));
                } else {
                    Output.sync500Error(this.getClass(), context, null);
                    consumer.accept(null);
                }
            } else {
                /*
                 * Pure request with buffer directly
                 */
                Buffer body = context.getBody();
                if (null == body) {
                    body = Buffer.buffer();
                }
                request.sendBuffer(body, this.replyContent(context, consumer));
            }
        }
    }

    private Handler<AsyncResult<HttpResponse<Buffer>>> replyContent(
            final RoutingContext context,
            final Consumer<Void> consumer
    ) {
        return response -> {
            if (response.succeeded()) {
                final HttpResponse<Buffer> remoteResp = response.result();
                if (404 == remoteResp.statusCode()) {
                    /*
                     * 404 -> 405 Error
                     */
                    Output.sync405Error(this.getClass(), context);
                } else {
                    /*
                     * 200 -> Success
                     */
                    Output.syncSuccess(context.response(), remoteResp);
                }
            } else {
                /*
                 * 500
                 */
                Output.sync500Error(this.getClass(), context, response.cause());
            }
            consumer.accept(null);
        };
    }
}

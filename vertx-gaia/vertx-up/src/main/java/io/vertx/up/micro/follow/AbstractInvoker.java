package io.vertx.up.micro.follow;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.up.aiki.Ux;
import io.vertx.up.atom.Envelop;
import io.vertx.up.log.Annal;
import io.vertx.up.micro.ipc.client.TunnelClient;
import io.vertx.zero.eon.Values;
import io.zero.epic.Ut;

import java.lang.reflect.Method;
import java.util.function.Function;

/**
 * Uniform call TunnelClient to remove duplicated codes
 * Refactor invokder to support Dynamic Invoke
 */
@SuppressWarnings("all")
public abstract class AbstractInvoker implements Invoker {

    protected Annal getLogger() {
        return Annal.get(this.getClass());
    }

    /**
     * Future method(JsonObject)
     * Future method(JsonArray)
     */
    protected Future invokeJson(
            final Object proxy,
            final Method method,
            final Envelop envelop) {
        final Object reference = envelop.data();
        final Class<?> argType = method.getParameterTypes()[Values.IDX];
        final Object arguments = Ut.deserialize(Ut.toString(reference), argType);
        return Ut.invoke(proxy, method.getName(), arguments);
    }

    /**
     *
     */
    protected <I> Function<I, Future<Envelop>> nextEnvelop(
            final Vertx vertx,
            final Method method) {
        return item -> this.nextEnvelop(vertx, method, item);
    }

    protected <T> Future<Envelop> nextEnvelop(
            final Vertx vertx,
            final Method method,
            final T result
    ) {
        return TunnelClient.create(this.getClass())
                .connect(vertx)
                .connect(method)
                .send(Ux.to(result));
    }
}
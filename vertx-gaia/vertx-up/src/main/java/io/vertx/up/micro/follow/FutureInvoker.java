package io.vertx.up.micro.follow;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.Message;
import io.vertx.up.aiki.Ux;
import io.vertx.up.atom.Envelop;
import io.zero.epic.Ut;

import java.lang.reflect.Method;

/**
 * Future<Envelop> method(Envelop)
 */
public class FutureInvoker extends AbstractInvoker {

    @Override
    public void ensure(final Class<?> returnType,
                       final Class<?> paramCls) {
        // Verify
        final boolean valid =
                Future.class.isAssignableFrom(returnType) && paramCls == Envelop.class;
        InvokerUtil.verify(!valid, returnType, paramCls, this.getClass());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(final Object proxy,
                       final Method method,
                       final Message<Envelop> message) {
        // Invoke directly
        final Envelop envelop = message.body();
        // Future<T>
        final Class<?> returnType = method.getReturnType();
        // Get T
        final Class<?> tCls = returnType.getComponentType();
        this.getLogger().info(Info.MSG_FUTURE, this.getClass(), returnType, false);
        if (Envelop.class == tCls) {
            final Future<Envelop> result = Ut.invoke(proxy, method.getName(), envelop);
            result.setHandler(item -> message.reply(item.result()));
        } else {
            final Future tResult = Ut.invoke(proxy, method.getName(), envelop);
            tResult.setHandler(Ux.toHandler(message));
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void next(final Object proxy,
                     final Method method,
                     final Message<Envelop> message,
                     final Vertx vertx) {
        // Invoke directly
        final Envelop envelop = message.body();
        // Future<T>
        final Class<?> returnType = method.getReturnType();
        // Get T
        final Class<?> tCls = returnType.getComponentType();
        this.getLogger().info(Info.MSG_FUTURE, this.getClass(), returnType, true);
        if (Envelop.class == tCls) {
            // Execute Future<Envelop>
            final Future<Envelop> future = Ut.invoke(proxy, method.getName(), envelop);
            /*
            future.compose(item -> TunnelClient.create(this.getClass())
                    .connect(vertx)
                    .connect(method)
                    .send(item))
                    .setHandler(Ux.toHandler(message)); */
            future.compose(this.nextEnvelop(vertx, method))
                    .setHandler(Ux.toHandler(message));
        } else {
            final Future future = Ut.invoke(proxy, method.getName(), envelop);
            /*
            future.compose(item -> TunnelClient.create(this.getClass())
                    .connect(vertx)
                    .connect(method)
                    .send(Ux.to(item)))
                    .compose(item -> Future.succeededFuture(Ux.to(item)))
                    .setHandler(Ux.toHandler(message)); */
            future.compose(this.nextEnvelop(vertx, method))
                    .setHandler(Ux.toHandler(message));
        }
    }
}

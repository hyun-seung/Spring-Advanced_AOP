package hello.advanced.proxy.config.v1_proxy.interface_proxy;

import hello.advanced.proxy.app.v1.OrderServiceV2;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderServiceV2 {

    private final OrderServiceV2 target;
    private final LogTrace logTrace;

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderService.orderItem()");
            //target 호출
            target.orderItem(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}

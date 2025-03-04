package hello.advanced.proxy.config.v2_dynamicproxy;

import hello.advanced.proxy.app.v1.*;
import hello.advanced.proxy.config.v2_dynamicproxy.handler.LogTraceFilterHandler;
import hello.advanced.trace.logTrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class DynamicProxyFilterConfig {

    private static final String[] PATTERNS = {"request*", "order*", "save*"};

    @Bean
    public OrderControllerV2 orderControllerV1(LogTrace logTrace) {
        OrderControllerV2 orderControllerV1 = new OrderControllerV1Impl(orderServiceV1(logTrace));
        OrderControllerV2 proxy = (OrderControllerV2) Proxy.newProxyInstance(OrderControllerV2.class.getClassLoader(),
                new Class[]{OrderControllerV2.class},
                new LogTraceFilterHandler(orderControllerV1, logTrace, PATTERNS));
        return proxy;
    }

    @Bean
    public OrderServiceV2 orderServiceV1(LogTrace logTrace) {
        OrderServiceV2 orderServiceV1 = new OrderServiceV1Impl(orderRepositoryV1(logTrace));

        OrderServiceV2 proxy = (OrderServiceV2) Proxy.newProxyInstance(OrderServiceV2.class.getClassLoader(),
                new Class[]{OrderServiceV2.class},
                new LogTraceFilterHandler(orderServiceV1, logTrace, PATTERNS));
        return proxy;
    }

    @Bean
    public OrderRepositoryV2 orderRepositoryV1(LogTrace logTrace) {
        OrderRepositoryV2 orderRepositoryV1 = new OrderRepositoryV1Impl();

        OrderRepositoryV2 proxy = (OrderRepositoryV2) Proxy.newProxyInstance(OrderRepositoryV2.class.getClassLoader(),
                new Class[]{OrderRepositoryV2.class},
                new LogTraceFilterHandler(orderRepositoryV1, logTrace, PATTERNS));
        return proxy;
    }
}

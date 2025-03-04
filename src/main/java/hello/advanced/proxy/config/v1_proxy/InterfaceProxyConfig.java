package hello.advanced.proxy.config.v1_proxy;

import hello.advanced.proxy.app.v1.*;
import hello.advanced.proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import hello.advanced.proxy.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import hello.advanced.proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import hello.advanced.trace.logTrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public OrderControllerV2 orderController(LogTrace logTrace) {
        OrderControllerV1Impl controllerImpl = new OrderControllerV1Impl(orderService(logTrace));
        return new OrderControllerInterfaceProxy(controllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV2 orderService(LogTrace logTrace) {
        OrderServiceV1Impl serviceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
        return new OrderServiceInterfaceProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV2 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1Impl repositoryImpl = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(repositoryImpl, logTrace);
    }
}

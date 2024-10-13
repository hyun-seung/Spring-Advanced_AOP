package hello.adavanced.aop.v1;

import hello.adavanced.trace.TraceStatus;
import hello.adavanced.trace.helloTrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepository;
    private final HelloTraceV1 trace;

//    @Autowired -> @RequiredArgsConstructor 없고, 생성자가 하나일 경우 자동으로 @Autowired가 붙음
//    public OrderServiceV1(OrderRepositoryV1 orderRepository) {
//        this.orderRepository = orderRepository;
//    }

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.request()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; //예외를 꼭 다시 던져주어야 한다.
        }
    }
}

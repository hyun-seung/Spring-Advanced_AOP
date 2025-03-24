package hello.advanced.aop.v0;

import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class OrderServiceV0 {

    private final OrderRepositoryV0 orderRepository;

//    @Autowired -> @RequiredArgsConstructor 없고, 생성자가 하나일 경우 자동으로 @Autowired가 붙음
    public OrderServiceV0(OrderRepositoryV0 orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}

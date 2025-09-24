package order;

import order.domain.Order;
import order.domain.OrderItem;
import order.repository.OrderItemRepository;
import order.repository.OrderItemRepositoryImpl;
import order.repository.OrderRepository;
import order.repository.OrderRepositoryImpl;
import product.ProductService;
import product.repository.ProductRepository;
import util.Result;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private static final OrderService INSTANCE = new OrderService();

    public static OrderService getInstance() {
        return INSTANCE;
    }

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    public OrderService() {
        this.productRepository = ProductRepository.getInstance();
        this.orderItemRepository = OrderItemRepositoryImpl.getInstance();
        this.orderRepository = OrderRepositoryImpl.getInstance();
    }


    public Result<Order> addOrderItemInOrder(Order payOrder, OrderItem newOrderItem) {

        if (newOrderItem.getOrderQuantity() <= 0) {
            return Result.fail("1 이상의 수량을 입력해주세요.", payOrder);
        }
        payOrder.addOrderItem(newOrderItem);
        payOrder.updateTotalPrice();
        return Result.success("주문이 추가 되었습니다.", payOrder);
    }

    public Result<Order> updateOrderItemInOrder(Order order, OrderItem orderItem, int delta) {

        int finalQuantity = orderItem.getOrderQuantity() + delta;
        order.changeItemQuantityByDelta(orderItem, finalQuantity);
        String msg = (finalQuantity <= 0) ? "주문 항목 삭제/감소 처리 완료" : "주문 항목 수량 변경 완료";
        return Result.success(msg, order);
    }


    public List<Order> getOrderList() {
        return orderRepository.findOrderList();
    }
}

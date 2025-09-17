package order.repository;

import order.domain.OrderItem;

import java.util.List;

public interface OrderItemRepository {

    List<OrderItem> findOrderItemList();
    OrderItem findById(long orderId);
    List<OrderItem> findByOrderId(long orderId);
    boolean insert(OrderItem order);
    boolean update(OrderItem order);
    boolean delete(long id);
}

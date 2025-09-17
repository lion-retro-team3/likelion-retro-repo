package order.repository;

import order.domain.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findOrderList();
    Order findById(long id);
    boolean insert(Order order);
    boolean update(Order order);
    boolean delete(long id);
}

package order;

import product.Product;
import util.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderService {

    private List<Order> orderLog; //거래 내역

    public OrderService() {
        this.orderLog = new ArrayList<>();
    }

    public Optional<List<Order>> getOrderLog() {
        return Optional.ofNullable(orderLog);
    }

    public void saveOrderLog(Order newOrder) {
        orderLog.add(newOrder);
    }

    public Result<Order> addOrderItemInOrder(Order payOrder, OrderItem newOrderItem) {

        payOrder.addOrderItem(newOrderItem);

        return Result.success("성공적으로 주문이 추가되었습니다.\n", payOrder);
    }

    public Result<OrderItem> updateOrderItemInOrder(OrderItem orderItem, int newOrderQuantity) {

        int finalQuantity = orderItem.getOrderQuantity() + newOrderQuantity;
        orderItem.updateOrderQuantity(finalQuantity);
        return Result.success("성공적으로 주문이 추가되었습니다.\n", orderItem);
    }

    public Optional<OrderItem> findOrderItemInOrder(Order payOrder, OrderItem findProduct) {

        return payOrder.getOrderItem(findProduct);
    }
}

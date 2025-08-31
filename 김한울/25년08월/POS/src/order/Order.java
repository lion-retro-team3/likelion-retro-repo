package order;

import util.Status;

import java.util.List;

public class Order {

    private final Long OrderId;
    private List<OrderItem> orderItemList;
    private Status status;

    public Order(Long orderId, List<OrderItem> orderItemList) {
        OrderId = orderId;
        this.orderItemList = orderItemList;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public Status getStatus() {
        return status;
    }


    public void showOrderList(){
        StringBuilder sb = new StringBuilder();
        System.out.println("[결제]=====================================");
        for (OrderItem orderItem : orderItemList) {
            sb.append("결제 품목 -> ").append(orderItem.toString());
        }
        System.out.println("=====================================");
    }


}

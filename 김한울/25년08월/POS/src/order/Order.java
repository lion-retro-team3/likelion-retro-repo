package order;

import product.Product;
import util.Result;
import util.Status;

import java.util.List;

public class Order {

    private final Long orderId;
    private List<OrderItem> orderItemList;
    private int totalPrice;
    private Status status;

    private static Long idSequence = 1L;


    public Order(List<OrderItem> orderItemList) {
        this.orderId = idSequence++;
        this.orderItemList = orderItemList;
        this.totalPrice = this.updateTotalPrice(orderItemList);
        this.status = Status.WAIT;
    }


    public Long getOrderId() {
        return orderId;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Status getStatus() {
        return status;
    }



    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    private void setStatus(Status status) {
        this.status = status;
    }

    private int updateTotalPrice(List<OrderItem> orderItemList) {
        int sum = 0;
        for (OrderItem orderItem : orderItemList) {
            sum += orderItem.getOrderPrice();
        }
        this.setTotalPrice(sum);
        return sum;
    }

    public int updateTotalPrice() {
        return this.updateTotalPrice(this.orderItemList);
    }


    @Override
    public String toString() {
        return "주문 : \n" +
                "\t상품 번호 : " + orderId +
                "\n상품 목록 : " + orderItemList +
                "\t총 금액 : " + totalPrice +
                "\t주문 결과 : " + status.getDescription() +"\n";
    }

    public void showOrderList() {
        StringBuilder sb = new StringBuilder();
        for (OrderItem orderItem : orderItemList) {
            sb.append("결제 품목 -> ").append(orderItem.toString());
        }
        System.out.println("[결제 현황]=====================================");
        if (!sb.isEmpty()) System.out.println(sb);
        else System.out.println("결제할 상품을 등록해주세요.");
        System.out.println("=====================================");
    }
    public boolean hasOrderItemList() {
        return !orderItemList.isEmpty();
    }

    public void confirm() {
        orderItemList.forEach(orderItem -> {
            int orderQuantity =orderItem.getOrderQuantity();
            orderItem.getProduct().decreaseStock(orderQuantity);
        });
        this.success();
    }

    public void fail() {
        this.setStatus(Status.FAIL);
    }

    public void cancel() {
        this.setStatus(Status.CANCEL);
    }

    public void success(){
        this.setStatus(Status.SUCCESS);
    }

    public boolean isSuccess(){
        return this.getStatus() == Status.SUCCESS;
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItemList.add(orderItem);
        this.updateTotalPrice();

    }

    public boolean isEmptyOrderList(){
        return this.getOrderItemList().isEmpty();
    }

    public void removeOrderItem(OrderItem orderItem) {

        this.getOrderItemList().remove(orderItem);
        this.updateTotalPrice();
    }
}

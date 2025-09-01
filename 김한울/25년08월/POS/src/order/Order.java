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
        this.totalPrice = this.sumTotalPrice(orderItemList);
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

    public void setStatus(Status status) {
        this.status = status;
    }

    private int sumTotalPrice(List<OrderItem> orderItemList) {
        int sum = 0;
        for (OrderItem orderItem : orderItemList) {
            sum += orderItem.getOrderPrice();
        }
        this.totalPrice = sum;
        return sum;
    }

    public int sumTotalPrice() {
        return this.sumTotalPrice(this.orderItemList);
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



    public Result<Order> process(Product product, int newQuantity) {

        boolean find = false;
        boolean removeData = false;
        //첫 데이터
        if (orderItemList.isEmpty()) {
            OrderItem orderItem = new OrderItem(product, newQuantity);
            orderItemList.add(orderItem);
            return Result.success("성공적으로 주문이 등록되었습니다.\n", this);
        }

        //iterator 가 나중에 orderItemList 보다 나중에 열려야 한다.
        //ConcurrentModificationException 방지
        for (OrderItem item : orderItemList) {
            //같은 품목이면 원래 리스트에 orderQuantity 추가.
            //다른 품목이면 새로운 데이터로 추가.
            if (item.getProduct().equals(product)) {
                int originQuantity = item.getOrderQuantity();

                // 기존데이터의 경우
                // 현재 요청 수량 + 추가 요청 수량이 음수라면 리스트 삭제, 양수라면 요구 수량 변경
                int sumQuantity = originQuantity + newQuantity;
                if (sumQuantity <= 0) {
                    removeData = true;
                    find=true;
                    break;
                } else {
                    item.setOrderQuantity(sumQuantity);
                    find = true;

                }
                break;
            }
        }

        //기존 데이터 발견 X
        if (!find) {
            OrderItem orderItem = new OrderItem(product, newQuantity);
            orderItemList.add(orderItem);
        }
        if (removeData){
            OrderItem orderItem = new OrderItem(product, newQuantity);
            orderItemList.remove(orderItem);
            return Result.success("성공적으로 주문이 삭제되었습니다.\n", this);

        }
        //거래 진행 상황 출력
        sumTotalPrice();
        return Result.success("성공적으로 주문이 등록되었습니다.\n", this);
    }

    public void confirm() {

        for (OrderItem orderItem : orderItemList) {
            Product product = orderItem.getProduct();
            int quantity = product.getStockQuantity() - orderItem.getOrderQuantity();
            product.setStockQuantity(quantity);
        }
        this.setStatus(Status.SUCCESS);
    }
}

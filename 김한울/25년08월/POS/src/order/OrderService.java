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

    public Result<Order> addOrderItemInOrder(Order payOrder, OrderItem targetOrderItem) {



    }

    public Result<Order> updateOrderItemInOrder(Order payOrder, OrderItem targetOrderItem) {




        payOrder.addOrderItem(targetOrderItem);
        payOrder.updateTotalPrice();
        return Result.success("성공적으로 주문이 등록되었습니다.\n", payOrder);
    }

    //현재 리스트에 반드시 들어있음
    public Result<Optional<OrderItem>> AddOrUpdateProductInOrder(Product product, int quantity) {
        boolean hasOrderItemInList = false;
        OrderItem findItem = null;
        //등록되어있음 -> 양수,음수 가능, 신규 등록 -> 양수만 가능.

        List<OrderItem> orderItemList = order.getOrderItemList();
        //등록할 제품이 이미 주문내역이 있다면 음수 가능
        for (OrderItem orderItem : orderItemList) {
            hasOrderItemInList = orderItem.getProduct().equals(product);

            if (hasOrderItemInList) {
                findItem = orderItem;
                break;
            }
        }

        //update
        if (hasOrderItemInList){
            //음수일때 리스트 삭제 or 요청 재고 감소
            if (quantity < 0){

                return  Result.success("주문이 삭제 되었습니다.",findItem);
            } else {

                return Result.success("주문이 추가 되었습니다.", findItem);
            }
        }else {
            //add
            order.addOrderItem(findItem);
            return Result.success("주문이 등록 되었습니다.", Optional.of(findItem));
        }

    }

    public boolean hasProductInOrder(Order payOrder, OrderItem findProduct) {

        Optional<OrderItem> first = payOrder.getOrderItemList().stream().filter(orderItem -> orderItem.equals(findProduct)).findFirst();

        return first.isEmpty();

    }
}

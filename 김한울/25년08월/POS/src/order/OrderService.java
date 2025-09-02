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

    public Result<Order> registryOrderItem(Order payOrder, Product product, int newOrderQuantity) {

        boolean find = false;
        boolean removeThisOrderItem = false;
        if (payOrder.isEmptyOrderList()) {
            OrderItem orderItem = new OrderItem(product, newOrderQuantity);

            payOrder.addOrderItem(orderItem);
            return Result.success("성공적으로 주문이 등록되었습니다.\n", payOrder);
        }

        for (OrderItem item : payOrder.getOrderItemList()) {
            //같은 품목이면 원래 리스트에 orderQuantity 추가.
            //다른 품목이면 새로운 데이터로 추가.
            if (item.getProduct().equals(product)) {
                int originQuantity = item.getOrderQuantity();
                //더한게 양수인지 확인 -> 양수면 갱신 음수면 리스트 삭제
                boolean isPositive = item.tryAddOrderQuantity(newOrderQuantity);

                if (!isPositive) {
                    removeThisOrderItem = true;
                    //orderItemList.remove(orderItem); 이 아닌이유
                    find = true;
                    break;
                } else {
                    find = true;
                }
                // 기존데이터의 경우
                break;
            }
        }

        //기존 데이터 발견 X
        if (!find) {
            OrderItem orderItem = new OrderItem(product, newOrderQuantity);
            payOrder.addOrderItem(orderItem);
        }
        if (removeThisOrderItem) {
            //TODO 새로 만드는 것보다는 인덱스를 위에서 알아낸 다음 remove 하는 방향으로 바꾸기.
            OrderItem orderItem = new OrderItem(product, newOrderQuantity);
            payOrder.removeOrderItem(orderItem);
            return Result.success("성공적으로 주문이 삭제되었습니다.\n", payOrder);

        }
        //거래 진행 상황 출력

        return Result.success("성공적으로 주문이 등록되었습니다.\n", payOrder);

    }

    //TODO 해당 제품의 주문내역이 있을때 음수 가능 주문 내역 없으면 음수 불가능 구현 할 것.
    public boolean canRegistry(Order order, Product product, int quantity) {

        boolean isPresent = false;
        List<OrderItem> orderItemList = order.getOrderItemList();
        //등록할 제품이 이미 주문내역이 있다면 음수 가능
        for (OrderItem orderItem : orderItemList) {
            isPresent = orderItem.getProduct().equals(product);
            if (isPresent) break;
        }
        if (!isPresent && quantity < 0) return false;
        return true;

    }
}

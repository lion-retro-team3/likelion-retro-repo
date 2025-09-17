package order;

import order.domain.Order;
import order.domain.OrderItem;
import product.domain.Product;
import product.ProductService;
import util.Input;
import util.Result;

import java.util.List;
import java.util.Optional;

public class OrderSystem {

    private final ProductService productService;
    private final OrderService orderService;

    public OrderSystem() {
        this.productService = ProductService.getInstance();

        this.orderService = new OrderService();
    }

    private Result<Product> payProcessFindProduct() {

        Product productByCode;
        //결제 품목 추가
        String msg = "[결제] 상품 번호를 입력해주세요 -> ";
        //Input.inputInteger 안에서 유효값 입력 확인
        String inputCode = Input.inputInteger(msg);
        if (Input.isQuitCmd(inputCode)) {
            return Result.cancel("[결제] 를 취소했습니다.\n", null);
        }

        Long inputNum = Long.parseLong(inputCode);
        Optional<Product> byCode = productService.findByCode(inputNum);
        if (byCode.isEmpty()) {
            return Result.wait("[결제] 유효하지 않은 코드 입니다.", null);
        }
        productByCode = byCode.get();
        return Result.success("[결제] 상품코드 " + productByCode.getId() + " 를 입력하셨습니다.", productByCode);
    }

    public Result<OrderItem> payProcessCreateOrderItem(Product product) {

        OrderItem orderItem;
        String inputQuantity = Input.inputInteger("[결제] 주문 수량을 입력해주세요 -> ");
        if (Input.isQuitCmd(inputQuantity)) {
            return Result.cancel("[결제] 주문 수량 입력을 취소했습니다. 상품 선택으로 돌아갑니다.", null);
        }
        //정수 변환
        int quantityInt = Integer.parseInt(inputQuantity);
        orderItem = new OrderItem(quantityInt, product);
        return Result.success("[결제] 해당 주문 확인 중", orderItem);
    }

    public Result<Product> selectProductFromInput() {
        Result<Product> foundProduct;
        while (true) {
            foundProduct = payProcessFindProduct();
            if (foundProduct.isWait()) {
                System.out.println(foundProduct.getMsg());
            } else break;
        }
        return foundProduct;
    }

    //수량 입력
    public Result<Order> inputOrderQuantityForOrderItem(Order payOrder, OrderItem orderItem) {
        //수량 입력
        while (true) {

            //등록인지 수정인지 확인
            Optional<OrderItem> productInOrder = payOrder.findItemByProduct(orderItem);
            if (productInOrder.isPresent()) {
                Result<Order> payOrderResult = orderService.updateOrderItemInOrder(payOrder, productInOrder.get(), orderItem.getOrderQuantity());
                return payOrderResult;
            } else {
                Result<Order> payOrderResult = orderService.addOrderItemInOrder(payOrder, orderItem);
                System.out.println(payOrderResult.getMsg());
                if (payOrderResult.isSuccess()) {
                    return payOrderResult;
                }
            }
        }

    }

    public List<Order> getOrderLog() {
        return orderService.getOrderLog();
    }

    public void saveOrderLog(Order payOrder) {
        orderService.saveOrderLog(payOrder);
    }
}

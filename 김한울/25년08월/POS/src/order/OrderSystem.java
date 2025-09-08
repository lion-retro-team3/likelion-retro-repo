package order;

import product.Product;
import product.ProductService;
import util.Input;
import util.Result;

import java.util.Optional;

public class OrderSystem {

    private final ProductService productService;
    private final OrderService orderService;

    public OrderSystem() {
        this.productService = new ProductService();
        this.productService.createInit();
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
        return Result.success("[결제] 상품코드 " + productByCode.getCode() + " 를 입력하셨습니다.", productByCode);
    }

    private Result<OrderItem> payProcessCreateOrderItem(Product product) {

        OrderItem orderItem;
        String inputQuantity = Input.inputInteger("[결제] 주문 수량을 입력해주세요 -> ");
        if (Input.isQuitCmd(inputQuantity)) {
            return Result.cancel("[결제] 주문 수량 입력을 취소했습니다.", null);
        }
        //정수 변환
        int quantityInt = Integer.parseInt(inputQuantity);
        orderItem = new OrderItem(product, quantityInt);
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
        return  foundProduct;
    }

    //수량 입력
    public  Result<Order> temp(Order payOrder,Product foundProduct){
        Result<OrderItem> newOrderItemResult;
        while (true) {
            //수량 입력
            newOrderItemResult = this.payProcessCreateOrderItem(foundProduct);
            if (newOrderItemResult.isCancel()){
                return Result.cancel("주문 수량 입력을 취소하였습니다.",payOrder);
            }

            //등록인지 수정인지 확인
            OrderItem newOrderItem = newOrderItemResult.getData();
            Optional<OrderItem> productInOrder = orderService.findOrderItemInOrder(payOrder, newOrderItem);
            if (productInOrder.isPresent()) {
                Result<OrderItem> updatedOrderItem = orderService.updateOrderItemInOrder(productInOrder.get(), newOrderItem.getOrderQuantity());

                if (updatedOrderItem.isSuccess()) {
                    payOrder.updateTotalPrice();
                    System.out.println(updatedOrderItem.getMsg());
                    return Result.success("주문 수량이 수정되었습니다.",payOrder);
                }

            } else {
                Result<Order> addedOrderItem = orderService.addOrderItemInOrder(payOrder, newOrderItem);
                if (addedOrderItem.isSuccess()) {
                    payOrder.updateTotalPrice();
                    System.out.println(addedOrderItem.getMsg());
                    return Result.success("주문이 추가 되었습니다.",payOrder);
                }
            }

            if (newOrderItemResult.isCancel()) break;
            payOrder.showOrderList();
        }
        //주문리스트 등록 결과 처리
        payOrder.showOrderList();
        System.out.println("총 지불 금액 : " + payOrder.getTotalPrice() + " 원 입니다.");
        return Result.success("주문 등록이 성공했습니다.",payOrder);
    }

}

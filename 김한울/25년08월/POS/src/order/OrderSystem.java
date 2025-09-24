package order;

import order.domain.Order;
import order.domain.OrderItem;
import order.dto.OrderItemCreateDTO;
import product.ProductMapper;
import product.domain.Product;
import product.ProductService;
import product.dto.ProductDTO;
import util.Input;
import util.Result;

import java.util.List;
import java.util.Optional;

public class OrderSystem {

    private final ProductService productService;
    private final OrderService orderService;

    public OrderSystem() {
        this.productService = ProductService.getInstance();
        this.orderService = OrderService.getInstance();
    }

    private Result<ProductDTO> payProcessFindProduct() {

        //결제 품목 추가
        String msg = "[결제] 상품 번호를 입력해주세요 -> ";
        //Input.inputInteger 안에서 유효값 입력 확인
        String inputCode = Input.inputInteger(msg);
        if (Input.isQuitCmd(inputCode)) {
            return Result.cancel("[결제] 를 취소했습니다.\n", null);
        }

        Long inputNum = Long.parseLong(inputCode);
        Product byCode = productService.findById(inputNum);
        if (byCode == null) {
            return Result.wait("[결제] 유효하지 않은 코드 입니다.", null);
        }
        ProductDTO productDTO = ProductMapper.toDTO(byCode);
        return Result.success("[결제] 상품코드 " + byCode.getId() + " 를 입력하셨습니다.", productDTO);
    }

    //TODO ===================작업 진행중
    public Result<OrderItem> payProcessCreateOrderItem(ProductDTO productDTO) {

        OrderItemCreateDTO orderItem;
        String inputQuantity = Input.inputInteger("[결제] 주문 수량을 입력해주세요 -> ");
        if (Input.isQuitCmd(inputQuantity)) {
            return Result.cancel("[결제] 주문 수량 입력을 취소했습니다. 상품 선택으로 돌아갑니다.", null);
        }
        //정수 변환
        int quantityInt = Integer.parseInt(inputQuantity);
        //TODO service 코드로 이관
        orderItem = new OrderItemCreateDTO(productDTO.getId(),quantityInt,productDTO.getPrice());
        return Result.success("[결제] 해당 주문 확인 중", orderItem);
    }

    public Result<ProductDTO> selectProductFromInput() {
        Result<ProductDTO> foundProductDTO;
        while (true) {
            foundProductDTO = payProcessFindProduct();
            if (foundProductDTO.isWait()) {
                System.out.println(foundProductDTO.getMsg());
            } else break;
        }
        return foundProductDTO;
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
        List<Order> orderList = orderService.getOrderList();
        return orderList;
    }

    public void saveOrder(Order payOrder) {
//작성하기
    }
}

import order.OrderSystem;
import payment.Cash;
import payment.Credit;
import payment.Payment;
import menu.SystemMenu;
import order.domain.Order;
import order.domain.OrderItem;
import payment.PaymentType;
import product.ProductService;
import product.dto.ProductDTO;
import util.Result;
import pay.PayService;
import util.Input;

import java.util.*;

public class POS_System {

    private final ProductService productService;
    private final PayService payService;
    private final OrderSystem orderSystem;

    public POS_System() {
        this.productService = ProductService.getInstance();
        this.payService = PayService.getInstance();
        this.orderSystem = new OrderSystem();
    }

    public void start() {

        StringBuilder sb = new StringBuilder();
        while (true) {
            this.showSystemMenu();
            SystemMenu choice = SystemMenu.findByCode(Input.inputInteger());
            String description = choice.getDescription();
            sb.append("[").append(description).append("]").append(" 를 선택하셨습니다.\n");
            switch (choice) {

                case SYSTEM_EXIT -> {
                    System.out.println(sb);
                    sb.setLength(0);
                    return;
                }
                case PRODUCT_PAY -> {
                    //상품 결제
                    System.out.println(sb);
                    processProductPay();
                    sb.setLength(0);
                }
                case PRODUCT_ORDER -> {
                    //상품 발주
                    System.out.println(sb);
                    sb.setLength(0);
                }
                case STOCK_CHECK -> {
                    //재고 확인
                    System.out.println(sb);
                    System.out.println("================================");
                    System.out.println("[재고 확인]");
                    //todo 재고확인
                    System.out.println(productService.getAllSortedByStockQuantity().toString());
                    System.out.println("================================");
                    sb.setLength(0);
                }
                case HISTORY_CHECK -> {
                    //기록 조회
                    System.out.println(sb);
                    this.showOrderLog();
                    sb.setLength(0);
                }
                case PRODUCT_REFUND -> {
                    //환불
                    System.out.println(sb);
                    sb.setLength(0);
                }
                case DISPOSAL_REGISTRATION -> {
                    //폐기 등록
                    System.out.println(sb);
                    sb.setLength(0);
                }
                default -> {
                    System.out.println("잘못된 입력입니다.");
                    sb.setLength(0);
                }
            }


        }

    }


    private void showOrderLog() {
        List<Order> orderLog = orderSystem.getOrderLog();
        if (orderLog.isEmpty()) {
            System.out.println("현재 주문 내역이 없습니다.");
        } else {
            System.out.println(orderLog);
        }
    }

    private void showProductList() {
        System.out.println(productService.getAllSortedById().toString());
    }

    public void showSystemMenu() {
        StringBuilder menu = new StringBuilder();
        int i = 0;
        System.out.println("==================================");
        for (SystemMenu systemMenu : SystemMenu.values()) {
            if (systemMenu == SystemMenu.SYSTEM_ERROR) continue;
            menu.append(i).append(". ").append(systemMenu.getDescription()).append("\t");
            if (i % 3 == 0) menu.append("\n");
            i++;
        }
        System.out.println(menu);
        System.out.println("==================================");
        System.out.print("[메뉴] 번호를 입력해주세요 → ");
    }

    public void processProductPay() {
        System.out.println("[결제]==================================");
        System.out.println("******************************[상품 리스트]************************************************************");
        showProductList();
        System.out.println("******************************************************************************************");

        //결제 진행 상황 리스트
        List<OrderItem> orderItemList = new ArrayList<>();
        Order payOrder = new Order(orderItemList);

        Result<ProductDTO> foundProduct;
        while (true) {
            //1.상품 찾기
            //성공 -> 주문등록
            //취소 -> 메뉴화면 or 결제화면
            //대기 -> 상품 코드 재입력
            foundProduct = orderSystem.selectProductFromInput();
            if (foundProduct.isWait()) {
                System.out.println(foundProduct.getMsg());
            }

            //2.상품 찾기 후 처리
            //TODO if문으로 처리하면 확장, 수정에 너무 어려움 핸들러로 처리
            if (foundProduct.isCancel()) {
                System.out.println("[결제] 상품 선택 취소. 남아있는 주문이 있다면 결제 수단 선택으로 넘어가겠습니다.");
                break;
            }

            //3.주문 수량 입력하기
            //성공 -> 등록 결과처리
            //취소 -> 1. 상품 찾기
            //실패 -> 재입력
            Result<OrderItem> newOrderItemResult = orderSystem.payProcessCreateOrderItem(foundProduct.getData());
            if (!newOrderItemResult.isCancel()) {

                //4.주문 수량 입력 후 처리
                Result<Order> orderResult = orderSystem.inputOrderQuantityForOrderItem(payOrder, newOrderItemResult.getData());
                if (orderResult.isCancel()) {
                    System.out.println("[결제] 를 취소합니다. 상품 선택으로 돌아갑니다.");
                }
                payOrder.showOrderList();
                System.out.println("총 지불 금액 : " + payOrder.getTotalPrice() + " 원 입니다.");
            }


        }


        //결제 방법 선택
        int start = 1, end = 3;
        if (payOrder.hasOrderItemList()) {
            String paymentMsg = "[결제] 결제 수단 번호를 입력해주세요\n" +
                    "1. 현금 결제\t2. 카드 결제\t3. 취소 -> ";
            String pickPayment = Input.inputInteger(paymentMsg, start, end);
            int paymentCode = Integer.parseInt(pickPayment);
            Optional<PaymentType> selectedPaymentType = PaymentType.findByCode(paymentCode);
            selectedPaymentType.ifPresentOrElse(
                    paymentType -> {
                        Payment payment = Payment.create(paymentType);
                        int amount = 0;
                        //지불 금액 설정
                        if (payment instanceof Credit) amount = payOrder.getTotalPrice();
                        else if (payment instanceof Cash) {
                            String amountString = Input.inputInteger("[결제 방법] 현금 결제 금액을 입력해주세요 -> ", 0, Integer.MAX_VALUE);
                            amount = Integer.parseInt(amountString);

                        }

                        Result<Order> payResult = payService.pay(payOrder, payment, amount);
                        System.out.println(payResult.getMsg());
                        orderSystem.saveOrder(payOrder);

                        //결과
                        if (payOrder.isSuccess()) {
                            System.out.println("잔액은 " + payment.getAmount() + " 원 입니다.");
                        }
                    }, () -> {
                        System.out.println("[결제] 취소를 선택했습니다.");
                        payOrder.cancel();
                        orderSystem.saveOrder(payOrder);
                    }
            );


        } else {
            System.out.println("결제할 상품이 없습니다.\n");
        }

        System.out.println("==================================");
    }


}

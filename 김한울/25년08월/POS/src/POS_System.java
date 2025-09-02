import payment.Cash;
import payment.Credit;
import payment.Payment;
import menu.SystemMenu;
import order.Order;
import order.OrderItem;
import order.OrderService;
import payment.PaymentType;
import product.ProductService;
import repository.ProductRepo;
import util.Result;
import pay.PayService;
import util.Input;

import java.util.*;


public class POS_System {


    private final PayService payService;
    private final OrderService orderService;
    private ProductService productService;


    public POS_System() {
        this.payService = new PayService();
        this.orderService = new OrderService();
        this.productService = new ProductService();
        this.productService.createInit();
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
        Optional<List<Order>> orderLog = orderService.getOrderLog();
        orderLog.ifPresentOrElse(
                logs -> {
                    System.out.println(logs.toString());
                },() -> {
                    System.out.println("[기록 조회] 현재 기록이 없습니다.");
        }
        );
    }

    private void showProductList() {
        System.out.println(productService.getAllSortedByCode().toString());
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
        boolean hasMoreProductsToAdd = true;

        //품목 추가중
        while (hasMoreProductsToAdd) {
            //결제 품목 추가
            String msg = "[결제] 상품 번호를 입력해주세요 -> ";
            //Input.inputInteger 안에서 유효값 입력 확인
            String inputCode = Input.inputInteger(msg);
            if (isQuitCmd(inputCode)) break;
            //물품 추가 프로세스
            Long inputNum = Long.valueOf(inputCode);
            productService.findByCode(inputNum).ifPresentOrElse(
                    findProduct -> {
                        System.out.print("[결제] 주문 수량을 입력해주세요 -> ");
                        int inputQuantity = Input.inputInteger();
                        //TODO 주문내역이 있을때 음수 가능 주문 내역 없으면 음수 불가능 구현 할 것.

                        //boolean canRegistry = orderService.canRegistry(payOrder, findProduct, inputQuantity);
                        String payMsg = orderService.registryOrderItem(payOrder,findProduct,inputQuantity).getMsg();
                        System.out.print(payMsg);
                        payOrder.showOrderList();
                        System.out.println("총 지불 금액 : " + payOrder.getTotalPrice() + " 원 입니다.");
                    }, () -> {
                        System.out.println("유효하지 않은 코드입니다.");
                    }
            );

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
                        if (payment instanceof Credit) amount =payOrder.getTotalPrice();
                        else if(payment instanceof Cash){
                            String amountString = Input.inputInteger("[결제 방법] 현금 결제 금액을 입력해주세요 -> ",0,Integer.MAX_VALUE);
                            amount = Integer.parseInt(amountString);

                        }

                        Result<Order> payResult = payService.pay(payOrder, payment,amount);
                        System.out.println(payResult.getMsg());
                        orderService.saveOrderLog(payOrder);

                        //결과
                        if (payOrder.isSuccess()) {
                            System.out.println("잔액은 " + payment.getAmount() + " 원 입니다.");
                        }
                    }, () -> {
                        System.out.println("[결제] 취소를 선택했습니다.");
                        payOrder.cancel();
                        orderService.saveOrderLog(payOrder);
                    }
            );



        } else {
            System.out.println("결제할 상품이 없습니다.\n");
        }

        System.out.println("==================================");
    }


    //확장성 확보, 추후 다른 종료 cmd 추가시 확장 가능
    private boolean isQuitCmd(String input) {
        return input.equals("quit");
    }


}

import payment.Credit;
import payment.Payment;
import menu.SystemMenu;
import order.Order;
import order.OrderItem;
import order.OrderService;
import payment.PaymentType;
import product.Product;
import repository.ProductRepo;
import util.Result;
import pay.PayService;
import util.Input;
import util.Status;

import java.util.*;


public class POS_System {


    private final PayService payService;
    private final OrderService orderService;
    private Map<Long, Product> productMapKeyByCode; //물건 리스트
    private List<Order> orderLog; //거래 내역

    public POS_System() {
        this.payService = new PayService();
        this.orderService = new OrderService();
        this.productMapKeyByCode = new HashMap<>();
        ProductRepo.initTestProduct(this.productMapKeyByCode);
        orderLog = new ArrayList<>();
    }

    public void start() {

        StringBuilder sb = new StringBuilder();
        while (true) {
            this.showInfo();
            SystemMenu choice = Input.inputMenu();
            String description = choice.getDescription();
            sb.append("[").append(description).append("]").append(" 를 선택하셨습니다.\n");
            switch (choice) {

                case SYSTEM_EXIT -> {
                    System.out.println(sb);
                    sb.setLength(0);
                    //this.programExit();
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
                    for (Product product : productMapKeyByCode.values()) {
                        System.out.print(product.toString());;
                    }
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
        System.out.println(orderLog.toString());
    }

    public void showProductList() {
        System.out.println(productMapKeyByCode.toString());
    }

    public void showInfo() {
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
        boolean addmore = true;

        //품목 추가중
        while (addmore) {
            //결제 품목 추가
            String msg = "[결제] 상품 번호를 입력해주세요 -> ";
            //Input.inputInteger 안에서 유효값 입력 확인
            String inputCode = Input.inputInteger(msg);
            if (inputCode.equals("quit")) {
                addmore = false;
                break;
            }
            //물품 추가 프로세스
            Long inputNum = Long.valueOf(inputCode);
            Product scanProduct = productMapKeyByCode.get(inputNum);
            if (orderService.isInvalidProduct(scanProduct)) {
                System.out.println("유효하지 않은 코드입니다.");
            } else {
                System.out.print("[결제] 주문 수량을 입력해주세요 -> ");
                int inputQuantity = Input.inputInteger();
                String payMsg = payOrder.process(scanProduct, inputQuantity).getMsg();
                System.out.print(payMsg);
                payOrder.showOrderList();
                int tempTotalPrice = payOrder.sumTotalPrice();
                System.out.println("총 지불 금액 : " + tempTotalPrice + " 원 입니다.");
            }
        }


        //결제 방법 선택
        int start = 1, end = 3;

        if (!payOrder.getOrderItemList().isEmpty()) {
            String paymentMsg = "[결제] 결제 수단 번호를 입력해주세요\n" +
                    "1. 현금 결제\t2. 카드 결제\t3. 취소 -> ";
            String pickPayment = Input.inputInteger(paymentMsg, start, end);
            int paymentCode = Integer.parseInt(pickPayment);
            //enum 개수보다 크다면 취소로 판단
            if (paymentCode > PaymentType.values().length) {
                System.out.println("[결제] 취소를 선택했습니다.");
                payOrder.setStatus(Status.CANCEL);
                orderLog.add(payOrder);
                return;
            }
            PaymentType byCode = PaymentType.findByCode(paymentCode);
            Payment payment = Payment.create(byCode);

            //추후 bank가 생긴다면 계좌 등으로 연결 가능
            if (payment instanceof Credit) payment.setAmount(payOrder.getTotalPrice());

            Result<Order> payResult = payService.pay(payOrder, payment);
            System.out.println(payResult.getMsg());

            orderLog.add(payOrder);
            if (payResult.getStatus()== Status.SUCCESS){
                System.out.println("잔액은 " + payment.getAmount() + " 원 입니다.");
            }
        } else {
            System.out.println("결제할 상품이 없습니다.\n");
        }

        System.out.println("==================================");
    }


}

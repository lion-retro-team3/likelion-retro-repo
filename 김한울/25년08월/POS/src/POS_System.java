import payment.Cash;
import payment.Credit;
import payment.Payment;
import menu.SystemMenu;
import order.Order;
import order.OrderItem;
import order.OrderService;
import payment.PaymentType;
import product.Product;
import product.ProductService;
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

    private boolean isQuitCmd(String input) {
        return input.equals("quit");
    }

    private void showOrderLog() {
        Optional<List<Order>> orderLog = orderService.getOrderLog();
        orderLog.ifPresentOrElse(
                logs -> {
                    System.out.println(logs.toString());
                }, () -> {
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

        //1.상품 찾기
        //성공 -> 주문등록
        //취소 -> 메뉴화면
        //대기 -> 상품 코드 재입력
        Result<Optional<Product>> findResult;

        while (true) {
            findResult = payProcessFindProduct();
            if (!findResult.isWait()) break;
        }

        //1.상품 찾기 -> Result
        //TODO if문으로 처리하면 확장, 수정에 너무 어려움 핸들러로 처리
        if (findResult.isCancel()) {
            System.out.println("[결제] 를 취소합니다. 메인화면으로 돌아갑니다.");
            return;
        }

        //2.주문수량 입력하기
        //성공 -> 등록 결과처리
        //취소 -> 메뉴화면
        //실패 -> 재입력
        Result<Optional<OrderItem>> findOrderItemResult;
        Product findProduct = findResult.getData().get();
        while (true) {
            //수량 입력
            findOrderItemResult = this.payProcessCreateOrderItem(findProduct);
            if (findOrderItemResult.isCancel()) break;
            
            //등록인지 수정인지 확인
            OrderItem findOrderItem = findOrderItemResult.getData().get();
            boolean isAdd = orderService.hasProductInOrder(payOrder,findOrderItem);
            if (isAdd){
                orderService.addOrderItemInOrder(payOrder, orderItem);

            } else {
                orderService.updateOrderItemInOrder(payOrder, orderItem);

            }
            //등록, 수정
            OrderItem orderItem = findOrderItem;

            if (!findOrderItemResult.isWait()) break;
            //System.out.println(findOrderItemResult.getMsg());
        }


        //3.주문 리스트에 등록 or 수정xxxxxxv/ㅍ., ;/'+
        OrderItem findOrderItem = findOrderItemResult.getData().get();
        //Result<Order> addResult = orderService.addOrderItem(payOrder, findOrderItem);

        //주문리스트 등록 결과 처리
        payOrder.showOrderList();
        System.out.println("총 지불 금액 : " + payOrder.getTotalPrice() + " 원 입니다.");

        //4.결제하기
        payProcessPayment();

        //Result<Order> orderResult = addOrderItem(payOrder);


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

    private Result<Optional<Product>> payProcessFindProduct() {

        Optional<Product> productByCode = Optional.empty();
        //결제 품목 추가
        String msg = "[결제] 상품 번호를 입력해주세요 -> ";
        //Input.inputInteger 안에서 유효값 입력 확인
        String inputCode = Input.inputInteger(msg);
        if (isQuitCmd(inputCode)) {
            return Result.cancel("[결제] 를 취소했습니다.\n", productByCode);
        }

        Long inputNum = Long.parseLong(inputCode);
        productByCode = productService.findByCode(inputNum);
        if (productByCode.isEmpty()) {
            return Result.wait("[결제] 유효하지 않은 코드 입니다.", productByCode);
        }
        return Result.success("[결제] 상품코드 " + productByCode.get().getCode() + " 를 입력하셨습니다.", productByCode);
    }



    private Result<Optional<OrderItem>> payProcessCreateOrderItem(Product product) {

        Optional<OrderItem> orderItem = Optional.empty();
        String inputQuantity = Input.inputInteger("[결제] 주문 수량을 입력해주세요 -> ");
        if (isQuitCmd(inputQuantity)) {
            return Result.cancel("[결제] 주문 수량 입력을 취소했습니다.", null);
        }
        //정수 변환
        int quantityInt = Integer.parseInt(inputQuantity);
        orderItem = Optional.of(new OrderItem(product, quantityInt));
        return Result.success("[결제] 해당 주문 확인 중",orderItem);
    }


    //상품 결제
    private void payProcessPayment() {
    }

}

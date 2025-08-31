import menu.SystemMenu;
import order.Order;
import order.OrderItem;
import order.OrderService;
import product.Product;
import repo.ProductRepo;
import service.PayService;
import util.Input;

import java.util.*;


public class POS_System {


    private final PayService payService;
    private final OrderService orderService;
    private Map<Long,Product> productMapKeyByCode; //물건 리스트

    public POS_System() {
        this.payService = new PayService();
        this.orderService = new OrderService();
        this.productMapKeyByCode = new HashMap<>();
        ProductRepo.initTestProduct(this.productMapKeyByCode);
    }

    public void start() {

        StringBuilder sb = new StringBuilder();
        while (true) {
            this.showInfo();
            SystemMenu choice = Input.inputMenu();
            String description = choice.getDescription();
            sb.append("[").append(description).append("]").append(" 를 선택하셨습니다.\n");
            switch (choice) {

                case  SYSTEM_EXIT-> {
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
                    sb.setLength(0);
                }
                case BALANCE_CHECK -> {
                    //잔고 확인
                    System.out.println(sb);
                    sb.setLength(0);
                }
                case HISTORY_CHECK -> {
                    //거래 기록 확인
                    System.out.println(sb);
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

    public void showProductList(){
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
        boolean addmore =true;

        while (addmore){
            //결제 품목 추가
            String msg = "[결제] 품목 상품 번호를 입력해주세요 -> ";
            String inputcode = String.valueOf(Input.inputInteger(msg));
            Long inputCode = Long.valueOf(inputcode);
            Product scanProduct = productMapKeyByCode.get(inputCode);
            if (orderService.isInvalidProduct(scanProduct)) {
                System.out.println("유효하지 않은 코드입니다.");
            } else {
                System.out.print("[결제] 주문 수량을 입력해주세요 -> ");
                int inputQuantity = Input.inputInteger();

                //TODO : 재고수량을 넘지 못해야한다.
                String payMsg = payOrder.process(scanProduct, inputQuantity).getMsg();
                System.out.print(payMsg);
                payOrder.showOrderList();

            }
        }

        //Order order =new Order();

        //결제 방법 선택
        
        //결제
        //payService.pay()

        System.out.println("==================================");
    }


}

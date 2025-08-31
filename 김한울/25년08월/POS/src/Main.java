import order.Order;
import service.PayService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
         *  POS 시스템
         *  계정 : 사번, 비밀번호
         *  일반, 관리자
         *  물품 : 바코드(고유식별번호), 이름, 가격, 재고량, 행사 여부, 바코드,)
         *  카테고리: 스낵,음료수,주류,담배,음식
         *  행사 : 특정 카드사 할인, 2 + 1, 1 + 1 , xxx원할인 , 묶음상품
         *
         * 1. 손님 물건 구매
         * 1-a 카드 결제 -> 할인 수단 확인 ->포인트 적립 확인 ->결제완료
         * 1-b 현금 결제 -> 현금영수증 확인 -> 결제완료
         * 2. 물건 발주
         * 3. 재고, 유통기한 확인
         * 4. 잔고 확인
         * 5. 기록 확인 (금고 열기, 결제 )
         * 6. 폐기처리
         * 7. 반품, -> 전체 환불, 부분 환불
         * 8. 결제보류
         * 9. ...
         **/


        POS_System posSystem = new POS_System();
        Scanner input = new Scanner(System.in);
        int menuSize = SystemMenu.values().length;
        posSystem.showInfo();
/*        int menuInput = input.nextInt();*/





    }
}
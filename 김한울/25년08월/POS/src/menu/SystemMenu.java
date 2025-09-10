package menu;

public enum SystemMenu {

    SYSTEM_EXIT(0,"시스템 종료"),
    SYSTEM_ERROR(-1,"비정상적 접근"),
    PRODUCT_PAY(1,"상품 결제"),
    PRODUCT_ORDER(2,"상품 발주"),
    STOCK_CHECK(3,"재고 확인"),
    HISTORY_CHECK(4,"기록 조회"),
    DISPOSAL_REGISTRATION(5,"폐기 등록"),
    PRODUCT_REFUND(6,"상품 환불");


    private final String description;
    private final int code;


    SystemMenu(int code,  String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    public static SystemMenu findByCode(int code){

        for (SystemMenu sm : SystemMenu.values()) {
            if (sm.getCode()== code) return sm;
        }
        return SystemMenu.SYSTEM_ERROR;
    }
}


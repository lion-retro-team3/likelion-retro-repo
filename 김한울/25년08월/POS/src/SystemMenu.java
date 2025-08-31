public enum SystemMenu {

    PRODUCT_PAY("상품 결제"),
    PRODUCT_ORDER("상품 발주"),
    STOCK_CHECK("재고 확인"),
    BALANCE_CHECK("잔고 확인"),
    HISTORY_CHECK("기록 조회"),
    DISPOSAL_REGISTRATION("폐기 등록"),
    PRODUCT_REFUND("상품 환불"),
    SYSTEM_EXIT("시스템 종료");

    private final String description;

    SystemMenu(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


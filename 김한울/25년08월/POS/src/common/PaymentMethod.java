package common;

public enum PaymentMethod {

    CASH("현금"),
    CREDIT("카드");

    private final String method;

    PaymentMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}

package payment;

public enum PaymentType {
    CASH(1), CREDIT(2);

    private final int code;

    PaymentType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static PaymentType findByCode(int code) {

        for (PaymentType type : PaymentType.values()) {
            if (type.getCode() == code) return type;
        }
        return null;
    }

}

package payment;

import java.util.Optional;

public enum PaymentType {
    CASH(1), CREDIT(2);

    private final int code;

    PaymentType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Optional<PaymentType> findByCode(int code) {
        PaymentType find = null;
        for (PaymentType type : PaymentType.values()) {
            if (type.getCode() == code) find = type;
        }
        return Optional.ofNullable(find);
    }


}

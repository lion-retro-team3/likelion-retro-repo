package payment;

public class Cash extends Payment {

    public Cash() {
    }

    public Cash(int amount) {
        super(amount);
    }

    @Override
    public boolean pay(int totalPrice) {
        this.decrease(totalPrice);
        return true;
    }

    @Override
    public boolean cancel() {
        return false;
    }

    @Override
    public boolean refund() {
        return false;
    }
}

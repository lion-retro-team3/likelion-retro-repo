package payment;

public class Credit extends Payment{

    public Credit() {
    }

    public Credit(int amount) {
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

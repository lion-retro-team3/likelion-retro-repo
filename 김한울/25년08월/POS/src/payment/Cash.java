package payment;

public class Cash extends Payment {

    public Cash() {
    }

    public Cash(int amount) {
        super(amount);
    }

    @Override
    public void confirm(int totalPrice) {
        int amount = this.getAmount() - totalPrice;
        this.setAmount(amount);
    }

}

package payment;

public class Credit extends Payment{

    public Credit() {
    }

    public Credit(int amount) {
        super(amount);
    }

    @Override
    public void confirm(int totalPrice) {

        int amount = this.getAmount() - totalPrice;
        this.setAmount(amount);
    }
}

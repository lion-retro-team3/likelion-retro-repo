package common;

public abstract class Payment {
    int amount;

    public Payment(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean canPay(int totalPrice){
        return amount > totalPrice;
    }

    public abstract void confirm(int totalPrice);
}

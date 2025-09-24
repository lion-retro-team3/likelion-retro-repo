package payment;

public abstract class Payment implements Payable,Revertable{
    int amount;

    public Payment() {
        this.amount=0;
    }

    public Payment(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void setAmount(int amount) {
        this.amount = amount;
    }

    public void increase(int amount){
        this.setAmount(this.getAmount()+amount);
    }

    public void decrease(int amount){
        this.setAmount(this.getAmount()-amount);
    }
    public boolean canPay(int totalPrice){
        return this.amount >= totalPrice;
    }

    //입력범위 제한으로 스위치 문 밖으로 나가지 않음.
    public static Payment create(PaymentType method){

        Payment payment = null;
        switch (method){
            case CASH:{
                payment = new Cash();
                break;
            }
            case CREDIT:{
                payment = new Credit();
                break;
            }
        }

        return payment;

    }


}

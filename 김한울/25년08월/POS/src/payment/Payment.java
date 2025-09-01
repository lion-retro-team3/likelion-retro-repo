package payment;

import util.Input;

public abstract class Payment {
    int amount;

    public Payment() {
    }

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
        return this.amount >= totalPrice;
    }

    public abstract void confirm(int totalPrice);

    //입력범위 제한으로 스위치 문 밖으로 나가지 않음.
    public static Payment create(PaymentType method){

        Payment payment = null;
        switch (method){
            case CASH:{
                String amountString = Input.inputInteger("[결제 방법] 현금 결제 금액을 입력해주세요 -> ",0,Integer.MAX_VALUE);
                int amount = Integer.parseInt(amountString);
                payment = new Cash(amount);
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

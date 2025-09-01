package pay;

import payment.Payment;
import order.Order;
import util.Result;
import util.Status;

public class PayService {

    //결제
    public Result<Order> pay(Order order, Payment method){

        //1. 결제 금액 확인
        int payment = order.getTotalPrice();

        //test

        //2. 결제 시도
        boolean canPay = method.canPay(order.getTotalPrice());
        if (!canPay) {
            order.setStatus(Status.FAIL);
            return Result.fail("잔액이 부족합니다.\n", order);
        }

        //3. 결제 완료
        method.confirm(payment);
        order.confirm();

        return Result.success("결제가 성공했습니다.\n", order);

    }


}

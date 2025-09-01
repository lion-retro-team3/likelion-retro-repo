package service;

import common.Payment;
import order.Order;
import result.Result;

public class PayService {

    //결제
    public Result<Order> pay(Order order, Payment method){

        //0. 행사 미적용 금액
        int payment = order.getTotalPrice();
        
        //1. 행사 적용
        //코드 나중에 추가

        //test

        //2. 결제 시도
        boolean canPay = method.canPay(order.getTotalPrice());
        if (!canPay) return Result.fail("잔액이 부족합니다.\n", order);

        //3. 결제 완료
        method.confirm(payment);
        order.confirm();

        return Result.success("결제가 성공했습니다.\n", order);

    }


}

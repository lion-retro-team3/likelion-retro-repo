package service;

import common.PaymentMethod;
import order.Order;
import result.Result;

public class PayService {

    //결제
    public Result<Order> pay(Order order, PaymentMethod method){

        switch (method){
        }



        return Result.success("결제가 성공했습니다.\n", order);

    }


}

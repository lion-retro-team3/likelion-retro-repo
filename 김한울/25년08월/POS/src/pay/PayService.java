package pay;

import order.OrderService;
import payment.Payment;
import order.domain.Order;
import util.Result;

public class PayService {

    private static final PayService INSTANCE = new PayService();

    public static PayService getInstance()
    {
        return INSTANCE;
    }

    private PayService() {
    }

    //결제
    public Result<Order> pay(Order order, Payment method,int tryAmount){

        //1. 결제 금액 확인
        int totalPrice = order.getTotalPrice();
        
        //받은 금액 세팅
        method.increase(tryAmount);
        //2. 결제 시도
        if (method.getAmount() < totalPrice){
            order.cancel();
            return Result.cancel("잔액이 부족합니다.\n", order);
        }

        //3. 결제 완료
        method.pay(totalPrice);
        order.confirm();

        return Result.success("결제가 성공했습니다.\n", order);
    }


}

package Mini_Project;

import Mini_Project.Restaurant.Restaurant_Info;
import Mini_Project.Restaurant.Menu_Item;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<OrderItem> orderList = new ArrayList<>();
    public void addOrder(Menu_Item menuItem, Restaurant_Info restaurantInfo) {
        //System.out.println("체크포인트2");
        OrderItem orderItem=new OrderItem(restaurantInfo.getRestaurant_name(),menuItem.getName(),menuItem.getPrice());
        orderList.add(orderItem);
    }
    public void printAllOrders() {
        int sumPrice = 0;

        if (orderList.isEmpty()) {
            System.out.println("\n⚠️  현재 주문한 음식이 없습니다.\n");
        } else {
            System.out.println("\n==============================");
            System.out.println("       📋 전체 주문 목록");
            System.out.println("==============================");

            int index = 1;
            for (OrderItem orderItem : orderList) {
                System.out.printf("%2d) [%-8s] %-10s %6d원%n",
                        index++,
                        orderItem.getRestaurantName(),
                        orderItem.getMenuName(),
                        orderItem.getPrice()
                );
                sumPrice += orderItem.getPrice();
            }

            System.out.println("------------------------------");
            System.out.printf("💰 총 주문 금액: %d원%n", sumPrice);
            System.out.println("==============================\n");
        }
    }
    //public void
}

package Mini_Project.Restaurant;

import Mini_Project.OrderManager;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Korean_Restaurant extends AbstractRestaurant {
    private Scanner sc;

    public Korean_Restaurant(Scanner sc, OrderManager orderManager) {
        super(sc,orderManager);
        RestaurantList = Arrays.asList(
                new Restaurant_Info("멋사식당", Arrays.asList(
                        new Menu_Item("비빔밥", 8000),
                        new Menu_Item("불고기", 12000),
                        new Menu_Item("김치찌개", 7000)
                )),
                new Restaurant_Info("자바백반", Arrays.asList(
                        new Menu_Item("된장찌개", 7000),
                        new Menu_Item("갈비탕", 13000),
                        new Menu_Item("파전", 10000)
                ))
        );
    }
}

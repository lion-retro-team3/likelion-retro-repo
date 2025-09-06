package Mini_Project.Restaurant;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import Mini_Project.OrderManager;
import Mini_Project.Restaurant.Restaurant_Info;

public class Western_Restaurant extends AbstractRestaurant {
    private Scanner sc;

    public Western_Restaurant(Scanner sc, OrderManager orderManager) {
        super(sc,orderManager);
        RestaurantList = Arrays.asList(
                new Restaurant_Info("멋사레스토랑", Arrays.asList(
                        new Menu_Item("스파게티", 12000),
                        new Menu_Item("피자", 15000),
                        new Menu_Item("리조또", 13000)
                )),
                new Restaurant_Info("자바스테이크", Arrays.asList(
                        new Menu_Item("안심스테이크", 25000),
                        new Menu_Item("립아이", 30000),
                        new Menu_Item("샐러드", 10000)
                ))
        );
    }

}

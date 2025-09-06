package Mini_Project.Restaurant;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import Mini_Project.OrderManager;
import Mini_Project.Restaurant.Restaurant_Info;

public class Japanese_Restaurant extends AbstractRestaurant {
    private Scanner sc;

    public Japanese_Restaurant(Scanner sc, OrderManager orderManager) {
        super(sc,orderManager);
        RestaurantList = Arrays.asList(
                new Restaurant_Info("자바스시", Arrays.asList(
                        new Menu_Item("스시세트", 15000),
                        new Menu_Item("사시미", 20000),
                        new Menu_Item("우동", 8000)
                )),
                new Restaurant_Info("멋사라멘", Arrays.asList(
                        new Menu_Item("쇼유라멘", 9000),
                        new Menu_Item("미소라멘", 9500),
                        new Menu_Item("돈코츠라멘", 10000)
                ))
        );
    }
}

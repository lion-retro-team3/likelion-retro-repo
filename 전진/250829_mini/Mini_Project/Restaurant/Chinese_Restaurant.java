package Mini_Project.Restaurant;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import Mini_Project.OrderManager;
import Mini_Project.Restaurant.Restaurant_Info;

public class Chinese_Restaurant extends AbstractRestaurant {
    private Scanner sc;

    public Chinese_Restaurant(Scanner sc, OrderManager orderManager) {
        super(sc,orderManager);
        RestaurantList= Arrays.asList(
                new Restaurant_Info("자바반점", Arrays.asList(
                        new Menu_Item("짜장면",5000),
                        new Menu_Item("짬뽕",6000),
                        new Menu_Item("탕수육",15000)
                )),
                new Restaurant_Info("멋사에용", Arrays.asList(
                        new Menu_Item("마파두부",20000),
                        new Menu_Item("팔보채",30000),
                        new Menu_Item("깐풍기",40000)
                ))
        );
    }

}

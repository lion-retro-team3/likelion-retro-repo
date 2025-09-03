package Mini_Project.Restaurant;

import Mini_Project.OrderItem;
import Mini_Project.OrderManager;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractRestaurant {
    private Scanner sc;
    protected List<Restaurant_Info> RestaurantList;
    protected OrderManager orderManager;

    public AbstractRestaurant(Scanner sc,OrderManager orderManager) {
        this.sc = sc;
        this.orderManager = orderManager;
    }


    public void chooseRestaurant() {
        System.out.println("\n==============================");
        System.out.println(" 🍽️  음식점을 선택하세요");
        System.out.println("==============================");

        int index = 1;
        for (Restaurant_Info r : RestaurantList) {
            System.out.printf("%2d) %s%n", index++, r.getRestaurant_name());
        }

        System.out.println("------------------------------");

        while (true) {
            System.out.print("👉 입력 : ");
            String choice = sc.nextLine();
            boolean checker = false;

            for (Restaurant_Info r : RestaurantList) {
                if (r.getRestaurant_name().equals(choice)) {
                    chooseMenu(r);
                    checker = true;
                    break;
                }
            }

            if (checker) break; // 정상 입력 시 종료
            System.out.println("⚠️  리스트에 존재하지 않는 음식점입니다. 다시 입력해주세요.");
        }
    }

    public void chooseMenu(Restaurant_Info restaurantInfo) {
        System.out.println("\n==============================");
        System.out.printf(" 🍴 %s - 메뉴 선택%n", restaurantInfo.getRestaurant_name());
        System.out.println("==============================");

        int index = 1;
        for (Menu_Item m : restaurantInfo.getMenuList()) {
            System.out.printf("%2d) %-10s %6d원%n", index++, m.getName(), m.getPrice());
        }
        System.out.println("------------------------------");

        while (true) {
            System.out.print("👉 입력 : ");
            String choice = sc.nextLine();
            boolean checker = false;

            for (Menu_Item m : restaurantInfo.getMenuList()) {
                if (m.getName().equals(choice)) {
                    order(restaurantInfo, m);
                    checker = true;
                    break;
                }
            }

            if (checker) break; // 정상 입력 시 종료
            System.out.println("⚠️  리스트에 존재하지 않는 메뉴입니다. 다시 입력해주세요.");
        }
    }

    public void order(Restaurant_Info restaurantInfo, Menu_Item menuItem) {
        System.out.println(restaurantInfo.getRestaurant_name() + "에서 " + menuItem.getName() + "을(를) 주문하셨습니다.");
        orderManager.addOrder(menuItem,restaurantInfo);
        System.out.println("메인 메뉴로 돌아갑니다. ");
    }
}

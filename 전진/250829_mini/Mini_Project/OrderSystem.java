package Mini_Project;

import Mini_Project.Restaurant.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderSystem {
    private OrderManager orderManager = new OrderManager();

    public void Start() {
        System.out.println("\n================================");
        System.out.println(" 🛒 주문 시스템");
        System.out.println("================================");
        System.out.println(" 1) 한식");
        System.out.println(" 2) 일식");
        System.out.println(" 3) 양식");
        System.out.println(" 4) 중식");
        System.out.println(" 5) 뒤로 가기");
        System.out.println("--------------------------------");

        Scanner sc = new Scanner(System.in);
        System.out.print("👉 입력 : ");
        String choice = sc.nextLine();

        AbstractRestaurant restaurant = null;
        switch (choice) {
            case "1":
                restaurant = new Korean_Restaurant(sc, orderManager);
                break;
            case "2":
                restaurant = new Japanese_Restaurant(sc, orderManager);
                break;
            case "3":
                restaurant = new Western_Restaurant(sc, orderManager);
                break;
            case "4":
                restaurant = new Chinese_Restaurant(sc, orderManager);
                break;
            case "5":
                System.out.println("↩️  메인 메뉴로 돌아갑니다.");
                return;
            default:
                System.out.println("⚠️  올바르지 않은 입력입니다. 숫자를 입력해주세요.");
                return;
        }

        restaurant.chooseRestaurant();

    }
    public void Check(){
        orderManager.printAllOrders();
    }

}

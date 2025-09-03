package Mini_Project;

import java.util.Scanner;

public class SystemMain {
    public static void main(String[] args) {
        OrderSystem o = new OrderSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n================================");
            System.out.println(" 🍽️  메인 메뉴");
            System.out.println("================================");
            System.out.println(" 1) 메뉴 주문");
            System.out.println(" 2) 주문한 메뉴 확인");
            System.out.println(" 3) 시스템 종료");
            System.out.println("--------------------------------");

            System.out.print("👉 입력 : ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    o.Start();
                    break;
                case "2":
                    o.Check();
                    break;
                case "3":
                    System.out.println("\n❌ 시스템을 종료합니다. 이용해주셔서 감사합니다!");
                    return;
                default:
                    System.out.println("⚠️  올바르지 않은 입력입니다. 숫자를 입력해주세요.");
                    break;
            }
        }
    }
}

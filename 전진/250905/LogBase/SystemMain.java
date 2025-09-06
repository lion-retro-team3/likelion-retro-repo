package Day_0904.LogBase;

import Mini_Project.OrderSystem;

import java.util.Scanner;

public class SystemMain {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n================================");
            System.out.println("로그 시스템 연습");
            System.out.println("================================");
            System.out.println(" 1) 로그 기록하기");
            System.out.println(" 2) 기록 확인하기");
            System.out.println(" 3) 시스템 종료");
            System.out.println("--------------------------------");

            System.out.print("👉 입력 : ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    Log.startRecord();
                    break;
                case "2":
                    Log.readRecord();
                    break;
                case "3":
                    System.out.println("\n❌ 시스템을 종료합니다.");
                    return;
                default:
                    System.out.println("⚠️  올바르지 않은 입력입니다. 숫자를 입력해주세요.");
                    break;
            }
        }


    }
}

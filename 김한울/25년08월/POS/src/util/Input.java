package util;

import menu.SystemMenu;

import java.util.Scanner;

public class Input {


    private static Scanner scanner = new Scanner(System.in);

    private Input() {
    }

    public static String inputString() {
        return scanner.next();
    }

    public static int inputInteger() {
        while (true) {
            String token = scanner.next();
            try {
                return Integer.parseInt(token);
            } catch (NumberFormatException e) {
                System.out.println("[시스템] 숫자만 입력 가능합니다.\n");
            }


        }
    }
    public static int inputInteger(String msg) {
        while (true) {
            System.out.println(msg);
            String token = scanner.next();
            try {
                return Integer.parseInt(token);
            } catch (NumberFormatException e) {
                System.out.println("[시스템] 숫자만 입력 가능합니다.\n");
            }


        }
    }

    public static SystemMenu inputMenu() {

        int code = scanner.nextInt();
        SystemMenu byCode = SystemMenu.findByCode(code);

        return byCode;
    }
}

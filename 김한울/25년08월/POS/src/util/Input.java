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

    //종료 cmd 없을경우
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
    
    //종료 커맨드가 있는 메뉴를 선택할 경우 사용
    //return은 내부에서 정수 변환이 가능한지 확인. String 타입 이지만 논리적으로는 정수
    public static String inputInteger(String msg) {

        String token, quit = "quit";
        do {
            System.out.print(msg);
            token =scanner.next();
            //종료
            if (token.equals(quit)){
                return  token;
            }
            try {
                Integer.parseInt(token);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[시스템] 숫자만 입력 가능합니다.\n");
            }
        } while (true);

        return token;
    }

    //start 부터 end 까지의 정수만 입력이 가능하다.
    public static String inputInteger(String msg,int start, int end) {

        String token, quit = "quit";
        do {
            System.out.print(msg);
            token =scanner.next();
            //종료
            if (token.equals(quit)){
                return  token;
            }
            try {
                int inbound = Integer.parseInt(token);
                //범위 설정
                if (inbound < start || inbound > end) {
                    System.out.println(start + " 부터 " + end +" 까지의 정수만 입력가능합니다.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("[시스템] 숫자만 입력 가능합니다.\n");
            }
        } while (true);

        return token;
    }

    public static SystemMenu inputMenu() {

        int code = Input.inputInteger();
        SystemMenu byCode = SystemMenu.findByCode(code);

        return byCode;
    }
}

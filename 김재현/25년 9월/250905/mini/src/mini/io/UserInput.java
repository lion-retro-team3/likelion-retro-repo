package mini.io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private static final Scanner input = new Scanner(System.in);

    public static String mainOption() {
        System.out.print("옵션 선택(1. 회원등록 2. 로그인 3. 전체 회원 조회 ex. 종료): ");
        return input.nextLine();
    }

    public static String userOption() {
        System.out.print("옵션 선택(1. 메일 쓰기 2. 메일함 3. 메일 삭제 4. 로그아웃): ");
        return input.nextLine();
    }

    public static String emailInput() {
        System.out.print("이메일을 입력하세요: ");
        return input.nextLine();
    }

    public static String nameInput() {
        System.out.print("이름을 입력하세요: ");
        return input.nextLine();
    }

    public static String toInput() {
        System.out.print("받는 사람: ");
        return input.nextLine();
    }

    public static String titleInput() {
        System.out.print("제목: ");
        return input.nextLine();
    }

    public static String[] contentInput() {
        System.out.print("내용(줄바꿈은[/]로): ");
        return input.nextLine().split("/");
    }

    public static int deleteMailInput() {
        System.out.print("삭제할 메일 번호를 입력해주세요(나가기: 0): ");
        return integerInput();
    }

    public static int readMailInput() {
        System.out.print("읽을 메일 번호를 입력해주세요(나가기: 0): ");
        return integerInput();
    }

    private static int integerInput() {
        int num;
        try {
            num = input.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("[오류] 정수를 입력해주세요.");
        } finally {
            input.nextLine();
        }
        return num;
    }
}

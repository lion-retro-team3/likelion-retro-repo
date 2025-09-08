package mini.io;

import mini.domain.Member;
import mini.domain.email.Email;

import java.util.Collection;
import java.util.List;

public class ConsoleOutput {
    public static void errPrint(String message) {
        System.err.println(message);
    }

    public static void badOption() {
        System.err.println("[오류] 옵션을 잘못 입력했습니다.");
    }

    public static void mailDetail(Email email) {
        System.out.println("-----------------------------------------------");
        System.out.println("["+email.getTitle()+"]");
        System.out.println("보낸사람: " + email.getFrom());
        System.out.println("받는사람: " + email.getTo());
        String[] contentDetail = email.getContent();
        for (String s : contentDetail) {
            System.out.println("| " + s);
        }
        System.out.println("-----------------------------------------------");
    }

    public static void printMailBox(List<Email> mailBox) {
        System.out.println("-------------------- 메일함 --------------------");
        System.out.printf("|%-4s |%-25s |%-20s |%-8s |%-10s\n",
                "No", "Title", "From", "isRead", "Date");
        for (int i = 0; i < mailBox.size(); i++) {
            Email myEmail = mailBox.get(i);
            String isRead = myEmail.isRead() ? "O" : "X";
            System.out.printf("|%-4d |%-25s |%-20s |%-8s |%-10s\n",
                    i + 1, myEmail.getTitle(), myEmail.getFrom(), isRead, myEmail.getSentAt());
        }
        System.out.println("-----------------------------------------------");
    }

    public static void printMembers(Collection<Member> members) {
        System.out.println("------------------ 회원 리스트 ------------------");
        for (Member value : members) {
            System.out.println("- " + value);
        }
    }

    public static void signUpSuccess() {
        System.out.println("[회원가입 완료]");
    }

    public static void loginSuccess(String name) {
        System.out.println(name + "님 환영합니다!");
    }

    public static void sendSuccess() {
        System.out.println("메일이 전송되었습니다.");
    }

    public static void deleteMail() {
        System.out.println("[메일이 삭제되었습니다.]");
    }

    public static void logout() {
        System.out.println("[로그아웃]");
    }

    public static void mainHeader() {
        System.out.println("----------------- 이메일 시스템 -----------------");
    }

    public static void writeMailHeader() {
        System.out.println("------------------- 메일쓰기 -------------------");
    }

    public static void loginHeader() {
        System.out.println("-------------------- 로그인 --------------------");
    }

    public static void signUpHeader() {
        System.out.println("------------------- 회원가입 -------------------");
    }

    public static void exitProgram() {
        System.out.println("프로그램을 종료합니다.");
    }
}

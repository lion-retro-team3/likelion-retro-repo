package WhoAreYouProject;

import java.util.List;

public class ConsoleDirectory extends Directory {

    public void printMenu() {
        System.out.println("===한국법률인정보집===");
        System.out.println("1.직업으로 검색");
        System.out.println("2.이름으로 검색");
        System.out.println("3.전체 목록 보기");
        System.out.println("4.프로필 등록");
        System.out.println("0.종료");
        System.out.println("메뉴 번호를 입력하시오.");
    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printError(String msg) {
        System.out.println("[!] " + msg);
    }

    public void printAll() {
        List<Profile> all = super.listAll();
        printProfiles(all);
    }

    public void printByJob(Job job) {
        List<Profile> list = super.listByJob(job);
        printProfiles(list);
    }

    public void printByName(String name) {
        List<Profile> list = super.searchByName(name);
        printProfiles(list);
    }

    public void printProfiles(List<Profile> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("결과가 없습니다.\n");
            return;
        }
        for (Profile p : list) {
            printProfile(p);
            System.out.println();
        }
    }

    public void printProfile(Profile p) {
        if (p == null) {
            printError("프로필이 없습니다.");
            return;
        }
    System.out.println(p);

    }
}
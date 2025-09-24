package mini;

import mini.domain.Member;
import mini.domain.email.Email;
import mini.io.ConsoleOutput;
import mini.io.UserInput;
import mini.service.EmailService;
import mini.service.MemberService;

import java.util.Collection;
import java.util.List;

public class EmailMain {

    static MemberService memberService = new MemberService();
    static EmailService emailService = new EmailService();
    static Member loginMember;

    public static void main(String[] args) {
        init();
        while (true) {
            ConsoleOutput.mainHeader();
            String option = UserInput.mainOption();
            switch (option) {
                case "1" -> signUp();
                case "2" -> login();
                case "3" -> showMembers();
                case "ex" -> exit();
                default -> ConsoleOutput.badOption();
            }
        }
    }

    private static void signUp() {
        try {
            ConsoleOutput.signUpHeader();
            String email = UserInput.emailInput();
            String name = UserInput.nameInput();
            memberService.signUp(email, name);
            ConsoleOutput.signUpSuccess();
        } catch (IllegalArgumentException e) {
            ConsoleOutput.errPrint(e.getMessage());
        }
    }

    private static void login() {
        try {
            ConsoleOutput.loginHeader();
            String login = UserInput.emailInput();
            loginMember = memberService.login(login);
            ConsoleOutput.loginSuccess(loginMember.getName());
            userFunction();
        } catch (IllegalArgumentException e) {
            ConsoleOutput.errPrint(e.getMessage());
        }
    }

    private static void userFunction() {
        while (true) {
            String userOption = UserInput.userOption();
            switch (userOption) {
                case "1" -> writeMail();
                case "2" -> showMailBox();
                case "3" -> deleteMail();
                case "4" -> {
                    ConsoleOutput.logout();
                    return;
                }
                default -> ConsoleOutput.badOption();
            }
        }
    }

    private static void deleteMail() {
        try {
            showMails();
            int deleteId = UserInput.deleteMailInput();
            if (deleteId == 0) return;
            emailService.delete(loginMember, deleteId);
            ConsoleOutput.deleteMail();
        } catch (IllegalArgumentException | IllegalStateException e) {
            ConsoleOutput.errPrint(e.getMessage());
        }
    }


    private static void showMailBox() {
        List<Email> mailBox = showMails();
        int mailId = UserInput.readMailInput();
        if (mailId == 0) return;
        Email selectMail = mailBox.get(mailId - 1);
        selectMail.setRead(true);
        ConsoleOutput.mailDetail(selectMail);
    }

    private static void writeMail() {
        try {
            ConsoleOutput.writeMailHeader();
            String to = UserInput.toInput();
            String title = UserInput.titleInput();
            String[] content = UserInput.contentInput();
            Member findMember = memberService.findMember(to);
            emailService.write(loginMember, findMember, title, content);
            ConsoleOutput.sendSuccess();
        } catch (IllegalArgumentException e) {
            ConsoleOutput.errPrint(e.getMessage());
        }
    }

    private static void showMembers() {
        Collection<Member> members = memberService.getMembers().values();
        ConsoleOutput.printMembers(members);
    }

    private static List<Email> showMails() {
        List<Email> mailBox = loginMember.getMailBox();
        ConsoleOutput.printMailBox(mailBox);
        return mailBox;
    }

    private static void init() {
        Member member1 = memberService.signUp("test1@lion.com", "재현");
        Member member2 = memberService.signUp("test2@lion.com", "멋사");
        emailService.write(member1, member2,
                "Test Title1", "test content1111/test content1111".split("/"));
        emailService.write(member2, member1,
                "Test Title2", "test content2222/test content2222".split("/"));
    }

    private static void exit() {
        ConsoleOutput.exitProgram();
        System.exit(0);
    }
}

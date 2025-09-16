import controller.EmailController;
import controller.MemberController;
import dto.MemberDTO;
import io.ConsoleOutput;
import io.UserInput;

public class EmailMain {

    private static final MemberController memberController = new MemberController();
    private static final EmailController emailController = new EmailController();
    private static MemberDTO loginMember;

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        while (true) {
            String option = UserInput.mainOption();
            switch (option) {
                case "1" -> memberController.signUp();
                case "2" -> {
                    loginMember = memberController.login();
                    userFunction();
                }
                case "3" -> memberController.searchMembers();
                case "4" -> {
                    ConsoleOutput.exitProgram();
                    return;
                }
            }
        }
    }

    private static void userFunction() {
        while (true) {
            String userOption = UserInput.userOption();
            switch (userOption) {
                case "1" -> emailController.writeMail(loginMember);
                case "2" -> emailController.showMailBoxAndRead(loginMember);
                case "3" -> emailController.deleteMail(loginMember);
                case "4" -> {
                    memberController.delete(loginMember);
                    loginMember = null;
                    return;
                }
                case "5" -> {
                    ConsoleOutput.logout();
                    return;
                }
            }
        }
    }
}

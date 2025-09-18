package controller;

import dto.EmailDTO;
import dto.MemberDTO;
import io.ConsoleOutput;
import io.UserInput;
import service.EmailService;

import java.util.List;

public class EmailController {

    private final EmailService emailService = new EmailService();

    public void writeMail(MemberDTO loginMember) {
        ConsoleOutput.writeMailHeader();
        String sender = loginMember.getEmail();
        String recipient = UserInput.recipientInput();
        String title = UserInput.titleInput();
        String content = UserInput.contentInput();
        emailService.createMail(sender, recipient, title, content);
    }

    public void showMailBoxAndRead(MemberDTO loginMember) {
        showMailBox(loginMember);
        int mailId = UserInput.readMailInput();
        if (mailId == 0) return;
        EmailDTO mail = emailService.getMail(mailId);
        emailService.updateIsRead(mailId);
        ConsoleOutput.mailDetail(mail);
    }

    public void showMailBox(MemberDTO loginMember) {
        List<EmailDTO> mailBox = emailService.emailList(loginMember.getMemberId());
        ConsoleOutput.printMailBox(mailBox);
    }

    public void deleteMail(MemberDTO loginMember) {
        showMailBox(loginMember);
        int deleteId = UserInput.deleteMailInput();
        if (deleteId == 0) return;
        emailService.deleteMail(deleteId);
        ConsoleOutput.deleteMail();
    }
}

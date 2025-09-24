package service;

import dto.EmailDTO;
import repository.EmailDAO;
import repository.EmailDAOImpl;
import repository.MemberDAO;
import repository.MemberDAOImpl;

import java.util.List;

public class EmailService {
    private final EmailDAO emailDAO = new EmailDAOImpl();
    private final MemberDAO memberDAO = new MemberDAOImpl();

    public void createMail(String sender, String recipient, String title, String content) {
        int memberId = memberDAO.getMemberByEmail(recipient).getMemberId();
        String mailType = sender.split("@")[1].split("\\.")[0];
        emailDAO.createEmail(new EmailDTO(memberId, mailType, sender, recipient, title, content));
    }

    public List<EmailDTO> emailList(int memberId) {
        return emailDAO.getEmails(memberId);
    }

    public void deleteMail(int id) {
        emailDAO.deleteEmail(id);
    }

    public EmailDTO getMail(int id) {
        return emailDAO.getEmail(id);
    }

    public boolean updateIsRead(int id) {
        return emailDAO.updateIsRead(id);
    }
}

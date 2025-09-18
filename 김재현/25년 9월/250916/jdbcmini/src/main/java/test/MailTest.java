package test;

import dto.EmailDTO;
import repository.EmailDAO;
import repository.EmailDAOImpl;

public class MailTest {
    public static void main(String[] args) {

        EmailDAO emailDAO = new EmailDAOImpl();

        // int id = emailDAO.createEmail(new EmailDTO(
        //         7, "lion", "test1@lion.com",
        //         "test3@lion.com", "title", "content"
        // ));
        // System.out.println("id = " + id);

        // if (emailDAO.deleteEmail(id)) {
        //     System.out.println("삭제 성공");
        // }

        for (EmailDTO email : emailDAO.getEmails(7)) {
            System.out.println(email);
        }

        System.out.println(emailDAO.getEmail(6));


    }
}

package repository;

import dto.EmailDTO;

import java.util.List;

public interface EmailDAO {
    int createEmail(EmailDTO dto);

    boolean deleteEmail(int id);

    boolean updateIsRead(int id);

    List<EmailDTO> getEmails(int memberId);

    EmailDTO getEmail(int id);
}

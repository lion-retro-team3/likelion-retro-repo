package mini.domain.email;

import java.time.LocalDate;

public interface Email {
    String getFrom();
    String getTitle();
    String[] getContent();
    String getTo();
    boolean isRead();
    void setRead(boolean read);
    LocalDate getSentAt();
}

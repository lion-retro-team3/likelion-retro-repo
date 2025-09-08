package mini.domain.email;

import java.time.LocalDate;

public class GoogleEmail implements Email {
    private String from;
    private String title;
    private String[] content;
    private String to;
    private boolean isRead;
    private LocalDate sentAt;

    public GoogleEmail(String from, String title, String[] content, String to, LocalDate time) {
        this.from = from;
        this.title = title;
        this.content = content;
        this.to = to;
        this.isRead = false;
        this.sentAt = time;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String[] getContent() {
        return content;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public boolean isRead() {
        return isRead;
    }

    @Override
    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public LocalDate getSentAt() {
        return sentAt;
    }
}

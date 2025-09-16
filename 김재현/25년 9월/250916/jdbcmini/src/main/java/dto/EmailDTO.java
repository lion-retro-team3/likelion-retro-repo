package dto;

import java.time.LocalDateTime;

public class EmailDTO {
    private int mailId;
    private int memberId;
    private String mailType;
    private String sender;
    private String recipient;
    private String title;
    private String content;
    private boolean isRead;
    private LocalDateTime sentAt;

    public EmailDTO() {
    }

    public EmailDTO(int memberId, String mailType, String sender, String recipient, String title, String content) {
        this.memberId = memberId;
        this.mailType = mailType;
        this.sender = sender;
        this.recipient = recipient;
        this.title = title;
        this.content = content;
    }

    public int getMailId() {
        return mailId;
    }

    public void setMailId(int mailId) {
        this.mailId = mailId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMailType() {
        return mailType;
    }

    public void setMailType(String mailType) {
        this.mailType = mailType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    @Override
    public String toString() {
        return "EmailDTO{" +
                "mailId=" + mailId +
                ", memberId=" + memberId +
                ", mailType='" + mailType + '\'' +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isRead=" + isRead +
                ", sentAt=" + sentAt +
                '}';
    }
}

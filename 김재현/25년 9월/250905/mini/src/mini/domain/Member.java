package mini.domain;

import mini.domain.email.Email;
import mini.domain.email.GoogleEmail;
import mini.domain.email.LionEmail;
import mini.domain.email.NaverEmail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String email;
    private String name;
    private List<Email> mailBox = new ArrayList<>();

    public Member(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public List<Email> getMailBox() {
        return mailBox;
    }

    // 메일 받기
    public void receive(String from, String title, String[] content) {
        switch (from.split("@")[1]) {
            case "lion.com":
                mailBox.add(new LionEmail(from, title, content, email, LocalDate.now()));
                break;
            case "naver.com":
                mailBox.add(new NaverEmail(from, title, content, email, LocalDate.now()));
                break;
            case "gmail.com":
                mailBox.add(new GoogleEmail(from, title, content, email, LocalDate.now()));
                break;
        }
    }

    @Override
    public String toString() {
        return "|이름: " + name + " |이메일: " + email;
    }
}

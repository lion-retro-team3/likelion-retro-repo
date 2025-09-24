package domain;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private int memberId;
    private String email;
    private String name;
    private final List<Email> mailBox = new ArrayList<>();

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Email> getMailBox() {
        return mailBox;
    }

}

package dto;

public class MemberDTO {
    private int memberId;
    private String email;
    private String name;

    public MemberDTO() {
    }

    public MemberDTO(String email, String name) {
        this.email = email;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "|이름: " + name + " |이메일: " + email;
    }
}

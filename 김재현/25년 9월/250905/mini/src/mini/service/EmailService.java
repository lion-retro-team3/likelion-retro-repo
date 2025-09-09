package mini.service;

import mini.domain.Member;
import mini.domain.email.Email;

import java.util.List;

public class EmailService {

    public void write(Member from, Member to, String title, String[] content) {
        if (to == null) {
            throw new IllegalArgumentException("[오류] 입력하신 이메일의 가입정보가 존재하지 않습니다.");
        }
        to.receive(from.getEmail(), title, content);
    }

    public void delete(Member loginMember, int deleteId) {
        int index = deleteId - 1;
        List<Email> mailBox = loginMember.getMailBox();
        if (index < 0 || mailBox.size() <= index) {
            throw new IllegalArgumentException("[오류] 메일 번호를 잘못 입력하셨습니다.");
        }
        if (!mailBox.get(index).isRead()) {
            throw new IllegalStateException("[경고] 읽지 않은 메일입니다. 확인 후 삭제가능.");
        }
        mailBox.remove(index);
    }

}

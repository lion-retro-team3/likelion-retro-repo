package mini.service;

import mini.domain.Member;

import java.util.HashMap;
import java.util.Map;

public class MemberService {

    private Map<String, Member> members = new HashMap<>();

    public Member signUp(String email, String name) {
        if (members.containsKey(email)) {
            throw new IllegalArgumentException("[오류] 중복되는 이메일이 존재합니다.");
        }
        members.put(email, new Member(email, name));
        return members.get(email);
    }

    public Member login(String email) {
        Member member = members.get(email);
        if (member == null) {
            throw new IllegalArgumentException("[오류] 가입정보가 존재하지 않습니다.");
        }
        return member;
    }

    public Map<String, Member> getMembers() {
        return members;
    }

    public Member findMember(String email) {
        return members.get(email);
    }
}

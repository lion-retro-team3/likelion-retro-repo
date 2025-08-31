package miniProject.lionGym.data;

import miniProject.lionGym.people.Member;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 회원 저장소 구현체
 * @author dahee
 * @since 25.08.30
 */
public class MemberStoreImpl implements MemberStore{
    private final Map<String, Member> memberMap = new LinkedHashMap<>();

    @Override
    public List<Member> memberList() {
        return new ArrayList<>(memberMap.values());
    }

    @Override
    public void saveMember(Member member) {
        memberMap.put(member.getId(), member);
    }

    @Override
    public void removeMember(Member member) {
        memberMap.remove(member.getId());
    }

    @Override
    public Member findById(String id) {
        if(id != null) {
            return memberMap.get(id);
        } else {
            return null;
        }
    }
}

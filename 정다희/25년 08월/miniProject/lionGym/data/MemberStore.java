package miniProject.lionGym.data;

import miniProject.lionGym.people.Member;
import java.util.List;

/**
 * 회원 저장소 인터페이스
 * @author dahee
 * @since 25.08.30
 */
public interface MemberStore {
    List<Member> memberList();
    void saveMember(Member member);
    void removeMember(Member member);
    Member findById(String id);
}

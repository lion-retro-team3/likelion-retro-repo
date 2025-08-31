package miniProject.lionGym.gym;

import miniProject.lionGym.people.Member;
import miniProject.lionGym.people.Trainer;

import java.util.List;

/**
 * 헬스장 관리 인터페이스
 * @author dahee
 * @since 25.08.30
 */
public interface GymFunctions {
    void dataInit();
    List<Member> memberList();
    List<Trainer> trainerList();
    void registerMember(Member member);
    void registerTrainer(Trainer trainer);
    void buyPt(Member member);
    void usePt(String memberId, int useSession);
    Trainer getTrainerInfo(String id);
}

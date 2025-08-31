package miniProject.lionGym.gym;

import miniProject.lionGym.data.MemberStore;
import miniProject.lionGym.data.MemberStoreImpl;
import miniProject.lionGym.data.TrainerStore;
import miniProject.lionGym.data.TrainerStoreImpl;
import miniProject.lionGym.people.Trainer;
import miniProject.lionGym.people.Member;

import java.util.List;

/**
 * 헬스장 관리 구현체
 * @author dahee
 * @since 25.08.30
 */
public class GymFunctionsImpl implements GymFunctions {
    private final TrainerStore trainerStore;
    private final MemberStore memberStore;
    private int tSeq = 1;
    private int mSeq = 1;

    public GymFunctionsImpl() {
        this.trainerStore = new TrainerStoreImpl();
        this.memberStore = new MemberStoreImpl();
    }

    @Override
    public List<Member> memberList() {
        return memberStore.memberList();
    }

    @Override
    public List<Trainer> trainerList() {
        return trainerStore.trainerList();
    }

    @Override
    public void registerMember(Member member) {
        member.setId("M" + mSeq++);
        memberStore.saveMember(member);
    }

    @Override
    public void registerTrainer(Trainer trainer) {
        trainer.setId("T" + tSeq++);
        trainerStore.saveTrainer(trainer);
    }

    @Override
    public void buyPt(Member member) {
        Member m = memberStore.findById(member.getId());
        if(m != null) {
            m.setTrainerId(member.getTrainerId());
            m.setSession(m.getSession() + member.getSession());
        }
    }

    @Override
    public void usePt(String memberId, int useSession) {
        Member m = memberStore.findById(memberId);
        Trainer t = trainerStore.findById(m.getTrainerId());
        if(m != null && t != null) {
            m.setSession(m.getSession() - useSession);
            t.setLessons(t.getLessons() + useSession);
        }
    }

    @Override
    public Trainer getTrainerInfo(String id) {
        return trainerStore.findById(id);
    }

    @Override
    public void dataInit() {
        trainerStore.saveTrainer(new Trainer("T"+tSeq++, "김트레이너", "010-1111-1111",2_000_000, 30_000,10));
        trainerStore.saveTrainer(new Trainer("T"+tSeq++, "이트레이너", "010-2222-2222",1_500_000, 30_000,20));
        trainerStore.saveTrainer(new Trainer("T"+tSeq++, "박트레이너", "010-3333-3333",2_500_000, 30_000,0));

        memberStore.saveMember(new Member("M"+mSeq++, "김회원", "010-4444-4444",null, 0));
        memberStore.saveMember(new Member("M"+mSeq++, "이회원", "010-5555-5555","T1", 5));
        memberStore.saveMember(new Member("M"+mSeq++, "박회원", "010-6666-6666","T2", 15));
        memberStore.saveMember(new Member("M"+mSeq++, "정회원", "010-7777-7777","T3", 2));
        memberStore.saveMember(new Member("M"+mSeq++, "최회원", "010-8888-8888","T1", 23));
    }
}

package miniProject.lionGym.people;

/**
 * 회원 클래스
 * @author dahee
 * @since 25.08.30
 */
public class Member extends Person{
    private String trainerId; // 트레이너
    private int session;      // 남은수업횟수

    public Member() {
    }

    public Member(String id, String name, String phone, String trainerId, int session) {
        super(id, name, phone);
        this.trainerId = trainerId;
        this.session = session;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "Member{" +
                "trainerId='" + trainerId + '\'' +
                ", session=" + session +
                '}';
    }


}

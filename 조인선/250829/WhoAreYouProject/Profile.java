package WhoAreYouProject;
import java.util.UUID;
public class Profile {

    private String name; // 성명
    private String education; // 출신대학
    private String examName; // 시험명
    private String examClass; // 시험기수
    private String office; // 현 사무소 명칭
    private Job job; // 직업
    private final String userProfileId; // 유사한 프로필로 인한 오류 방지 고유번호

public Profile(String name, String education, String examName, String examClass, String office, Job job ){
    this.userProfileId  = UUID.randomUUID().toString(); // 프로필 고유 번호 생성
    this.name = name;
    this.education = education;
    this.examName = examName;
    this.examClass = examClass;
    this.office = office;
    this.job = job;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteducation() {
        return education;
    }

    public void seteducation(String education) {
        this.education = education;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamClass() {
        return examClass;
    }

    public void setExamClass(String examClass) {
        this.examClass = examClass;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getUserProfileId() {
        return userProfileId;
    }

    @Override // 프로필 출력 양식
    public String toString() {
        return "===정보===\n" +
                name + "," + office + " " + job + "\n" +
                "학력: " + education + "\n" +
                "시험 / 기수: " + examName + " / " + examClass;
    }

    @Override // equals 와 hashCode를 통한 불일치 및 일치 검사
     public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile other = (Profile) o;
        return  this.userProfileId.equals(other.userProfileId);
    }

    @Override
     public int hashCode(){
        return userProfileId.hashCode();
        }

    }


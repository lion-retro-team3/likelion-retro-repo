package WhoAreYouProject;

import java.util.*;


public class Directory{
    private Map<String, List<Profile>> profilesByName = new HashMap<>(); // 성명으로 검색
    private Map<Job, List<Profile>> profilesByJob = new EnumMap<>(Job.class);// 직업으로 검색
    private Map<String, Profile> profilesById = new HashMap<>();

    //유효성검사용 메서드

    private static String noBlankEver(String name){
        return name ==null ? "" : name.trim().replaceAll("\\s+", " " );
    }
    private static boolean isItBlank(String s){
        return s == null || s.trim().isEmpty();
    }

    public void add(Profile p) {  //프로필 추가시 유효성검사
        if (p == null) throw new IllegalArgumentException("프로필이 존재하지 않습니다.");
        if (isItBlank(p.getName())) throw new IllegalArgumentException("이름을 입력하시오.");
        if (p.getJob() == null) throw new IllegalArgumentException("직업을 선택하시오.");
        if (isItBlank(p.getExamName())) throw new IllegalArgumentException("시험명을 입력하시오.");
        if (isItBlank(p.getExamClass())) throw new IllegalArgumentException("시험 기수를 입력하시오.");
        // 받는 값은 공백 전부 제거해서 에러 안나게끔 만듦.
        String keyName = noBlankEver(p.getName());
        // 람다식을 써보려했지만 잘 모르겠으니 그냥 주석 처리하고 if문 작성함.
        // profilesByJob.computeIfAbsent(p.getJob(), k -> new ArrayList<>()).add(p);
        // Map에 해당 키가 없으면 만들어 넣고, 있으면 값 반환.
        if (!profilesByName.containsKey(keyName)) {
            profilesByName.put(keyName, new ArrayList<>());
        }
        profilesByName.get(keyName).add(p);

        // 직업별 리스트 없으면 새로 생성.
        Job job = p.getJob();
        if (!profilesByJob.containsKey(job)) {
            profilesByJob.put(job, new ArrayList<>());
        }
        profilesByJob.get(job).add(p);

        // 고유 ID 기준 저장 - 사용자에겐 보여지지 않을 예정. 유지보수 차원
        profilesById.put(p.getUserProfileId(), p);


        }
    // 전체 보기
    public List<Profile> listAll() {
        List<Profile> all = new ArrayList<>(profilesById.values());
        all.sort(Comparator.comparing(Profile::getName)); // 이름 오름차순
        return all;
    }

    // 이름으로 검색
    public List<Profile> searchByName(String name) {
        String key = noBlankEver(name);
        return profilesByName.getOrDefault(key, Collections.emptyList());
    }

    // 직업별 검색
    public List<Profile> listByJob(Job job) {
        return profilesByJob.getOrDefault(job, Collections.emptyList());
    }

    // 고유 ID 단건 조회 - 콘솔 출력안됨.
    public Profile getById(String id) {
        return profilesById.get(id);
    }

}


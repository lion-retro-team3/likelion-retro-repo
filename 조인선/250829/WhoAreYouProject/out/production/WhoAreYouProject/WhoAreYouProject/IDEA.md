**목표**
- 객체지향프로그래밍을 이해하고 활용하는 것이 중점.
- 사용자의 입출력을 자유롭게 받아 기존의 데이터에 추가 및 수정.
- Collection 프레임워크를 적극 사용하여 여러개의 객체를 관리
- 법률신문에서 서비스하고 있는 "한국법조인대관"에서 영감을 받음.

**개발 환경**
- Java - JDK21
- IDE - IntelliJ


### 1. 프로젝트 개요
**프로젝트명: 법률서비스 제공자 등록 간단 관리 시스템**

### 2. 구현할 기능
1. 인물 검색 : 시스템에 등록된 인물의 이름으로 검색하여 일치하는 정보를 나열해 출력.
2. 인물 프로필 출력 : "이름, 출신 대학, 시험기수, 직업, 현사무소" 를 출력.
3. 인물 추가 : 새로운 인물의 프로필을 추가.
4. 인물 수정 : 기존 인물의 프로필을 수정.
5. 각 직업별 검색 : 직업별로 검색하여 목록형태로 출력.


### 3. 클래스 설계
총 5개의 클래스로 구성.

**3.1** `Job`
아래 목록을 `enum` 열거형으로 제작.

1. `LABOR_ATTORNEY` 공인노무사
2. `REALTOR` 공인중개사
3. `JUDICIAL_SCRIVENER` 법무사
4. `PATENT_ATTORNEY` 변리사
5. `TAX_ACCOUNTANT` 세무사
6. `ADMINISTRATIVE_AGENT` 행정사
7. `ATTORNEY` 변호사
8. `JUDGE` 판사
9. `PROSECUTOR`검사

**3.2** `Profile` 클래스
인물의 프로필을 담는 클래스.

- 속성

1. `name` : 성명
2. `university` : 출신대학
3. `examClass` : 시험기수
4. `Job` : 직업
5. `office` : 현사무소
6. `examName` : 시험명
7. `userProfileId` : 동일 프로필 발생으로 인한 오류를 없애기 위해 고유식별자 입력.

- 기능
1. 생성자, Getter/Setter 메서드
2. `toString()`: 프로필 문자 출력을 위함.
3. `equals()/hashCode()` `userProfileId`기준으로 일치확인.

**3.3** `Directory` 클래스
-속성
1. `EnumMap<Job, List<Profile>>` : 직업별 목록을 출력하기 위한 인덱스, 정렬은 이름 오름차순.
2. `Map<String, List<String>>`: 이름값 입력시 출력하는 인덱스. 전체값이 동일해야함.


-기능
1. `add(Profile)` : 프로필 생성 및 등록
2. `ListJob(Job)` : 직업별 목록 출력



**3.4** `ConsolsDirectory`클래스
- 속성

`Directory`클래스를 상속받은 출력용 클래스

1. `printMenu` : 메뉴 출력
2. `printMessage` : 메세지 출력
3. `printError`: 오류메세지 출력
4. `printAll` : 리스트의 정보 전부 출력
5. `printByJob` : 직업 기준 출력
6. `printByName` : 이름 기준 출력
7. `printProfiles` : 프로필 출력

- 기능
  1.System.out.println(msg) 로 상태를 콘솔 출력



**3.5** `Main` 클래스
- 기능
1. 사용자에게 찾고자 하는 메뉴를 제시.
2. 사용자에게 프로필을 입력받음.
3. 사용자에게 프로필 수정을 요청 받음.
4. 직업별 인물 목록 출력(가나다순)
5. 직업 목록 출력(가나다순)

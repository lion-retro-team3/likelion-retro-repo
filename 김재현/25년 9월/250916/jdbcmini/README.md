# 이메일 송수신 시스템 - 미니 프로젝트 과제
- 미니프로젝트에 JDBC를 활용하여 DB에서 데이터를 조회,삭제,변경 할 수 있도록 리팩토링 했습니다.

---

## 수강생 정보
- **이름**: 김재현
- **기수**: 19기
- **트랙**: 백엔드 스쿨

---

## 파일 구조
```
├───main
│   ├───java
│   │   │   EmailMain.java
│   │   │   
│   │   ├───common
│   │   │       DBUtil.java
│   │   │       
│   │   ├───controller
│   │   │       EmailController.java
│   │   │       MemberController.java
│   │   │       
│   │   ├───domain
│   │   │       Email.java
│   │   │       Member.java
│   │   │       
│   │   ├───dto
│   │   │       EmailDTO.java
│   │   │       MemberDTO.java
│   │   │       
│   │   ├───io
│   │   │       ConsoleOutput.java
│   │   │       UserInput.java
│   │   │       
│   │   ├───repository
│   │   │       EmailDAO.java
│   │   │       EmailDAOImpl.java
│   │   │       MemberDAO.java
│   │   │       MemberDAOImpl.java
│   │   │       
│   │   ├───service
│   │   │       EmailService.java
│   │   │       MemberService.java
│   │   │       
│   │   └───test
│   │           MailTest.java
│   │           MemberTest.java
│   │           
│   └───resources
└───test
    ├───java
    └───resources
```

---

##  기존 구조
1. **Email 구조**
    - `Email` 인터페이스
    - 여러 구현체(`GoogleEmail`, `NaverEmail`, `LionEmail` 등)

2. **Main 클래스**
    - `MemberService`, `EmailService` 직접 호출

3. **데이터 관리**
    - `Member`, `Email`을 `Map` 또는 `List`로 저장 및 관리

---

##  리팩토링 후 구조
1. **Email 클래스 통합**
    - 단일 `Email` 클래스로 변경
    - `mailType` 필드 추가 → 메일 종류 구분

2. **Controller 추가**
    - `Main`이 아닌 이곳에서 `Service`를 호출하게 변경

3. **DAO / DTO 추가**
    - DAO가 DB에 접근, DTO가 데이터 운반







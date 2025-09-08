# 이메일 송수신 시스템 - 미니 프로젝트 과제

---

## 수강생 정보
- **이름**: 김재현
- **기수**: 19기
- **트랙**: 백엔드 스쿨
- **제출일**: 2025-08-29

---

## 파일 구조
```
mini/
├── domain/
│   ├── email/
│   │   ├── Email.java
│   │   ├── GoogleEmail.java
│   │   ├── LionEmail.java
│   │   └── NaverEmail.java
│   └── Member.java
├── io/
│   ├── ConsoleOutput.java
│   └── UserInput.java
├── service/
│   ├── EmailService.java
│   └── MemberService.java
├── EmailMain.java
└── README.md
```

---

## 기능

- **1. 회원 관리**
  - 회원 등록
    - 이메일 : `아이디@메일.com` 형식으로 입력 -> 예) `test123@gmail.com`
    - 이름 : 자유롭게 입력
  - 로그인
    - 이메일을 입력해 로그인
  - 회원 조회 : 모든 회원 출력


- **2. 이메일 송수신**
  - 메일쓰기
  - 메일함
  - 메일삭제
    - 읽지 않은 메일을 삭제시도 시 경고 창 출력

---

## 향후 개선점

- 예외 처리 - 완료
- 책임에 따른 클래스 분리 - 완료
- 이름, 메일 제목 등 한글 + 영어 섞여있으면 줄 맞춤이 안되는 점
- 로그인 시 패스워드 추가


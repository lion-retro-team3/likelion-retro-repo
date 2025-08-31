## List
1. Student 객체를 5개 생성하여 학생 5명을 만들기
2. List<Student>에 학생을 담기
3. 2학년인 학생의 이름과 전공을 출력하기 (`Get()`메서드 활용);

## Set
4. 학번이 동일한 객체에 다른 학생을 담아보고 중복이 어떻게 처리되는지 확인하기.

## Map
5. key값은 studentId, value값은 Student인 Map을 만들어 학생 데이터를 담아보기  
6. 사용자에게 학번을 입력받아, 그 학생의 데이터를 출력하기.

## 응용
7. 모든 학생을 List에 담은 뒤, 전공별로 학생들을 Map<String, List<Student>>에 담아 이름을 출력하기.  
- 예시
```java
컴퓨터공학 : [Kim, Lee]  
경영학 : [Park]  
수학과 : [Choi, Jung]
```
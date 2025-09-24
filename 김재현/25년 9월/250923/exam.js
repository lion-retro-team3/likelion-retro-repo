console.log("---------1. 변수와 기본 연산---------------");
// 1. 변수와 기본 연산
// 다음 변수들을 선언하고 값을 할당하세요
// 1. 당신의 이름 (문자열)
// 2. 나이 (숫자)
// 3. 학생 여부 (불린)

// 그리고 이 정보들을 이용해 자기소개 문장을 만들어 console.log로 출력하세요
// 예: "안녕하세요, 저는 김철수이고 25살입니다. 학생입니다."

let name1 = "김재현";
let age1 = 26;
let isStudent = true;
let st = isStudent ? "학생입니다." : "학생이 아닙니다.";

let sentence = "안녕하세요, 저는 " + name1 + "이고 " + age1 + "살입니다. " + st;
console.log(sentence);

console.log("----------2. 함수 만들기---------------");
// 2. 함수 만들기
// 1. 두 숫자를 받아서 더한 결과를 반환하는 함수 add를 만드세요
// 2. 원의 반지름을 받아서 넓이를 계산하는 함수 getCircleArea를 만드세요 (π는 3.14 사용)
// 3. 이름을 받아서 "안녕하세요, [이름]님!"을 반환하는 함수 greet을 만드세요

// 각 함수를 호출해서 결과를 확인해보세요

// 1번
const add = (a, b) => a + b;
console.log("sum: " + add(1, 2));

// 2번
const PI = 3.14;
const getCircleArea = (r) => PI * r * r;
console.log("원의 넓이: " + getCircleArea(2));

const name2 = "재현";
const greet = (s) => console.log("안녕하세요, " + s + "님!");
greet(name2);

// 3. 객체 다루기
// 학생 정보를 담은 객체를 만드세요
// 포함할 정보: 이름, 나이, 학년, 좋아하는 과목들(배열)
console.log("----------3. 객체 다루기---------------");

const student = {
  name3: "이름123",
  age2: 12,
  grade: 1,
  subs: ["수학", "과학"],
};
const { name3, age2, grade, subs } = student;

// 그리고 다음 작업들을 해보세요:
// 1. 학생의 이름을 출력하기
// 2. 학생의 나이를 1살 증가시키기
// 3. 새로운 과목을 좋아하는 과목 배열에 추가하기
// 4. 학생 정보를 모두 출력하기
console.log("이름: " + name3);
console.log("나이(+1): " + ++student.age2);
student.subs.push("사회");
console.log("좋아하는 과목: " + student.subs);
console.log("==학생정보==");
console.log(student);

// 4. 배열 조작
// 1. 과일 이름들이 담긴 배열을 만드세요 (최소 5개)
// 2. 배열의 첫 번째와 마지막 요소를 출력하세요
// 3. 배열에 새로운 과일을 추가하세요
// 4. 배열의 길이를 출력하세요
// 5. 특정 과일이 배열에 있는지 확인하는 코드를 작성하세요
console.log("----------4. 배열 조작---------------");
const fruit = ["수박", "딸기", "바나나", "오렌지", "포도"];
console.log("첫 번째 과일: " + fruit[0]);
console.log("마지막 과일: " + fruit[fruit.length - 1]);
fruit.push("메론");
console.log(fruit);
console.log(fruit.length);

let check = "바나나";
if (fruit.includes(check)) {
  console.log(check + "는 배열에 존재합니다.");
} else {
  console.log(check + "는 배열에 존재하지않습니다.");
}

// 5. 조건문 활용
// 점수를 받아서 등급을 반환하는 함수를 만드세요
// 90점 이상: A
// 80점 이상: B
// 70점 이상: C
// 60점 이상: D
// 60점 미만: F
// 여러 점수로 테스트해보세요: 95, 87, 73, 65, 45
console.log("----------5. 조건문 활용---------------");
const rate = (score) =>
  score >= 90
    ? "A"
    : score >= 80
    ? "B"
    : score >= 70
    ? "C"
    : score >= 60
    ? "D"
    : "F";
console.log(rate(95));
console.log(rate(87));
console.log(rate(73));
console.log(rate(65));
console.log(rate(45));

// 6. switch문 활용
// 요일 번호(1-7)를 받아서 요일명을 반환하는 함수를 만드세요
// 1: 월요일, 2: 화요일, ... 7: 일요일
// 잘못된 번호가 입력되면 "잘못된 요일 번호입니다" 반환
// 1부터 8까지의 숫자로 테스트해보세요
console.log("----------6. switch문 활용---------------");
const dayName = (num) => {
  switch (num) {
    case 1:
      console.log(num + ": 월요일");
      break;
    case 2:
      console.log(num + ": 화요일");
      break;
    case 3:
      console.log(num + ": 수요일");
      break;
    case 4:
      console.log(num + ": 목요일");
      break;
    case 5:
      console.log(num + ": 금요일");
      break;
    case 6:
      console.log(num + ": 토요일");
      break;
    case 7:
      console.log(num + ": 일요일");
      break;
    default:
      console.log("잘못된 요일 번호입니다.");
  }
};
for (let i = 1; i <= 8; i++) {
  dayName(i);
}

console.log("----------7. 계산기---------------");

// 7. 종합문제
// 간단한 계산기 객체를 만드세요
// 포함할 메서드:
// - add(a, b): 덧셈
// - subtract(a, b): 뺄셈
// - multiply(a, b): 곱셈
// - divide(a, b): 나눗셈 (0으로 나누기 체크)

// 그리고 계산 결과를 예쁘게 출력하는 함수도 만드세요
// 예: "10 + 5 = 15"

const printResult = (a, b, result, s) =>
  console.log(a + " " + s + " " + b + " = " + result);

const calculrator = {
  add: (a, b) => {
    printResult(a, b, a + b, "+");
  },
  subtract: (a, b) => {
    printResult(a, b, a - b, "-");
  },
  multiply: (a, b) => {
    printResult(a, b, a * b, "*");
  },
  divide(a, b) {
    if (b == 0) {
      console.log("0으로 나눌 수 없습니다.");
      return;
    }
    printResult(a, b, a / b, "/");
  },
};
calculrator.add(1, 2);
calculrator.subtract(3, 1);
calculrator.multiply(4, 5);
calculrator.divide(4, 0);
calculrator.divide(4, 2);

// 8. 실전 응용
// 도서관 시스템을 만들어보세요
// 1. 책 객체들이 담긴 배열을 만드세요 (제목, 저자, 출간년도, 대여 상태)
// 2. 책 제목으로 검색하는 함수를 만드세요
// 3. 대여 가능한 책들의 제목만 출력하는 함수를 만드세요
// 4. 새 책을 추가하는 함수를 만드세요

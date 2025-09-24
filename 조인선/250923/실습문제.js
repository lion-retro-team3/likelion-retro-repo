console.log("===1번===");

// 다음 변수들을 선언하고 값을 할당하세요
// 1. 당신의 이름 (문자열)
// 2. 나이 (숫자)
// 3. 학생 여부 (불린)

let myname = "조인선";
let age = 27;
let checkStudent = false;

if (checkStudent === true) {
  checkMsg = "학생입니다.";
} else checkMsg = "학생이 아닙니다.";

console.log(myname);
console.log(age);
console.log(checkMsg);

// 그리고 이 정보들을 이용해 자기소개 문장을 만들어 console.log로 출력하세요
// 예: "안녕하세요, 저는 김철수이고 25살입니다. 학생입니다."
let hi = "안녕하세요. 저는 " + myname + "이고 " + age + "살입니다. " + checkMsg;
console.log(hi);

console.log("===2번===");

// 1. 두 숫자를 받아서 더한 결과를 반환하는 함수 add를 만드세요
// 2. 원의 반지름을 받아서 넓이를 계산하는 함수 getCircleArea를 만드세요 (π는 3.14 사용)
// 3. 이름을 받아서 "안녕하세요, [이름]님!"을 반환하는 함수 greet을 만드세요

let num1 = 1;
let num2 = 2;
let r = 3;
let yourName = "조인선";
const plus = (a, b) => a + b;
const getCircleArea = (radius) => radius * radius * 3.14;
const greet = (yourName) => "안녕하세요. " + yourName + "님!";

// 각 함수를 호출해서 결과를 확인해보세요
console.log(plus(num1, num2));
console.log(getCircleArea(r));
console.log(greet(yourName));

console.log("===3번===");

// 학생 정보를 담은 객체를 만드세요
// 포함할 정보: 이름, 나이, 학년, 좋아하는 과목들(배열)
const student = {
  name: "조학생",
  theAge: 17,
  grade: 1,
  favoriteSubject: ["영어", "체육", "미술", "국어"],
};

// 그리고 다음 작업들을 해보세요:1+11
// 1. 학생의 이름을 출력하기
// 2. 학생의 나이를 1살 증가시키기
// 3. 새로운 과목을 좋아하는 과목 배열에 추가하기
// 4. 학생 정보를 모두 출력하기
console.log(student.name);
student.theAge += 1;
student.favoriteSubject.push("일본어");
const { name, theAge, grade, favoriteSubject } = student;
console.log(student);

console.log("===4번===");

// 1. 과일 이름들이 담긴 배열을 만드세요 (최소 5개)
// 2. 배열의 첫 번째와 마지막 요소를 출력하세요
// 3. 배열에 새로운 과일을 추가하세요
// 4. 배열의 길이를 출력하세요
// 5. 특정 과일이 배열에 있는지 확인하는 코드를 작성하세요
const fruits = ["사과", "바나나", "오렌지", "포도", "수박"];
console.log("첫 번째 과일:", fruits[0]);
console.log("마지막 과일:", fruits[fruits.length - 1]);
fruits.push("파인애플");
console.log(fruits.length);
if (fruits.includes("바나나")) {
  console.log("리스트에 있습니다.");
} else {
  console.log("리스트에 없습니다.");
}

console.log("===5번===");

// 점수를 받아서 등급을 반환하는 함수를 만드세요
// 90점 이상: A
// 80점 이상: B
// 70점 이상: C
// 60점 이상: D
// 60점 미만: F
function whatScore(score) {
  if (score >= 90) {
    return "A";
  } else if (score >= 80) {
    return "B";
  } else if (score >= 70) {
    return "C";
  } else if (score >= 60) {
    return "D";
  } else {
    return "F";
  }
}
// 여러 점수로 테스트해보세요: 95, 87, 73, 65, 45
console.log(whatScore(95));
console.log(whatScore(87));
console.log(whatScore(73));
console.log(whatScore(65));
console.log(whatScore(45));

console.log("===6번===");

// 요일 번호(1-7)를 받아서 요일명을 반환하는 함수를 만드세요
// 1: 월요일, 2: 화요일, ... 7: 일요일
// 잘못된 번호가 입력되면 "잘못된 요일 번호입니다" 반환

// 1부터 8까지의 숫자로 테스트해보세요
function weekday(week) {
  let day;
  switch (week) {
    case 1:
      day = "월요일입니다.";
      break;
    case 2:
      day = "화요일입니다.";
      break;
    case 3:
      day = "수요일입니다.";
      break;
    case 4:
      day = "목요일입니다.";
      break;
    case 5:
      day = "금요일입니다.";
      break;
    case 6:
      day = "토요일입니다.";
      break;
    case 7:
      day = "일요일입니다.";
      break;
    default:
      day = "잘못된 요일입니다.";
  }
  return day;
}
console.log(weekday(1));
console.log(weekday(2));
console.log(weekday(3));
console.log(weekday(4));
console.log(weekday(5));
console.log(weekday(6));
console.log(weekday(7));
console.log(weekday(8));

console.log("===7번===");

// 간단한 계산기 객체를 만드세요
// 포함할 메서드:
// - add(a, b): 덧셈
// - subtract(a, b): 뺄셈
// - multiply(a, b): 곱셈
// - divide(a, b): 나눗셈 (0으로 나누기 체크)

// 그리고 계산 결과를 예쁘게 출력하는 함수도 만드세요
// 예: "10 + 5 = 15"


const calculator = {
  add(x, y) {
    return x + y;
  },
  subtract(x, y) {
    return x - y;
  },
  multiply(x, y) {
    return x * y;
  },
  divide(x, y) {
    if (y === 0) return "0으로 나눌 수 없습니다.";
    return x / y;
  },
};



function printCal(expression) {
  let x, y, operator, result;

  if (expression.includes("+")) {
    [x, y] = expression.split("+");
    operator = "+";
    result = calculator.add(Number(x), Number(y));
  } else if (expression.includes("-")) {
    [x, y] = expression.split("-");
    operator = "-";
    result = calculator.subtract(Number(x), Number(y));
  } else if (expression.includes("*")) {
    [x, y] = expression.split("*");
    operator = "*";
    result = calculator.multiply(Number(x), Number(y));
  } else if (expression.includes("/")) {
    [x, y] = expression.split("/");
    operator = "/";
    result = calculator.divide(Number(x), Number(y));
  } else {
    return "지원하지 않는 식입니다.";
  }

  return `${x} ${operator} ${y} = ${result}`;
}


console.log(printCal("10+5"));
console.log(printCal("10-5"));
console.log(printCal("10*5"));
console.log(printCal("10/5"));
console.log(printCal("10/0"));





//1. 변수와 기초 연산
let name = "park kid";
let age = 3;
let isStudent = false;
// 1. 당신의 이름 (문자열)
// 2. 나이 (숫자)
// 3. 학생 여부 (불린)
console.log(
  `안녕하세요 저는 ${name} 이고 ${age}, isStrudent : ${isStudent} 입니다.`
);

//2.문제만들기

// 2-1. 두 숫자를 받아서 더한 결과를 반환하는 함수 add를 만드세요
const add = (a, b) => {
  return a + b;
};

// 2-2. 원의 반지름을 받아서 넓이를 계산하는 함수 getCircleArea를 만드세요 (π는 3.14 사용)
const getCircleArea = (radius) => {
  return 3.14 * radius * radius;
};

// 2-3. 이름을 받아서 "안녕하세요, [이름]님!"을 반환하는 함수 greet을 만드세요
const hello = (name) => {
  console.log(`환영합니다 ${name} 님!`);
};

// 2-1
console.log(add(1, 3));
// 2-2
console.log(getCircleArea(10));
// 2-3
hello(name);

//3. 객체 다루기

// 그리고 다음 작업들을 해보세요:
// 학생 정보를 담은 객체를 만드세요
// 포함할 정보: 이름, 나이, 학년, 좋아하는 과목들(배열)
class student {
  constructor(name, age, grade, favorite) {
    this._name = name;
    this._age = age;
    this._grade = grade;
    this._favorite = favorite;
  }
  get name() {
    return this._name;
  }
  get age() {
    console.log("get Age");

    return this._age;
  }
  get grade() {
    return this._grade;
  }

  get favorite() {
    return this._favorite;
  }

  set name(name) {
    this._name = name;
  }

  set age(age) {
    if (age < 0) {
      console.log("나이는 0보다 커야합니다.");
      return;
    }
    this._age = age;
  }
  set favorite(favorite) {
    this._favorite = favorite;
  }
}

let stu1 = new student("김철수", 13, 3, [`수학`, `과학`]);
// 3-1. 학생의 이름을 출력하기
console.log(stu1.name);
console.log(stu1.favorite);

// 3-2. 학생의 나이를 1살 증가시키기
console.log("나이 증가 전 : " + stu1.age);
stu1.age = stu1.age + 1;
console.log("나이 증가 후 : " + stu1.age);

// 3-3. 새로운 과목을 좋아하는 과목 배열에 추가하기
console.log("추가 전: " + stu1.favorite);
//stu1.favorite = stu1.favorite.push("영어"); 3
stu1.favorite.push("영어");
console.log("추가 후: " + stu1.favorite);

// 3-4. 학생 정보를 모두 출력하기
console.log(stu1);

//4. 배열조작

// 4-1. 과일 이름들이 담긴 배열을 만드세요 (최소 5개)
const fruits = ["딸기", "사과", "포도", "배", "파인애플", "망고"];

// 4-2. 배열의 첫 번째와 마지막 요소를 출력하세요
console.log(fruits[0]);
console.log(fruits[fruits.length - 1]);

// 4-3. 배열에 새로운 과일을 추가하세요
fruits.push("오렌지");

// 4-4. 배열의 길이를 출력하세요
console.log("length : " + fruits.length);

// 4-5. 특정 과일이 배열에 있는지 확인하는 코드를 작성하세요
function findFruit(fruits, fruit) {
  const result = fruits.includes(fruit);
  if (result) {
    console.log(fruit + " 과일이 배열에 있습니다.");
  } else {
    console.log(fruit + " 과일이 배열에 없습니다.");
  }
}

findFruit(fruits, "오렌지");
findFruit(fruits, "석류");

//5. 조건문 활용
// 점수를 받아서 등급을 반환하는 함수를 만드세요
// 90점 이상: A
// 80점 이상: B
// 70점 이상: C
// 60점 이상: D
// 60점 미만: F

// 여러 점수로 테스트해보세요: 95, 87, 73, 65, 45
const scoreToGrade = (score) => {
  let result = "F";
  if (score >= 90) return (result = "A");
  else if (score >= 80) return (result = "B");
  else if (score >= 70) return (result = "C");
  else if (score >= 60) return (result = "D");
  else return (result = "F");
};

let score = 95;
console.log(score + " 의 등급은 -> " + scoreToGrade(score));
score = 87;
console.log(score + " 의 등급은 -> " + scoreToGrade(score));
score = 73;
console.log(score + " 의 등급은 -> " + scoreToGrade(score));
score = 65;
console.log(score + " 의 등급은 -> " + scoreToGrade(score));
score = 45;
console.log(score + " 의 등급은 -> " + scoreToGrade(score));

//6. switch 문 활용
// 요일 번호(1-7)를 받아서 요일명을 반환하는 함수를 만드세요
// 1: 월요일, 2: 화요일, ... 7: 일요일
// 잘못된 번호가 입력되면 "잘못된 요일 번호입니다" 반환

// 1부터 8까지의 숫자로 테스트해보세요
const numToDay = (num) => {
  switch (num) {
    case 1:
      return "월요일";
    case 2:
      return "화요일";
    case 3:
      return "수요일";
    case 4:
      return "목요일";
    case 5:
      return "금요일";
    case 6:
      return "토요일";
    case 7:
      return "일요일";
    default:
      return "잘못된 요일 번호입니다.";
  }
};

console.log("요일 번호 -> " + numToDay(1));
console.log("요일 번호 -> " + numToDay(2));
console.log("요일 번호 -> " + numToDay(3));
console.log("요일 번호 -> " + numToDay(4));
console.log("요일 번호 -> " + numToDay(5));
console.log("요일 번호 -> " + numToDay(6));
console.log("요일 번호 -> " + numToDay(7));
console.log("요일 번호 -> " + numToDay(8));

//7. 종합문제
// 간단한 계산기 객체를 만드세요
// 포함할 메서드:
// - add(a, b): 덧셈
// - subtract(a, b): 뺄셈
// - multiply(a, b): 곱셈
// - divide(a, b): 나눗셈 (0으로 나누기 체크)

// 그리고 계산 결과를 예쁘게 출력하는 함수도 만드세요
// 예: "10 + 5 = 15"
class calculator {
  constructor() {}

  add = (a, b) => {
    return a + b;
  };

  subtract = (a, b) => {
    return a - b;
  };
  multiply = (a, b) => {
    return a * b;
  };
  divide = (a, b) => {
    if (b == 0) return " 0으로는 나눌 수 없습니다.";
    return a / b;
  };

  formating = (method, a, b) => {
    let result = "";
    switch (method) {
      case "add":
        result = `${a} + ${b} = ${this.add(a, b)}`;
        break;
      case "subtract":
        result = `${a} - ${b} = ${this.subtract(a, b)}`;
        break;
      case "multiply":
        result = `${a} * ${b} = ${this.multiply(a, b)}`;
        break;
      case "divide":
        let canDivide = this.divide(a, b);
        if (typeof canDivide === "string") {
          result = canDivide;
          break;
        }
        result = `${a} / ${b} = ${canDivide}`;
        break;
      default:
        result = "add, subtract, multiply, divide 중에 선택해주세요";
        break;
    }

    return result;
  };
}

const cc = new calculator();
console.log(cc.formating("add", 3, 21));
console.log(cc.formating("adoo", 3, 21));
console.log(cc.formating("subtract", 3, 21));
console.log(cc.formating("multiply", 3, 21));
console.log(cc.formating("divide", 3, 21));
console.log(cc.formating("divide", 3, 0));

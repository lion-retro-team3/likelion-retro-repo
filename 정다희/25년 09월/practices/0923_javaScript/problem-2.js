// 함수 만들기
// 1. 두 숫자를 받아서 더한 결과를 반환하는 함수 add를 만드세요
const add = (a, b) => {
    return a + b;
};

// 2. 원의 반지름을 받아서 넓이를 계산하는 함수 getCircleArea를 만드세요 (π는 3.14 사용)
const PI = 3.14;

const getCirlceArea = (radius) => {
    return PI * radius * radius;
};

// 3. 이름을 받아서 "안녕하세요, [이름]님!"을 반환하는 함수 greet을 만드세요
const greet = (nm) => {
    return `안녕하세요, ${nm}님!`;
};

// 각 함수를 호출해서 결과를 확인해보세요
console.log("합: " + add(1, 2));
console.log("원의 넓이: " + getCirlceArea(10));
console.log(greet("홍길동"));
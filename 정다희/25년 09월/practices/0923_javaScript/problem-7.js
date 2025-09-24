// 간단한 계산기 객체를 만드세요
const calculater = {
    // - add(a, b): 덧셈
    add: function (a, b) {
        return a + b;
    },

    // - subtract(a, b): 뺄셈
    subtract: function (a, b) {
        return a - b;
    },

    // - multiply(a, b): 곱셈
    multiply: function (a, b) {
        return a * b;
    },

    // - divide(a, b): 나눗셈 (0으로 나누기 체크)
    divide: function (a, b) {
        if(b == 0) return "0으로 나눌 수 없습니다.";
        return a / b;
    }
};

// 그리고 계산 결과를 예쁘게 출력하는 함수도 만드세요
// 예: "10 + 5 = 15"
const print = (a, b, funcNm) => {
    switch (funcNm) {
        case "add":
            console.log(a + " + " + b + " = " + calculater.add(a, b));
            break;
        case "subtract":
            console.log(a + " - " + b + " = " + calculater.subtract(a, b));
            break;
        case "multiply":
            console.log(a + " * " + b + " = " + calculater.multiply(a, b));
            break;
        case "divide":
            console.log(a + " / " + b + " = " + calculater.divide(a, b));
            break;
        default:
            console.log("잘못 선택하셨습니다.");
    }
}

print(1, 2, "null");
print(1, 2, "add");
print(3, 2, "subtract");
print(3, 5, "multiply");
print(10, 2, "divide");
print(3, 0, "divide");


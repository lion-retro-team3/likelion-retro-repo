// 1. 과일 이름들이 담긴 배열을 만드세요 (최소 5개)
const fruits = ["사과", "딸기", "포도", "오렌지", "바나나"];

// 2. 배열의 첫 번째와 마지막 요소를 출력하세요
console.log("첫번쨰: " + fruits[0] + ", 마지막: " + fruits[fruits.length-1]);

// 3. 배열에 새로운 과일을 추가하세요
fruits.push("수박");
console.log("수박을 추가했어요: " + [fruits]);

// 4. 배열의 길이를 출력하세요
console.log("배열의 길이: " + fruits.length);

// 5. 특정 과일이 배열에 있는지 확인하는 코드를 작성하세요
console.log("fruits 배열에 " + (fruits.includes("포도") == true ? "포도가 있습니다" : "포도는 없습니다"));
console.log("fruits 배열에 " + (fruits.includes("망고") == true ? "망고가 있습니다" : "망고는 없습니다"));
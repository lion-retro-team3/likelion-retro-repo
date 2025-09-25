const todos = [
    { id: 1, text: "자바스크립트 입문", done: false },
    { id: 2, text: "함수 배우기", done: true },
    { id: 3, text: "객체와 배열 배우기", done: true },
    { id: 4, text: "배열 내장함수 배우기", done: false },
];

// 1. forEach
// 모든 할 일(`text`)을 한 줄씩 출력하세요.
console.log("=".repeat(10) + " 1. forEach " + "=".repeat(10));

todos.forEach((obj) => {
    console.log(obj.text);
})

// 2. map
// 각 할 일을 `"번호. 할 일"` 형식의 문자열 배열로 변환하세요.
// 예) ["1. 자바스크립트 입문", "2. 함수 배우기", ...]
console.log("\n" + "=".repeat(10) + " 2. map " + "=".repeat(10));

const todos2 = todos.map((obj) => {
    return obj.id + ". " + obj.text;
})

console.log(todos2);

// 3. filter
// 완료된(`done: true`) 할 일만 새로운 배열로 추출하세요.
console.log("\n" + "=".repeat(10) + " 3. filter " + "=".repeat(10));

const todos3 = todos.filter((obj) => {
    return obj.done === true;
})
console.log(todos3);

// 4. find
// 아이디(`id`)가 3인 할 일을 찾아서 출력하세요.
console.log("\n" + "=".repeat(10) + " 4. find " + "=".repeat(10));

const todos4 = todos.find((obj) => {
    return obj.id === 3;
})

console.log(todos4);

// 5. some
// 할 일 목록에 완료되지 않은(`done: false`) 항목이 하나라도 있는지 확인하세요.
console.log("\n" + "=".repeat(10) + " 5. some " + "=".repeat(10));

const hasFalse = todos.some((obj) => {
    return obj.done === false;
})

console.log(hasFalse == true ? "완료되지 않은 항목이 있다." : "완료되지 않은 항목이 없다.");

// 6. every
// 모든 할 일이 완료(`done: true`)되었는지 확인하세요.
console.log("\n" + "=".repeat(10) + " 6. every " + "=".repeat(10));

const isAllDone = todos.every((obj) => {
    return obj.done === true;
})

console.log(isAllDone == true ? "모두 완료됨." : "완료되지 않은 목록이 있음.");

// 7. reduce
// 완료된(`done: true`) 할 일이 몇 개인지 개수를 구하세요.
console.log("\n" + "=".repeat(10) + " 7. reduce " + "=".repeat(10));

const doneCnt = todos.reduce((acc, cur) => {
    if(cur.done === true) acc++;
    return acc;
}, 0);

console.log("완료된 항목: " + doneCnt + "개");

// 8. sort
// 아이디(`id`) 기준으로 내림차순 정렬한 새 배열을 만드세요.
console.log("\n" + "=".repeat(10) + " 8. sort " + "=".repeat(10));

const todos5 = [...todos].toSorted((a, b) => b.id - a.id); // 원본 유지

console.log(todos5);

// 9. findIndex
// 할 일 목록에서 `"배열 내장함수 배우기"`의 인덱스를 구하세요.
console.log("\n" + "=".repeat(10) + " 9. sort " + "=".repeat(10));

const idx = todos.findIndex((obj) => obj.text === "배열 내장함수 배우기");

console.log("Index: " + idx);

// 10. 종합
// `done`이 `false`인 항목들만 모아서, 그 `text` 값들만 새로운 배열로 만들어 출력하세요.
// 👉 결과: `["자바스크립트 입문", "배열 내장함수 배우기"]`
console.log("\n" + "=".repeat(10) + " 10. 종합 " + "=".repeat(10));

const todos6 = todos.filter((obj) => obj.done === false).map((obj) => obj.text);

console.log(todos6);
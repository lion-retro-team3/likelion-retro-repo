const todos = [
  { id: 1, text: "자바스크립트 입문", done: false },
  { id: 2, text: "함수 배우기", done: true },
  { id: 3, text: "객체와 배열 배우기", done: true },
  { id: 4, text: "배열 내장함수 배우기", done: false },
];

// 1️⃣ `forEach`

// 모든 할 일(text)을 한 줄씩 출력하세요.

// ---
console.log("=====1번=====");
console.log("오늘의 할 일 목록");
todos.forEach((todos) => {
  console.log(todos.text);
});
console.log("=====목록 끝=====");

// 2️⃣ `map`

// 각 할 일을 "번호. 할 일" 형식의 문자열 배열로 변환하세요.
// 예) ["1. 자바스크립트 입문", "2. 함수 배우기", ...]

// ---
console.log("=====2번=====");
console.log("오늘의 할 일 목록");
const todoString = todos.map((todo) => `${todo.id}. ${todo.text}`);
todoString.forEach((str) => {
  console.log(str);
});
console.log("=====목록 끝=====");
// 3️⃣ `filter`

// 완료된(done: true) 할 일만 새로운 배열로 추출하세요.
console.log("=====3번=====");
console.log("완료된 할 일 목록");
const finish = todos.filter((todo) => todo.done == true);
finish.forEach((str) => {
  console.log(str.text);
});
console.log("=====목록 끝=====");
// ---

// 4️⃣ `find`

// 아이디(id)가 3인 할 일을 찾아서 출력하세요.
console.log("=====4번=====");
const third = todos.find((todo) => todo.id == 3);
console.log(third);
const thirdindex = todos.findIndex((todo) => todo.id == 3);
console.log(thirdindex);
// ---

// 5️⃣ `some`

// 할 일 목록에 완료되지 않은(done: false) 항목이 하나라도 있는지 확인하세요.
console.log("=====5번=====");
const some = todos.some((todo) => todo.done == false);
console.log(`할 일 목록에 완료되지 않은 항목이 하나라도 있는가? ${some}`);

// ---

// 6️⃣ `every`

// 모든 할 일이 완료(done: true)되었는지 확인하세요.

console.log("=====6번=====");
const every = todos.every((todo) => todo.done == false);
console.log(`모든 할 일이 완료되었는가? ${every}`);

// ---

// 7️⃣ `reduce`

// 완료된(done: true) 할 일이 몇 개인지 개수를 구하세요.
console.log("=====7번=====");
const doneCount = todos.reduce((count, todo) => {
  return todo.done == true ? count + 1 : count;
}, 0);
console.log(`완료된 할 일의 개수는? ${doneCount}`);
// ---

// 8️⃣ `sort`

// 아이디(id) 기준으로 내림차순 정렬한 새 배열을 만드세요.
console.log("=====8번=====");
console.log("오늘의 할 일 목록");
const sorttodo = [...todos].sort((a, b) => b.id - a.id);
sorttodo.forEach((str) => {
  console.log(str);
});
console.log("=====목록 끝=====");
// ---

// 9️⃣ `findIndex`

// 할 일 목록에서 "배열 내장함수 배우기"의 인덱스를 구하세요.
console.log("=====9번=====");
const indexfind = todos.findIndex(
  (todo) => todo.text == "배열 내장함수 배우기"
);
console.log(indexfind);
// ---

// 🔟 종합 응용

// done이 false인 항목들만 모아서, 그 text 값들만 새로운 배열로 만들어 출력하세요.
console.log("=====10번=====");
const falsefilter = todos.filter((todo) => todo.done == false);
const unfinished = [];
falsefilter.forEach((str) => {
  unfinished.push(str.text);
});
console.log(unfinished);
// 👉 결과: ["자바스크립트 입문", "배열 내장함수 배우기"]

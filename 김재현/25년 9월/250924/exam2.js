const todos = [
  { id: 1, text: "자바스크립트 입문", done: false },
  { id: 2, text: "함수 배우기", done: true },
  { id: 3, text: "객체와 배열 배우기", done: true },
  { id: 4, text: "배열 내장함수 배우기", done: true },
];
// 1️⃣ `forEach`
// 모든 할 일(text)을 한 줄씩 출력하세요.
console.log("------1.forEach---------------------------------");
todos.forEach((t) => console.log(t.text));

// 2️⃣ `map`
// 각 할 일을 "번호. 할 일" 형식의 문자열 배열로 변환하세요.
// 예) ["1. 자바스크립트 입문", "2. 함수 배우기", ...]
console.log("------2.map---------------------------------");
const arr = todos.map((t) => t.id + ". " + t.text);
console.log(arr);

// 3️⃣ `filter`
// 완료된(done: true) 할 일만 새로운 배열로 추출하세요.
console.log("------3.filter---------------------------------");
const filterArr = todos.filter((t) => t.done);
console.log(filterArr);

// 4️⃣ `find`
// 아이디(id)가 3인 할 일을 찾아서 출력하세요.
console.log("------4.find---------------------------------");
console.log(todos.find((t) => t.id === 3).text);

// 5️⃣ `some`
// 할 일 목록에 완료되지 않은(done: false) 항목이 하나라도 있는지 확인하세요.
console.log("------5.some---------------------------------");
const isNotDone = todos.some((t) => !t.done);
if (isNotDone) {
  console.log("할 일이 남아있습니다.");
} else {
  console.log("일을 모두 마쳤습니다.");
}

// 6️⃣ `every`
// 모든 할 일이 완료(done: true)되었는지 확인하세요.
console.log("------6.every---------------------------------");
const isDone = todos.every((t) => t.done);
if (isDone) {
  console.log("일을 모두 마쳤습니다.");
} else {
  console.log("할 일이 남아있습니다.");
}

// 7️⃣ `reduce`
// 완료된(done: true) 할 일이 몇 개인지 개수를 구하세요.
console.log("------7.reduce---------------------------------");
const doneCount = todos.reduce((c, t) => (t.done ? c + 1 : c), 0);
console.log("완료된 할 일: " + doneCount);

// 8️⃣ `sort`
// 아이디(id) 기준으로 내림차순 정렬한 새 배열을 만드세요.
console.log("------8.sort---------------------------------");
const sorted = todos.sort((b, a) => a.id - b.id);
console.log(sorted);

// 9️⃣ `findIndex`
// 할 일 목록에서 "배열 내장함수 배우기"의 인덱스를 구하세요.
console.log("------9.findIndex---------------------------------");
const index = todos.findIndex((t) => t.text === "배열 내장함수 배우기");
console.log(index);

// 🔟 종합 응용
// done이 false인 항목들만 모아서, 그 text 값들만 새로운 배열로 만들어 출력하세요.
// 👉 결과: ["자바스크립트 입문", "배열 내장함수 배우기"]
console.log("------10.응용---------------------------------");
const newArr = todos.filter((t) => !t.done).map((t) => t.text);
console.log(newArr);

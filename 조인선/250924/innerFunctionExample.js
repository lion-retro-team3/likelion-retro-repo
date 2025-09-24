// 📘 실습 문제: 배열 내장 함수 연습
// 아래의 todos 배열을 이용해 문제를 풀어보세요.

const todos = [
  { id: 1, text: "자바스크립트 입문", done: false },
  { id: 2, text: "함수 배우기", done: true },
  { id: 3, text: "객체와 배열 배우기", done: true },
  { id: 4, text: "배열 내장함수 배우기", done: false },
];

// 1️⃣ forEach
// 모든 할 일(text)을 한 줄씩 출력하세요.
todos.forEach((todo) => {
  console.log(todo.text);
});

// 2️⃣ map
// 각 할 일을 "번호. 할 일" 형식의 문자열 배열로 변환하세요. 예) ["1. 자바스크립트 입문", "2. 함수 배우기", ...]
const todolist = todos.map((todo) => `${todo.id}. ${todo.text}`);
console.log(todolist);

// 3️⃣ filter
// 완료된(done: true) 할 일만 새로운 배열로 추출하세요.
const didlist = todos.filter((todo) => todo.done === true);
console.log(didlist);

// 4️⃣ find
// 아이디(id)가 3인 할 일을 찾아서 출력하세요.
const todoid = todos.find((toid) => toid.id === 3);
console.log(todoid);

// 5️⃣ some
// 할 일 목록에 완료되지 않은(done: false) 항목이 하나라도 있는지 확인하세요.
const AreyouDone = todos.some((todo) => todo.done === false);
console.log(AreyouDone);

// 6️⃣ every
// 모든 할 일이 완료(done: true)되었는지 확인하세요.
const AreYouDone = todos.every((todo) => todo.done === true);
console.log(AreYouDone);

// 7️⃣ reduce
// 완료된(done: true) 할 일이 몇 개인지 개수를 구하세요.
const ImDone = todos.reduce((count, todo) => {
  if (todo.done === true) {
    return count + 1;
  }
  return count;
}, 0);

//삼항연산자 const ImDone = todos.reduce((count,todo) => count + (todo.done ? 1 : 0),0); )

console.log(ImDone);

// 8️⃣ sort
// 아이디(id) 기준으로 내림차순 정렬한 새 배열을 만드세요.
todos.sort((a, b) => b.id - a.id);
console.log(todos);

// 9️⃣ findIndex
// 할 일 목록에서 "배열 내장함수 배우기"의 인덱스를 구하세요.
const WherAreYou = todos.findIndex((todo) => todo.id === 4);
console.log(WherAreYou);

// 🔟 종합 응용
// done이 false인 항목들만 모아서, 그 text 값들만 새로운 배열로 만들어 출력하세요.
// 👉 결과: ["자바스크립트 입문", "배열 내장함수 배우기"]

const Isfalse = todos.filter((todo) => !todo.done).map((todo) => todo.text);
console.log(Isfalse);

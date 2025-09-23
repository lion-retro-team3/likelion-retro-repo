// 객체 다루기
// 학생 정보를 담은 객체를 만드세요
// 포함할 정보: 이름, 나이, 학년, 좋아하는 과목들(배열)
const students = {
    _name: "홍길동",
    _age: 18,
    _grade: 2,
    _subjects: ["수학", "영어", "체육"],

    get name() {
        return this._name;
    },

    get age() {
        return this._age;
    },

    get grade() {
        return this._grade;
    },

    get subjets() {
        return this._subjects;
    }
}

let { name, age, grade, subjets } = students;

// 1. 학생의 이름을 출력하기
console.log("이름: " + name);

// 2. 학생의 나이를 1살 증가시키기
age = age + 1;
console.log("나이 1살 증가 결과: " + age);

// 3. 새로운 과목을 좋아하는 과목 배열에 추가하기
subjets.push("음악");

// 4. 학생 정보를 모두 출력하기
let text = ` - 학생의 정보 
    1. 이름 : ${name}
    2. 나이 : ${age}세
    3. 학년 : ${grade}학년
    4. 좋아하는 과목: ${subjets}`;

console.log(text);
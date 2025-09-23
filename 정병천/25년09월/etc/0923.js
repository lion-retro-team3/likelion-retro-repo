/** 문제1 ------------ */
// 다음 변수들을 선언하고 값을 할당하세요
// 1. 당신의 이름 (문자열)
// 2. 나이 (숫자)
// 3. 학생 여부 (불린)
// 그리고 이 정보들을 이용해 자기소개 문장을 만들어 console.log로 출력하세요
// 예: "안녕하세요, 저는 김철수이고 25살입니다. 학생입니다."
console.log(`문제1 ${'─'.repeat(17)}`);

let [name, age, check] = ['김철수', 25, true];

console.log(
    `안녕하세요, 저는 ${name}이고 ${age}살입니다. ${check ? '학생입니다.' : '학생아닙니다.'}`
);


/** 문제2 ------------ */
// 1. 두 숫자를 받아서 더한 결과를 반환하는 함수 add를 만드세요
// 2. 원의 반지름을 받아서 넓이를 계산하는 함수 getCircleArea를 만드세요 (π는 3.14 사용)
// 3. 이름을 받아서 "안녕하세요, [이름]님!"을 반환하는 함수 greet을 만드세요
// 각 함수를 호출해서 결과를 확인해보세요
const work02 = () => {
    const funcAdd = (a, b) => Number(a) + Number(b);
    const getCircleArea = (a) => (Number(a) * Number(a)) * Math.PI;
    const greet = (name) => console.log(`안녕하세요, [${name}]님!`);

    const init = () => {
        console.log(`문제2 ${'─'.repeat(17)}`);
        let a = prompt('[문제2] 숫자1 입력', '');
        let b = prompt('[문제2] 숫자2 입력', '');
        console.log(`${a} + ${b} = ${funcAdd(a,b)}`);

        let radius = prompt('[문제2] 반지름 입력', '');
        console.log(`반지름 ${radius}의 넓이 = ${getCircleArea(radius)}`);
        
        let name = prompt('[문제2] 이름 입력', '');
        greet(name);
    }

    init();
}
work02();

/** 문제3 ------------ */
// 학생 정보를 담은 객체를 만드세요
// 포함할 정보: 이름, 나이, 학년, 좋아하는 과목들(배열)

// 그리고 다음 작업들을 해보세요:
// 1. 학생의 이름을 출력하기
// 2. 학생의 나이를 1살 증가시키기
// 3. 새로운 과목을 좋아하는 과목 배열에 추가하기
// 4. 학생 정보를 모두 출력하기
console.log(`문제3 ${'─'.repeat(17)}`);

const student = {
    _name: '철수',
    _age: 20,
    _subjects: ['국어','영어','수학'],
}

console.log(student._name);
student._age += 1;
console.log(student._age);
student._subjects.push('과학');
console.log(student._subjects.toString());
console.log(student);


/** 문제4 ------------ */
// 1. 과일 이름들이 담긴 배열을 만드세요 (최소 5개)
// 2. 배열의 첫 번째와 마지막 요소를 출력하세요
// 3. 배열에 새로운 과일을 추가하세요
// 4. 배열의 길이를 출력하세요
// 5. 특정 과일이 배열에 있는지 확인하는 코드를 작성하세요
console.log(`문제4 ${'─'.repeat(17)}`);

const fruits = ['바나나','사과','포도','수박','딸기'];

console.log(`첫번째: ${fruits[0]}, 마지막: ${fruits[fruits.length - 1]}`);
fruits.push('샤인머스켓');
console.log(fruits.length);
console.log(`사과여부: ${fruits.includes('사과') ? '있음' : '없음'}`);



/** 문제5 ------------ */
// 점수를 받아서 등급을 반환하는 함수를 만드세요
// 90점 이상: A
// 80점 이상: B
// 70점 이상: C
// 60점 이상: D
// 60점 미만: F
// 여러 점수로 테스트해보세요: 95, 87, 73, 65, 45
console.log(`문제5 ${'─'.repeat(17)}`);

const gradeLabel = (num) => {
    if (num >= 90) return 'A';
    else if (num >= 80) return 'B';
    else if (num >= 70) return 'C';
    else if (num >= 60) return 'D';
    else return 'F';
}

console.log(`95점: ${gradeLabel(95)}`);
console.log(`87점: ${gradeLabel(87)}`);
console.log(`73점: ${gradeLabel(73)}`);
console.log(`65점: ${gradeLabel(65)}`);
console.log(`45점: ${gradeLabel(45)}`);


/** 문제6 ------------ */
// 요일 번호(1-7)를 받아서 요일명을 반환하는 함수를 만드세요
// 1: 월요일, 2: 화요일, ... 7: 일요일
// 잘못된 번호가 입력되면 "잘못된 요일 번호입니다" 반환
// 1부터 8까지의 숫자로 테스트해보세요
console.log(`문제6 ${'─'.repeat(17)}`);

const dayLabel = (num) => {
    switch(num) {
        case 1: return '월요일';
        case 2: return '화요일';
        case 3: return '수요일';
        case 4: return '목요일';
        case 5: return '금요일';
        case 6: return '토요일';
        case 7: return '일요일';
        default: return '잘못된 요일 번호입니다';
    }
}

for (let i = 0; i < 8; i++) {
    console.log(`${i + 1} : ${dayLabel(i + 1)}`);
}


/** 문제7 ------------ */
// 간단한 계산기 객체를 만드세요
// 포함할 메서드:
// - add(a, b): 덧셈
// - subtract(a, b): 뺄셈
// - multiply(a, b): 곱셈
// - divide(a, b): 나눗셈 (0으로 나누기 체크)
// 그리고 계산 결과를 예쁘게 출력하는 함수도 만드세요
// 예: "10 + 5 = 15"
console.log(`문제7 ${'─'.repeat(17)}`);

const calcObj = {
    add: (a, b) => a + b,
    subtract: (a, b) => a - b,
    multiply: (a, b) => a * b,
    divide: (a, b) => {
        if (b == 0) return '0으로 나눌 수 없습니다';
        return a / b;
    }
};
let num1 = 20, num2 = 3;

console.log(`${num1} + ${num2} = ${calcObj.add(num1, num2)}`);
console.log(`${num1} - ${num2} = ${calcObj.subtract(num1, num2)}`);
console.log(`${num1} * ${num2} = ${calcObj.multiply(num1, num2)}`);
console.log(`${num1} / ${num2} = ${calcObj.divide(num1, num2)}`);
console.log(`${num1} / 0 = ${calcObj.divide(num1, '0')}`);



/** 문제8 ------------ */
// 도서관 시스템을 만들어보세요
// 1. 책 객체들이 담긴 배열을 만드세요 (제목, 저자, 출간년도, 대여 상태)
// 2. 책 제목으로 검색하는 함수를 만드세요
// 3. 대여 가능한 책들의 제목만 출력하는 함수를 만드세요
// 4. 새 책을 추가하는 함수를 만드세요
console.log(`문제8 ${'─'.repeat(17)}`);

const booklib = {
    _books: [
        {title: '책1', author: '저자1', year: 2025, rent: false},
        {title: '책2', author: '저자2', year: 2024, rent: true},
        {title: '책3', author: '저자3', year: 2023, rent: false},   
        {title: '책4', author: '저자4', year: 2022, rent: true},
        {title: '책5', author: '저자5', year: 2021, rent: false},
    ],

    // 책제목 검색
    searchBookTitle: function(title) { 
        // find() : 조건에 맞는 첫번째 책 객체 반환
        let book = this._books.find(book => book.title === title);
        if(!book) return '결과 없음';
        else return book;
    },

    // 대여가능 책목록
    ableRentBooks: function() {
        // filter() : 조건에 맞는 것만 객체 반환
        // map() : 결과값 기준으로 새 배열 반환
        let books = this._books.filter(book => book.rent === false).map(book => (book.title));

        // 제목 + 저자만 추출할 경우 ({title: book.title, author: book.author})
        // let books = this._books.filter(book => book.rent === false).map(book => ({
        //     title: book.title,
        //     author: book.author
        // }));

        return books;
    },

    // 추가
    addBook: function(book) {
        if(!book || typeof book !== 'object') return false;

        let dataCheck = 
            typeof book.author !== 'string' 
            || typeof book.year !== 'number' 
            || typeof book.rent !== 'boolean';
        
        if(dataCheck) return false;
        this._books.push(book);
        return true;
    },

    get books() { 
        return this._books; 
    }
};  

console.log(booklib.searchBookTitle('책3'));
console.log(booklib.ableRentBooks());

const newBook = {title: '책6', author: '저자6', year: 2023, rent: true};
let result = booklib.addBook(newBook);
console.log(result ? '추가됨' : '추가안됨');

console.log(booklib.books);
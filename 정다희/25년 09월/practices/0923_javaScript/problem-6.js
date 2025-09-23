// 요일 번호(1-7)를 받아서 요일명을 반환하는 함수를 만드세요
// 1: 월요일, 2: 화요일, ... 7: 일요일
// 잘못된 번호가 입력되면 "잘못된 요일 번호입니다" 반환
const weekName = (num) => {
    switch (num) {
        case 1 :
            return '월요일';
        case 2 :
            return '화요일';
        case 3 :
            return '수요일';
        case 4 :
            return '목요일';
        case 5 :
            return '금요일';
        case 6 :
            return '토요일';
        case 7 :
            return '일요일';
        default :
            return '잘못된 요일 번호 입니다.';
    }
}

// 1부터 8까지의 숫자로 테스트해보세요
console.log("1은 " + weekName(1) + "입니다.");
console.log("2는 " + weekName(2) + "입니다.");
console.log("3은 " + weekName(3) + "입니다.");
console.log("4는 " + weekName(4) + "입니다.");
console.log("5는 " + weekName(5) + "입니다.");
console.log("6은 " + weekName(6) + "입니다.");
console.log("7은 " + weekName(7) + "입니다.");
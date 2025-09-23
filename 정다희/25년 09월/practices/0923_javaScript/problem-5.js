// 점수를 받아서 등급을 반환하는 함수를 만드세요
// 90점 이상: A
// 80점 이상: B
// 70점 이상: C
// 60점 이상: D
// 60점 미만: F
const grade = (score) => {
    if(score >= 90) return 'A';
    else if(score >= 80) return 'B';
    else if(score >= 70) return 'C';
    else if(score >= 60) return 'D';
    else return 'F';
}

// 여러 점수로 테스트해보세요: 95, 87, 73, 65, 45
console.log("95점은 " + grade(95) + "등급 입니다.");
console.log("87점은 " + grade(87) + "등급 입니다.");
console.log("73점은 " + grade(73) + "등급 입니다.");
console.log("65점은 " + grade(65) + "등급 입니다.");
console.log("45점은 " + grade(44) + "등급 입니다.");
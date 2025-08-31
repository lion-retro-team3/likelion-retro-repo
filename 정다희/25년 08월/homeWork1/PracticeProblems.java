package hw1;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeProblems {

    // 값을 입력받을 스캐너 생성
    private static final Scanner sc = new Scanner(System.in);

    // 메인 메서드
    public static void main(String[] args) {
        System.out.println("== 1. 정수를 입력받아 짝수/홀수 판별 ==");
        problem1();
        System.out.println("== 2. 세 개의 정수 중 가장 큰 수 출력 ==");
        problem2();
        System.out.println("== 3. 1부터 100까지의 합 ==");
        problem3();
        System.out.println("== 4. 구구단 출력 (2단 ~ 9단) ==");
        problem4();
        System.out.println("== 5. 1~50중 3의 배수이면서 5의 배수 출력 ==");
        problem5();
        System.out.println("== 6. 5개의 정수 배열에 저장 후, 최대값과 최소값 출력 ==");
        problem6();
        System.out.println("== 7. 입력받은 과일이 배열안에 존재하는지 찾는 프로그램 ==");
        problem7();
        System.out.println("== 8. 학생 5명의 점수 출력 ==");
        problem8();
        System.out.println("== 9. 숫자 맞추기 게임 ==");
        problem9();
        System.out.println("== 10. 로또 번호 생성기 ==");
        problem10();
    }

    // 정수를 입력받는 메서드
    public static int readInt(String prompt) {
        // 올바른 값을 입력 할 때까지 loof
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("잘못 입력 하셨습니다. 다시 입력 해 주세요.");
            }
        }
    }

    // 문자열을 입력받는 메서드
    public static String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    // 1. 정수 입력받고 짝수 / 홀수 판별
    public static void problem1() {
        int n = readInt("숫자를 입력하세요: ");
        String result = n % 2 == 0 ? "짝수입니다." : "홀수입니다.";
        System.out.println(result);
    }

    // 2. 세 개의 정수 입력받고 가장 큰 수 출력
    public static void problem2() {
        int maxNum;

        int n1 = readInt("첫번째 숫자 입력: ");
        maxNum = n1;

        int n2 = readInt("두번째 숫자 입력: ");
        if(n2 > maxNum) maxNum = n2;

        int n3 = readInt("세번째 숫자 입력: ");
        if(n3 > maxNum) maxNum = n3;

        System.out.println("가장 큰 숫자는 " + maxNum + "입니다.");
    }

    // 3. 1부터 100까지의 합
    public static void problem3() {
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
             sum += i;
        }

        System.out.println("1부터 100까지의 합: " + sum);
    }

    // 4. 구구단 출력 (2단 ~ 9단)
    public static void problem4() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.print(j + "*" + i + "=" + (j * i) + "\t");
            }
            System.out.println();
        }
    }

    // 5. 1~50중 3의 배수이면서 5의 배수인 수만 출력
    public static void problem5() {
        for (int i = 1; i <= 50 ; i++) {
            if((i % 3 == 0) && (i % 5 == 0)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // 6. 정수 5개를 입력받아 배열에 저장 후, 최대값과 최소값 출력.
    public static void problem6() {
        int arr[] = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = readInt((i + 1) + "번째 숫자 입력: ");
        }

        int minNum = arr[0];
        int maxNum = arr[0];

        for (int v : arr) {
            if (v < minNum) minNum = v;
            if (v > maxNum) maxNum = v;
        }

        System.out.println("최소값: " + minNum);
        System.out.println("최대값: " + maxNum);
    }

    // 7. 과일 이름 입력받아 배열 존재 여부 확인
    public static void problem7() {
        String fruits[] = {"사과", "바나나", "딸기", "포도"};
        String fruit = readLine("과일을 입력하세요: ");
        boolean hasFruit = false;

        for (String s : fruits) {
            if (s.equals(fruit)) {
                hasFruit = true;
                break;
            }
        }
        System.out.println(hasFruit ? fruit + "은(는) 배열에 있습니다." : fruit + "은(는) 배열에 없습니다." );
    }

    // 학생 5명의 점수
    public static void problem8() {
        int grades[] = new int[5];

        for (int i = 0; i < grades.length; i++) {
            grades[i] = readInt("학생" + (i + 1) + "의 점수: ");
        }

        int sum = 0;
        int maxGrade = grades[0];
        int count = 0;

        for (int grade : grades) {
            sum += grade;
            if(grade > maxGrade) maxGrade = grade;
            if(grade >= 60) count++;
        }

        double avg = (double)sum / grades.length;

        System.out.printf("%s%.1f%s\n", "평균점수: ", avg, "점");
        System.out.println("최고 점수: " + maxGrade + "점");
        System.out.println("60점 이상인 학생 수: " + count + "명");
    }

    // 9. 숫자 맞추기 게임
    public static void problem9() {
        int randomNum = (int)(Math.random() * 100) + 1;
//        System.out.println("정답: " + randomNum); // 디버깅용 정답

        while(true) {
            int userNum = readInt("숫자를 입력하세요: ");
            if(userNum > randomNum) {
                System.out.println("더 작은 수를 입력하세요.");
            }
            else if (userNum < randomNum) {
                System.out.println("더 큰 수를 입력하세요.");
            } else {
                System.out.println("정답입니다!");
                break;
            }
        }
    }

    // 10. 로또 번호 생성기
    public static void problem10() {
        int arr[] = new int[6];

        for (int i = 0; i < arr.length; i++) {
            int num = (int)(Math.random() * 45) + 1;
            boolean dup = false;

            for (int j = 0; j < i; j++) {
                if (arr[j] == num) {
                    dup = true;
                    break;
                }
            }

            if (dup) i--;
            else arr[i] = num;
        }

        Arrays.sort(arr);
        System.out.println("로또번호: " + Arrays.toString(arr));
    }
}

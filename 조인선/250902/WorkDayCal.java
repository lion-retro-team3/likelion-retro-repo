import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class WorkDayCal {
    public static void main(String[] args) {
        // 현재 날짜 기준으로 세우기
        LocalDate today = LocalDate.now();
        // 영업일 입력받기
        Scanner sc = new Scanner(System.in);
        System.out.println("며칠 뒤 영업일을 원하십니까? (예: 2) " + "오늘 날짜" + today);
        // 영업일 변수 초기화
        int i = sc.nextInt();
        //영업일 기준을 오늘로부터 계산 준비
        LocalDate workDate = today;
        //더해야하는 날짜 0부터 시작
        int addDay = 0;
        // 더해야 하는 날짜가 사용자가 원하는 날짜보다 작아질때까지 증가
        while (addDay < i) {
        // 현재 날짜부터 하루씩 뒤로 미루면서 요일판단
            workDate = workDate.plusDays(1);
            DayOfWeek day = workDate.getDayOfWeek();
        // 평일이면 증가
            if (day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY) {
                addDay++;
            }
        }
        // 출력
        System.out.println(i + "영업일 뒤 날짜는: " + workDate);
    }

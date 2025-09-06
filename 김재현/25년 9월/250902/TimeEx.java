import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class TimeEx {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // 1. D-day 계산기
        String[] sp = scanner.nextLine().split("-");
        int year = Integer.parseInt(sp[0]);
        int month = Integer.parseInt(sp[1]);
        int day = Integer.parseInt(sp[2]);
        LocalDate date = LocalDate.of(year, month, day);

        long result = ChronoUnit.DAYS.between(LocalDate.now(), date);

        if (result > 0) {
            System.out.println("D-" + result);
        } else if (result < 0) {
            System.out.println("D+" + (-result));
        } else {
            System.out.println("D-DAY");
        }

        // 2. 영업일 계산기
        LocalDate now = LocalDate.now();
        int num = scanner.nextInt();
        scanner.nextLine();
        int count = 0;

        while (num > count) {
            if (now.getDayOfWeek() != DayOfWeek.SATURDAY && now.getDayOfWeek() != DayOfWeek.SUNDAY) {
                count++;
                if (num == count) {
                    break;
                }
            }
            now = now.plusDays(1);
        }
        System.out.println(now);

        // 3. 근무일수 계산기
        String[] join = scanner.nextLine().split("-");
        int joinYear = Integer.parseInt(join[0]);
        int joinMonth = Integer.parseInt(join[1]);
        int joinDay = Integer.parseInt(join[2]);
        LocalDate joinDate = LocalDate.of(joinYear, joinMonth, joinDay);

        String[] quit = scanner.nextLine().split("-");
        int quitYear = Integer.parseInt(quit[0]);
        int quitMonth = Integer.parseInt(quit[1]);
        int quitDay = Integer.parseInt(quit[2]);
        LocalDate quitDate = LocalDate.of(quitYear, quitMonth, quitDay);

        int workCount = 0;
        while (!joinDate.isEqual(quitDate)) {
            if (joinDate.getDayOfWeek() != DayOfWeek.SATURDAY && joinDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
                workCount++;
            }
            joinDate = joinDate.plusDays(1);
        }

        System.out.println(workCount);
    }
}

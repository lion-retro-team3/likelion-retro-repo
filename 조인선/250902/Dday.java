import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import static Dday.ToDay.today;

class ToDay {
    public static final LocalDate today = LocalDate.now();

}
public class Dday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===계산할 날짜를 입력해주세요. (예) 2025-09-02===");
        String date = sc.nextLine();

        LocalDate dateParsed = LocalDate.parse(date);
        if(dateParsed.isAfter(today)) {

            long betweenDayToday = ChronoUnit.DAYS.between(dateParsed, today);

    System.out.println("D" + (betweenDayToday));
        }
        else if (dateParsed.isBefore(today)){

            long betweenDayToday = ChronoUnit.DAYS.between(dateParsed, today);

            System.out.println("D+" + (betweenDayToday));
        }
        else if (dateParsed.isEqual(today)){
            long betweenDayToday = ChronoUnit.DAYS.between(dateParsed, today);
            System.out.println("D- 00");
        }



    }

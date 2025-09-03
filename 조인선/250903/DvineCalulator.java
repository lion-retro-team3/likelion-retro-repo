import java.util.InputMismatchException;
import java.util.Scanner;


class InfinityIsMyException extends Exception{
    public  InfinityIsMyException(String msg){
        super(msg);
    }
}


public class DvineCalulator {
    public static void main(String[] args) {
        double a = 0;
        double b = 0;

        System.out.println("===나눗셈만 해드립니다.===");
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("첫번째 수를 입력하시오");
            a = sc.nextDouble();
            System.out.println("두번째 수를 입력하시오");
            b = sc.nextDouble();
            double result = a / b;
            if (Double.isInfinite(result)  || Double.isNaN(result))
                // 사용자 정의 예외를 한번 해본...
                throw new InfinityIsMyException("[!] 0으로는 나눌 수 없습니다.");

            System.out.println(a + " 나누기 " + b + " 는 " + result);

        } catch (InputMismatchException e) {
            System.out.println("[!] 숫자를 입력하시오.");
        } catch (ArithmeticException e) {
            System.out.println("[!] 0으로는 나눌 수 없습니다.");
        } catch(InfinityIsMyException e){
            System.out.println(e.getMessage());
        }

        sc.close();
    }

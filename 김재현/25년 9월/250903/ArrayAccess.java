import java.util.Arrays;

public class ArrayAccess {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        try {
            System.out.println("인덱스 0: " + numbers[0]);
            System.out.println("인덱스 3: " + numbers[3]);
            System.out.println("인덱스 10: " + numbers[10]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("존재하지 않는 인덱스입니다.");
        } finally {
            System.out.println("프로그램 종료");
        }

        int m = 10;
        try {
            for (int i = 0; i < m; i++) {
                System.out.println("numbers[i] = " + numbers[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("예외 발생: " + e);
            System.out.println("존재하지 않는 인덱스입니다.");
        } finally {
            System.out.println("프로그램 종료");
        }

        // ArrayIndexOutOfBoundsException 예외가 발생할 수 있는 흔한 상황
        // 인덱스가 1부터 시작하는 배열에 복사하는 과정에서
        // arr2[i] = arr[i]; -> 이렇게 복사하게되면 예외가 발생할 수 있다.
        int n = 10;
        int[] arr = new int[n]; // 0 ~ 9
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        System.out.println("arr = " + Arrays.toString(arr));

        int[] arr2 = new int[n + 1]; // 0 ~ 10
        for (int i = 1; i <= n; i++) {
            arr2[i] = arr[i - 1];
        }
        System.out.println("arr2 = " + Arrays.toString(arr2));
    }
}

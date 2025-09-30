package Practice.Thread;
import java.util.concurrent.ThreadLocalRandom;

public class DecrementCounter implements Runnable {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    @Override
    public void run() {
        System.out.println("Decrement 시작합니다. ");
        for (int i = 100; i >= 1; i--) {
            printCounter(i);
            if (!SleepRandom()) { // 인터럽트 발생하면 루프 중단
                return;
            }
        }
        System.out.println("Decrement 종료합니다. ");
    }

    private void printCounter(int number) {
        System.out.println("Decrement: " + number);
    }

    private boolean SleepRandom(){
        try {
            int delay = random.current().nextInt(11); // 0..10
            Thread.sleep(delay);
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(Thread.currentThread().getName() + " interrupted");
            return false;
        }
    }
}

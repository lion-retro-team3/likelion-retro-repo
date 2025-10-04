package Practice.Thread;

public class CounterApp {
    public static void main(String[] args) throws InterruptedException {
        Thread IC=new Thread(new IncrementCounter(),"IncrementThread");
        Thread DC=new Thread(new DecrementCounter(),"DecrementThread");

        IC.start();
        DC.start();

        IC.join();
        DC.join();

        System.out.println("모든 스레드 종료");
    }
}

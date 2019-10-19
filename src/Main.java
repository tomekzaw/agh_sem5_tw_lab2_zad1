import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BinarySemaphore sem = new BinarySemaphore();
        Counter counter = new Counter(sem);
        int times = 100_000_000;
        Thread t1 = new Thread(() -> IntStream.range(0, times).forEach(__ -> counter.decrement()));
        Thread t2 = new Thread(() -> IntStream.range(0, times).forEach(__ -> counter.increment()));
        t1.start(); // nie: t1.run()!
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getValue());
    }
}

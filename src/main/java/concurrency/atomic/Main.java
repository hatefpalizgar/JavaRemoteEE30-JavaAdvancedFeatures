package concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    // Non-atomic count
    // Because the count variable is not atomic,
    // it is possible for the threads to interfere with each other and produce an incorrect result
    // Remember thread local memory or cache?
    // private static int count = 0;

    // Atomic count
    private static AtomicInteger count = new AtomicInteger(0);

    // we say that an operation is atomic if, while it is being performed,
    // another thread cannot read or change the value of variables being changed,
    // something similar to synchronized (which applies to methods and blocks) but for variables

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    // count++;
                    count.incrementAndGet();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    // count++;
                    count.incrementAndGet();
                }
            }
        });

        t1.start();
        t2.start();


        // let's keep main thread waiting for t1 and t2 to finish their work
        t1.join();
        t2.join();

        System.out.println("Final count: " + count);
    }
}

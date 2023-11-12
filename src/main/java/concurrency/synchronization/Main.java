package concurrency.synchronization;

public class Main {
    public static void main(String[] args) {
        Bench bench = new Bench(1);

        Thread t1 = new SeatTakerThread(bench);
        Thread t2 = new SeatTakerThread(bench);

        t1.start();
        t2.start();
    }
}

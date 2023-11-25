package concurrency.volatiles;

// https://www.geeksforgeeks.org/volatile-keyword-in-java/
public class Main {

    // volatile keyword here makes sure that
    // the changes made in one thread are
    // immediately reflected in the other thread
    private static volatile int MY_INT = 0;

    // The values of the volatile variable will never be cached and all writes and reads will be done to and from the main memory.

    public static void main(String[] args) {
        new ChangeMaker().start();
        new ChangeListener().start();
    }


    static class ChangeMaker extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            while (MY_INT < 5) {
                System.out.println("Incrementing local_value to {" + (MY_INT + 1) + "}");
                MY_INT = ++local_value;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            while(local_value < 5) {
                if (local_value != MY_INT) {
                    System.out.println("Go change for MY_INT: {" + MY_INT + "}");
                    local_value = MY_INT;
                }
            }
        }
    }
}





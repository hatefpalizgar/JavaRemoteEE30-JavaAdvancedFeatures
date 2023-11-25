package concurrency;

// Concurrent / parallel / multithreaded programming
public class Main {

    /* ========================================================================= */
    //                     Creating and Starting Threads
    /* ========================================================================= */

    /*
 To create a thread in Java, you can do one of the following:
    1. Extend the Thread class and override its run() method
    2. Implement the Runnable interface and pass it to a Thread object in the constructor
    */
    public static void main1(String[] args) throws InterruptedException {
        System.out.println("Main thread starts: " + Thread.currentThread().getName());
        Thread.sleep(2000);  // it will pause current thread for 5 seconds (5000 milliseconds)
        System.out.println("Main thread is still running");
        Thread.sleep(2000);


        // below we are JUST creating the thread not STARTED it
        StopWatchThread myStopWatch = new StopWatchThread();

        // NEVER call run() of threads yourself; If you just call the run() method,
        // it will be executed in the same thread as the rest of your program, and the program will not run concurrently.
        // myStopWatch.run(); // thread is still `main`

         /*
        A thread is started only by calling its start() method;
        When you call the start() method on a Thread object, it does the following:

         1. Creates a new, concurrent thread of execution by asking it from operating system (Platform Thread).
         2. Calls the run() method of the Thread object in the new thread.

         The new thread is created by the operating system, and the Java runtime is responsible for managing it and scheduling it to run.
        */
        myStopWatch.start();

        // Let's create another thread and start it
        StopWatchThread myStopWatch2 = new StopWatchThread();
        myStopWatch2.start();

        // order of execution of threads is NOT guaranteed (Thread-0 and Thread-1 can run in any order)

        Runnable myRunnableThread = new RunnableThread();
        // myRunnableThread.run();   // NEVER call run()
        Thread myRunnableThreadUsingThreadClas = new Thread(myRunnableThread);
        myRunnableThreadUsingThreadClas.start();

        /* ========================================================================= */
        //                           Stopping Threads
        /* ========================================================================= */

        // How to stop a thread by calling the stop() method (deprecated as might cause data corruption)
        // or by using other methods such as interrupt() or volatile variables (volatile boolean flags to stop run method execution)
        // Refer to volatiles package

        /* ========================================================================= */
        //                States for Threads (running, waiting, dead)
        /* ========================================================================= */
        // The five states are as follows:
        //New: A thread is in this state when it has been created, but the start() method has not yet been called on it
        //Runnable: A thread is in this state when it is eligible to run, but the Java runtime has not yet selected it to run. This is also known as the "ready" state
        //Running: A thread is in this state when it is currently executing its run() method
        //Blocked (Non-runnable state): A thread is in this state when it is waiting for a resource that is currently held by another thread
        //Dead or Terminated: A thread is in this state when it has completed execution of its run() method or when it has been stopped

        /* ========================================================================= */
        //                              Synchronization
        /* ========================================================================= */
        /*
        * 1. What is synchronization?
                Synchronization is a mechanism that allows multiple threads to access shared resources (methods/variables) in a controlled manner,
                preventing race conditions and data corruption.
          2. Why is synchronization important?
                Without synchronization, it is possible for multiple threads to access a shared resource simultaneously, which can lead to race conditions and data corruption.
                Synchronization ensures that only one thread can access a shared resource at a time, preventing these issues.
        * */

        // 3. How to synchronize a method:
        class MyClass {
            // This causes the doSomething() method to be locked, so that only one thread can execute it at a time.
            // When a thread enters a synchronized method, it acquires the lock for the object on which the method is defined.
            // This means that other threads cannot enter any synchronized methods on the same object until the first thread has exited the method (released the lock)
            public synchronized void doSomething() {
                // code to be synchronized
            }
        }

        // 4. How to synchronize a block of code
        class MyClass2 {
            private Object lock = new Object();

            public void doSomethig() {
                // some logic
                synchronized (lock){
                    // some other logic that must be synchronized
                }
            }
        }


        /* ========================================================================= */
        //                                Thread Pools
        /* ========================================================================= */
        // Refer to threadpool package

        /* ========================================================================= */
        //                            Concurrent collections
        /* ========================================================================= */
        // Concurrent collections are data structures that are designed to support concurrent access and modification
        // by multiple threads.
        // In Java, the java.util.concurrent package provides several concurrent collection classes,
        // such as ConcurrentHashMap, CopyOnWriteArrayList, and BlockingQueue
        // Some key benefits of using concurrent collections include:
        // - Improved performance: Concurrent collections are designed to perform well in the presence of multiple threads,
        // and can often provide better performance than traditional collections in a concurrent setting
        // - Simplified thread safety: Concurrent collections provide built-in thread safety, so you don't have to manually synchronize access to the collection.
        // This can make it easier to write correct concurrent code
        // - Support for common concurrent scenarios: Concurrent collections provide support for common concurrent scenarios,
        // such as producer-consumer patterns and parallel processing.


        /* ========================================================================= */
        //                        Race conditions and Deadlocks
        /* ========================================================================= */
        // Deadlock: Deadlock occurs when two or more threads are blocked and waiting for each other to release a lock,
        // resulting in a standstill.
        // refer to deadlock package


    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();  // shared resource for t1 and t2
        Thread t1 = new IncrementThread(counter);
        Thread t2 = new IncrementThread(counter);
        t1.start();
        t2.start();
        t1.join();  // main thread waits for t1 to finish
        t2.join();  // main thread waits for t2 to finish
        System.out.println(counter.getCount());

        // Refer to synchronization package for more another code example

    }

}

class Counter {
    private int count = 0;
    // if we don't use `synchronized` keyword, it causes RACE CONDITION to happen.
    // RACE CONDITION: when two or more threads try to access shared resources concurrently,
    // and the outcome of the program depends on the interleaving of the threads
    // TODO: try to remove synchronized keyword here and run the app multiple times (you should get a different value each time)
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class IncrementThread extends Thread {
    private Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
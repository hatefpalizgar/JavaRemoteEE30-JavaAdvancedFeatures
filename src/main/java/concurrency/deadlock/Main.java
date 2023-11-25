package concurrency.deadlock;

public class Main {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Thread t1 = new DeadLockThread(resource);
        Thread t2 = new DeadLockThread(resource);

        t1.start();
        t2.start();

    }
}


class Resource {
    private boolean isLocked = false;

    public synchronized void acquire() {
        System.out.println("Thread[" + Thread.currentThread().getName() + "]: checking lock");
        while(isLocked) {
            System.out.println("Thread[" + Thread.currentThread().getName() + "]: waiting for lock to be release");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        System.out.println("Thread[" + Thread.currentThread().getName() + "]: lock is acquired");
    }


    public synchronized void release() throws InterruptedException {
        Thread.sleep(3000);
        isLocked = false;
        System.out.println("Thread[" + Thread.currentThread().getName() + "]: lock is released");
        notify();
    }

}


class DeadLockThread extends Thread {
    private Resource resource;

    public DeadLockThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.acquire();
        // if you want to prevent deadlock to happen, you have to make threads release the lock like below:
        // resource.release();
    }
}
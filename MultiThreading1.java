package Multithreading;

class SharedResource {
    private volatile boolean flag = false;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag() {
        return flag;
    }
}

public class MultiThreading1 {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 started");
            sharedResource.setFlag(true);
            System.out.println("Flag set to true");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 started");
            while (!sharedResource.getFlag()) { /* Busy-wait */ }
            System.out.println("Flag set to true, Thread 2 ended");
        });

        thread1.start();
        thread2.start();
    }
}

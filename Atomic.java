package Multithreading;

class SharedCounter {
    private volatile int counter =  0;

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }


}
public class Atomic {
    public static void main(String[] args) throws InterruptedException {
        SharedCounter sharedCounter = new SharedCounter();

        Thread t1 = new Thread( () -> {
            System.out.println("Thread 1 started");
            for(int i=0;i<500;i++) {
                sharedCounter.increment();
            }
            System.out.println("Thread 1 completed");

        } );

        Thread t2 =new Thread( () -> {
            System.out.println("Thread 2 started");
            for(int i=0;i<500;i++) {
                sharedCounter.increment();
            }
            System.out.println("Thread 2 completed");

        } );

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("final out "+ sharedCounter.getCounter());


    }
}

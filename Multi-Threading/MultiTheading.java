package Multithreading;

public class MultiTheading {
    public static void main(String args[]){

        //There are 3 ways of creating a thread


        // This is the legacy way of creating a thread. Creating a child class of Thread and implementing the run method
        MyThead thread1 = new MyThead();
        thread1.start();

        // Using functional programming/ lambda expression.
        Thread thread2 = new Thread( () -> {
            System.out.println("Thread 2 started");
        });

        thread2.start();

       
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 3 started");
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread 3 completed");
            }
        };

        Thread thread3 = new Thread(runnable, "Runnable Thread");
        thread3.start();

        System.out.println("main thread ended");


    }
}

class MyThead extends Thread {
    public void run() {
        System.out.println("Thread 1 started");
    }
}

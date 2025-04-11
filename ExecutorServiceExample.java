package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExecutorServiceExample {
    public static void main(String[] args) {

        //Will create a single thread.
        ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
        System.out.println("Single Thread Executor");

        for(int i=0;i<5;i++) {
            final int taskId = i;

            singleExecutorService.execute( () ->{
                System.out.println("Single thread task is executing task " +
                       taskId+ "on thread" + Thread.currentThread().getName());
            });

        }

        singleExecutorService.shutdown();

        //Will created fixed number of threads
        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(3);

        for(int i=0;i<5;i++) {
            int taskId = i;

            fixedExecutorService.execute( () -> {
                System.out.println("fixed thread is executig task" + taskId +
                        " on thread"+ Thread.currentThread().getName());
            });
        }

        fixedExecutorService.shutdown();


        //Will created threads as well and terminate them once done.
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for(int i=0; i<5;i++) {
            int taskId = i;
            cachedThreadPool.execute( () ->{
                System.out.println("cached thread is executig task" + taskId +
                        " on thread"+ Thread.currentThread().getName());
            });
        }
        cachedThreadPool.shutdown();

    }
}

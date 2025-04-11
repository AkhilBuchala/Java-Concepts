package Multithreading;

public class ThreadlocalDemo {

    public static void main(String[] args) {
       ThreadLocal<String> nameThreadLocal = new ThreadLocal<>();

       InheritableThreadLocal<String> inheritableThreadLocal =
               new InheritableThreadLocal<>();

       String firstName = "Akhil";
       String lastname = "Buchala";


       Thread thread1 = new Thread(() -> {
           Thread child = new Thread();
           System.out.println(firstName);
           nameThreadLocal.set(firstName);
           System.out.println("curr theard1 name is"+nameThreadLocal.get());
           nameThreadLocal.remove();
           System.out.println("curr theard1 name is after removing"+nameThreadLocal.get());
       });

        Thread thread2 = new Thread(() -> {
            System.out.println(lastname);
            nameThreadLocal.set(lastname);
            System.out.println("curr theard2 name is"+nameThreadLocal.get());
            nameThreadLocal.remove();
        });

        Thread thread3 = new Thread(() ->{
            System.out.println("Thread 3 started");
            inheritableThreadLocal.set("reddy");
            Thread child = new Thread(() ->{
                System.out.println("the child value is "+ inheritableThreadLocal.get());
            });
            child.start();
        });

        thread1.start();
        thread2.start();
        thread3.start();


    }
}

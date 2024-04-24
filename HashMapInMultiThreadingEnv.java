import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class HashMapInMultiThreadingEnv extends Thread {

    static ConcurrentHashMap<Integer, String> store = new ConcurrentHashMap<>();

    /*  Both HashMap and ConcurrentHashMap implement Map interface but the key difference is that,
    ConcurrentHashMap is threadSafe but not HashMap.

    In the following program, if we have defined 'store' as a HashMap instead of a ConcurrentHashMap,
    as soon as we start the thread at 'demo.start()', (key=1057, Value=H) will be stored in the HashMap,
    and the thread will sleep for 7000ms. Meanwhile, we would be running a for loop to put a few values into the map.
    As soon as the child thread starts, another thread will try to access the data in the map,
     to print the values in map (second for loop) and this will throw a ConcurrentModificationException.

    To handle this sort of scenario, we use ConcurrentHashMap instead of HashMap in a multithreading environment.

     */

    public void run() {
        try {
            System.out.println("someone woke me up");
            store.put(1057, "H");
            Thread.sleep(7000);
            System.out.println("I am back");
            store.put(104, "D");
            store.put(105, "E");
        } catch (InterruptedException e) {
            System.out.println("Child Thread going to add element");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        store.put(100, "A");
        HashMapInMultiThreadingEnv demo = new HashMapInMultiThreadingEnv();

        demo.start();

        for (int i = 0; i < 10; i++) {
            store.put(i, "Value" + i);
        }



        for (Object o : store.entrySet()) {
            Object s = o;
            System.out.println(s);
            Thread.sleep(5000);
        }

        System.out.println("map is" + store);
    }
}

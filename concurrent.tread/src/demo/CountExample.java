package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


public class CountExample {

    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    private static long count = 0;

    public static void main(String[] args) {
        ExecutorService exc = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);

        for(int i = 1; i <= clientTotal; i++){
            exc.execute(() -> {
                try {
                    semaphore.acquire();
                    count++;
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        exc.shutdown();
        System.out.println(count);
    }
}

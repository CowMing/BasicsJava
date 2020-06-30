package lifecycle;

/**
 * NEW、RUNNABLE、Terminated
 * RUNNABLE: 即使是正在运行的，也是runnable状态，而不是running状态
 * @author Ming
 */
public class NewRunnableTerminated implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new NewRunnableTerminated());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        Thread.sleep(10);
        System.out.println(thread.getState());
        Thread.sleep(5500);
        System.out.println(thread.getState());
    }
}

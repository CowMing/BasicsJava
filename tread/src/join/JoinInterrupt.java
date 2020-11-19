package join;

/**
 * @author Ming
 */
public class JoinInterrupt {

    public static void main(String[] args)  {
        Thread mainThread = Thread.currentThread();
        Thread childThread = new Thread(() -> {
            try {
                System.out.println("开启子线程");
                Thread.sleep(2000);
                mainThread.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        childThread.start();
        System.out.println("等待子线程结束");
        try {
            childThread.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "线程断了");
            e.printStackTrace();
        }
        System.out.println("子线程执行完");
    }
}

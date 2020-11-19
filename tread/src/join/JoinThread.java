package join;

public class JoinThread implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("开始执行子线程");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new JoinThread());
        Thread thread2 = new Thread(new JoinThread());
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println("结束");
    }
}

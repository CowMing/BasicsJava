package join;

public class JoinThreadState {

    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(999);
                System.out.println(mainThread.getName() + "状态：" + mainThread.getState());
            } catch (InterruptedException e) {
            }
        });
        t1.start();
        t1.join();

    }
}

package interrupt;

/**
 * 恢复中断
 * @author Ming
 */
public class RightWayStopThreadInProd2 implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()){
                System.out.println("保存日志");
                break;
            }
            reInterrupt();
        }
    }

    public void reInterrupt(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}

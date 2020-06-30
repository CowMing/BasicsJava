package lifecycle;

/**
 * Blocked, Waiting, TimeWaiting
 * @author Ming
 */
public class BlockedWaitingTimeWaiting implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        BlockedWaitingTimeWaiting bwtw = new BlockedWaitingTimeWaiting();
        Thread t1 = new Thread(bwtw);
        Thread t2 = new Thread(bwtw);
        t1.start();
        t2.start();
        Thread.sleep(50);
        System.out.println(t1.getState());
        System.out.println(t2.getState());
        Thread.sleep(3000);
        System.out.println(t1.getState());
    }

    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        try {
            Thread.sleep(2000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

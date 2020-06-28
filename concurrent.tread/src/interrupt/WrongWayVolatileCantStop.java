package interrupt;


/**
 * 陷入阻塞的时候，volatile 是无法停止线程的
 * @author Ming
 */
public class WrongWayVolatileCantStop implements Runnable {

    private volatile boolean canceled = false;

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 100000 && !canceled){
                if(num % 100 == 0){
                    System.out.println(num + "是100的倍数");
                }
                num++;
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatileCantStop w = new WrongWayVolatileCantStop();
        Thread thread = new Thread(w);
        thread.start();
        Thread.sleep(5000);
        w.canceled = true;
    }
}
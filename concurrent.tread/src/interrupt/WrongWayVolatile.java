package interrupt;

/**
 * volatile局限
 */
public class WrongWayVolatile implements Runnable {

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
        WrongWayVolatile w = new WrongWayVolatile();
        Thread thread = new Thread(w);
        thread.start();
        Thread.sleep(5000);
        w.canceled = true;
    }
}

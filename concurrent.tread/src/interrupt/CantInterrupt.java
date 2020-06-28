package interrupt;

/**
 * 如果while里面try/catch，会导致中断失效
 * @author Ming
 */
public class CantInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () ->{
            int num = 0;
            // java设计时，会把响应中断被catch抓住执行。由于sleep设计的理念，会清除interrupt标记位
            while (num <= 10000 && !Thread.currentThread().isInterrupted()){
                if(num % 100 == 0){
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
        Thread.sleep(500);
        t.interrupt();
    }
}

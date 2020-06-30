package interrupt;

/**
 * 带有sleep的中断线程的方法
 * @author Ming
 */
public class RightWayStopThreadWithSleep {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () ->{
            int num = 0;
            try {
                while (num <= 300 && !Thread.currentThread().isInterrupted()){
                    if (num % 100 == 0){
                        System.out.println(num + "是被100整除的数");
                    }
                    num++;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e){
                //该线程阻塞时，最简单的就是catch住，来响应中断信号
                e.printStackTrace();
            }
        };
        Thread t = new Thread(r);
        t.start();
        Thread.sleep(500);
        t.interrupt();
    }
}

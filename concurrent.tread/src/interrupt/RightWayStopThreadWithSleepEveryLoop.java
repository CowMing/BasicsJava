package interrupt;

/**
 * 如果执行过程中，每次循环都会调用sleep或者wait
 * @author Ming
 */
public class RightWayStopThreadWithSleepEveryLoop {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            int num = 0;
            try{
                while (num <= 1000 ){
                    if (num % 100 == 0){
                        System.out.println(num + "是被1000整除的数");
                    }
                    num++;
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(r);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }

}

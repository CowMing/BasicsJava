package interrupt;

/**
 * 错误停止线程的方法:
 * stop():线程运行到一半会突然停止运行
 * @author Ming
 */
public class WrongStopThread implements Runnable {


    /**
     * 模拟士兵领取弹药
     */
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("连队" + i + "开始领武器");
            for (int j = 1; j <= 10; j++) {
                System.out.println("编号： " + j + "领取成功");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("连队"+ i + "领取完毕");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new WrongStopThread());
        t.start();
        Thread.sleep(2000);
        t.stop();
    }
}

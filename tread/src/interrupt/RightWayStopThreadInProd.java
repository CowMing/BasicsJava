package interrupt;

public class RightWayStopThreadInProd implements Runnable {

    @Override
    public void run() {
        while( true && !Thread.currentThread().isInterrupted()){
            System.out.println("go");
            try{
                throwInMethod();
            } catch (InterruptedException e) {
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }

    }

    public static void throwInMethod() throws InterruptedException {
        Thread.sleep(100);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}

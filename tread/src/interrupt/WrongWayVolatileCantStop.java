package interrupt;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 陷入阻塞的时候，volatile 是无法停止线程的
 * @author Ming
 */
public class WrongWayVolatileCantStop  {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<Integer> ar = new ArrayBlockingQueue<>(10);

        Producer p = new Producer(ar);
        Thread thread = new Thread(p);
        thread.start();
        Thread.sleep(1000);

        Consumer c = new Consumer(ar);
        while(c.needMoreNum()){
            System.out.println(c.storage.take() + "消费了");
            Thread.sleep(10);
        }
        System.out.println("不再消费了");
        p.canceled = true;
    }
}

class Producer implements Runnable {

    public volatile boolean canceled = false;
    BlockingQueue storage;

    public Producer(BlockingQueue storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try{
            while(num <= 100000 && !this.canceled){
                if(num % 100 == 0){
                    storage.put(num);
                    System.out.println("生产了" + num);
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("停止生产了");
        }
    }
}

class Consumer {
    BlockingQueue storage;

    public Consumer(BlockingQueue storage){
        this.storage = storage;
    }

    public boolean needMoreNum(){
        if(Math.random() > 0.95){
            return false;
        }
        return true;
    }

}
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () ->{
            System.out.println(Thread.currentThread().getName());
        };

        r.run();
        new Thread(r).start();
    }
}

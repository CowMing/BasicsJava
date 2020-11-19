package uncaught;

public class UseOwnUncaughtExceptionHandler implements Runnable{


    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtException());
        new Thread(new UseOwnUncaughtExceptionHandler()).start();
        new Thread(new UseOwnUncaughtExceptionHandler()).start();
        new Thread(new UseOwnUncaughtExceptionHandler()).start();

    }
}

package design.pattern.creational.singletor;

/**
 * ThreadSafeSingleton
 * 线程安全单例类
 * @author Ming
 * @date 2019-12-03
 */
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){};

    /**
     * although it solve thread-safe problem,but it reduces the performance
     * because with the synchronized method
     * @return
     */
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}

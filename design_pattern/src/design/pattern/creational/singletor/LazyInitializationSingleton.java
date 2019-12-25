package design.pattern.creational.singletor;

/**
 * 懒加载
 * That is not thread-safe singleton class
 * @author Ming
 * @date 2019-12-03
 */
public class LazyInitializationSingleton {

    private static LazyInitializationSingleton instance;

    private LazyInitializationSingleton(){}

    public static LazyInitializationSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializationSingleton();
        }
        return instance;
    }
}

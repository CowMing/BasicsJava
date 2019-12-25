package design.pattern.creational.singletor;

/**
 * EagerSingle
 * 饿汉式-单例
 * @author Ming
 * @date 2019-12-03
 */
public class EagerInitializationSingleton {

    private static final EagerInitializationSingleton INSTANCE = new EagerInitializationSingleton();

    /**
     * private constructor to avoid client applications to use constructor
     */
    private EagerInitializationSingleton(){}

    public static EagerInitializationSingleton getInstance(){
        return EagerInitializationSingleton.INSTANCE;
    }

}

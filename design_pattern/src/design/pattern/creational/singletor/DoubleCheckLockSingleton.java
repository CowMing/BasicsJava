package design.pattern.creational.singletor;

/**
 * double-checked locking
 * 双重校验
 * @author Ming
 * @date 2019-12-03
 */
public class DoubleCheckLockSingleton {

    private static DoubleCheckLockSingleton instance;

    private DoubleCheckLockSingleton(){}

    /**
     * avoid this extra overhead every time, synchronized block is used inside the if condition,
     * english
     * @return
     */
    public static DoubleCheckLockSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckLockSingleton.class){
                if(instance == null){
                    instance = new DoubleCheckLockSingleton();
                }
            }
        }

        return instance;
    }
}

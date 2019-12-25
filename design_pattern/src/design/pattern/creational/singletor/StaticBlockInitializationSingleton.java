package design.pattern.creational.singletor;

/**
 * Static Block Initialization
 * That is not the best practice to use
 * 静态初始化块
 * @author Ming
 * @date 2019-12-03
 */
public class StaticBlockInitializationSingleton {

    private static StaticBlockInitializationSingleton INSTANCE;

    private StaticBlockInitializationSingleton(){}

    /**
     * static block initialization for exception handling
     */
    static{
        try{
            INSTANCE = new StaticBlockInitializationSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static StaticBlockInitializationSingleton getInstance(){
        return INSTANCE;
    }
}

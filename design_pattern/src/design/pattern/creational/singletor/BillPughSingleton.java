package design.pattern.creational.singletor;

/**
 * BillPughSingleton-I dont’t know why use name
 * 内部类
 * @author Ming
 * @date 2019-12-03
 */
public class BillPughSingleton {

    private BillPughSingleton(){}

    /**
     * more Java memory model please read related knowledge
     */
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    private static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}

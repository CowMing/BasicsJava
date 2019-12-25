package design.pattern.structural.adapter;

/**
 * use product
 * @author Ming
 * @date 2019-12-04
 */
public class Telephone {

    public void callCharge(Class clazz) throws IllegalAccessException, InstantiationException {
        if(!TypeCCable.class.getName().equals(clazz.getName())){
            throw new RuntimeException("NO! that is what I want");
        }
        System.out.println("so comfortable");
        DataCable o = (DataCable)clazz.newInstance();
        o.connect();
    }
}

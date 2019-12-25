package design.pattern.creational.factory;

/**
 * Super class can be an interface, abstract class or a normal java class
 * @author Ming
 * @date 2019-12-03
 */
public abstract class AbstractPerson {
    @Override
    public String toString() {
        return "AbstractItem: " + this.getClass();
    }
}

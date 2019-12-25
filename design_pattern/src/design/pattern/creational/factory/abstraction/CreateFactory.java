package design.pattern.creational.factory.abstraction;

/**
 * @author Ming
 * @date 2019-12-03
 */
public interface CreateFactory {

    /**
     * create different implementation
     * @return
     */
    AbstractComputer createComputer();
}

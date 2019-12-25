package design.pattern.creational.factory.abstraction;

/**
 * Maintain your products
 * @author Ming
 * @date 2019-12-03
 */
public class AcerFactory implements CreateFactory {

    @Override
    public AbstractComputer createComputer() {
        return new AcerComputer();
    }
}

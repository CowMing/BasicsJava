package design.pattern.creational.factory.abstraction;

/**
 * client cell
 */
public class Client {

    /**
     * The corresponding object is fetched by the client
     * @param args
     */
    public static void main(String[] args) {
        CreateFactory createFactory = new AcerFactory();
        AbstractComputer computer = createFactory.createComputer();
        System.out.println(computer);
    }
}

package design.pattern.creational.factory;

/**
 * Basic implementation
 * The so-called factory of to manage the creation of objects
 * @author Ming
 * @date 2019-12-03
 */
public class PersonFactory {

    public static AbstractPerson getPersonByString(String type){
        AbstractPerson instance = null;
        switch (type){
            case "woman":
                instance = new WomanPerson();
                break;
            case "man":
                instance = new ManPerson();
                break;
            default:
                throw new RuntimeException("why you understand ?");
        }
        return instance;
    }

    /**
     * of course, you can also use reflect, I recommend you use it
     * @param clazz
     * @param <E>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <E extends AbstractPerson> AbstractPerson AbstractPersonByClass(Class<E> clazz) throws IllegalAccessException, InstantiationException {
        AbstractPerson p = clazz.newInstance();
        return p;
    }

}

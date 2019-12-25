package design.pattern.structural.adapter;

/**
 * that all-powerful charge of ancient times
 */
public class AllPurpose {

    public Class getCable(String type){
        Class<? extends DataCable> clazz = null;
        switch (type){
            case "Type-C":
                clazz = TypeCCable.class;
                break;
            case "USB":
                clazz =  UsbCable.class;
                break;
            default:
                System.out.println("NO!NO!NO");
        }
        return clazz;
    }
}

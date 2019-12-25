package design.pattern.structural.adapter;

/**
 *
 * @author Ming
 * @date 2019-12-04
 */
public class UsbCable implements DataCable {


    @Override
    public void connect() {
        System.out.println("use UsbCable");
    }
}

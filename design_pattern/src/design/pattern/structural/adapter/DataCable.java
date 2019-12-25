package design.pattern.structural.adapter;

/**
 * definition DataCable, we have different charger, convert for different models
 * @author Ming
 * @date 2019-12-04
 */
public interface DataCable {

    /**
     * different equipment execute different manner
     */
    void connect();
}

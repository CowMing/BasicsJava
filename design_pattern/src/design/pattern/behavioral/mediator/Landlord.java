package design.pattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @date 2019-12-16
 */
public interface Landlord {

    /**
     * push service middleman
     */
    List<Intermediary> intermediaryList = new ArrayList<>();

    /**
     * landlord push house on the intermediary
     */
    void push();

}

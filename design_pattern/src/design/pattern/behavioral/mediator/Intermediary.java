package design.pattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Intermediary define feature
 * @author ming
 * @date 2019-12-16
 */
public interface Intermediary {

    List<String> advertisingList = new ArrayList<>();

    void uploading(Landlord landlord);

    void getAdvertising();

}

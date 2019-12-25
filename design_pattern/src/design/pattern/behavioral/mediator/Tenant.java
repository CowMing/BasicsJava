package design.pattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * tenant attention Intermediary terrace
 * @author ming
 * @date 2019-12-16
 */
public class Tenant {

    /**
     * user favorites list of Intermediary
     */
    List<Intermediary> collectIntermediary = new ArrayList<>();

    /**
     * add intermediary
     * @param intermediary
     */
    public void addIntermediary(Intermediary intermediary){
        this.collectIntermediary.add(intermediary);
    }


    /**
     * get all advertising of collect
     */
    public void getAllAdvertising(){
        for (Intermediary i : this.collectIntermediary) {
            i.getAdvertising();
        }
    }

}

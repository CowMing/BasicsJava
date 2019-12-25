package design.pattern.behavioral.responsibility;

import java.util.HashMap;

/**
 * Production product
 */
public class Production implements CallOut {

    @Override
    public void call(String even) {
        Dealer.setInventory(100);
    }

}

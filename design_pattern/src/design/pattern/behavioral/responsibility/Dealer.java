package design.pattern.behavioral.responsibility;

/**
 * Dealer, sell products
 */
public class Dealer implements CallOut {

    private CallOut callOut;

    private static int inventory;

    public Dealer(CallOut callOut){
        this.callOut = callOut;
    }

    public static void setInventory(int inventory){
        Dealer.inventory = inventory;
    }

    @Override
    public void call(String even) {
        if(10 >= this.inventory){
            callOut.call(even);
        }
        Dealer.inventory -= 10;
    }

}

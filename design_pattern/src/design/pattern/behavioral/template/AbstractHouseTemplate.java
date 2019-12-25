package design.pattern.behavioral.template;

/**
 * template method defines the steps to execute an algorithm
 */
public abstract class AbstractHouseTemplate {

    final void buildHouse(){
        buildFoundation();
        buildPillars();
        buildWalls();
        System.out.println("Wo ");
    }

    public abstract void buildFoundation();
    public abstract void buildPillars();
    public abstract void buildWalls();
}

package design.pattern.behavioral.template;

public class GlassHouse extends AbstractHouseTemplate {


    @Override
    public void buildFoundation() {
        System.out.println("Building Glass Foundation");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Glass Pillars");
    }

    @Override
    public void buildWalls() {
        System.out.println("Building Glass Pillars");
    }
}

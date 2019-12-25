package design.pattern.behavioral.template;

public class WoodenHouse extends AbstractHouseTemplate {

    @Override
    public void buildFoundation() {
        System.out.println("Building Wooden Foundation");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Wooden Pillar");
    }

    @Override
    public void buildWalls() {
        System.out.println("Building Wooden Walls");
    }

}

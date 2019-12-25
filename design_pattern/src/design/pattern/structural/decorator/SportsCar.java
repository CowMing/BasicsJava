package design.pattern.structural.decorator;

public class SportsCar extends BasicCar {

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Decorator Car");
    }

}

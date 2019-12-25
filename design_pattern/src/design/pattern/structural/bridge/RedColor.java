package design.pattern.structural.bridge;

public class RedColor implements Color {

    @Override
    public void applyColor() {
        System.out.println("red.");
    }
}

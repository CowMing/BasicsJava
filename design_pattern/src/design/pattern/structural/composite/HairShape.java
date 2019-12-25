package design.pattern.structural.composite;

/**
 * have a nice haircut.
 */
public class HairShape implements Shape {

    @Override
    public void draw(String color) {
        System.out.println("use" + color);
    }
}

package design.pattern.structural.composite;

/**
 * wear beautiful clothes.
 */
public class ClothingShape implements Shape {

    @Override
    public void draw(String color) {
        System.out.println("use" + color);
    }
}

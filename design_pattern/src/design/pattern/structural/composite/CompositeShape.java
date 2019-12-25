package design.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * combiner
 */
public class CompositeShape implements Shape {

    private List<Shape> list = new ArrayList<>(10);

    @Override
    public void draw(String color) {
        for (Shape s:
             list) {
            s.draw(color);
        }
    }

    public void add(Shape s){
        list.add(s);
    }

    public void remove(int index){
        list.remove(index);
    }

}

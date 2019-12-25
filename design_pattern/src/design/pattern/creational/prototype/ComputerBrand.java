package design.pattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * prototype design pattern that the copy object
 * @author Ming
 * @date 2019-12-04
 */
public class ComputerBrand implements Cloneable {

    private List<String> computerBrand;

    public ComputerBrand(){
        computerBrand = new ArrayList<>(10);
        computerBrand.add("Acer");
        computerBrand.add("Lenovo");
        computerBrand.add("Asus");
    }

    public ComputerBrand(List<String> list){
        this.computerBrand = list;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> collect = computerBrand.stream().collect(Collectors.toList());
        return new ComputerBrand(collect);
    }
}

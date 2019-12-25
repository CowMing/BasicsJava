package design.pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class PersonFactory {

    private static final Map<String, Race> map = new HashMap<>();

    public static Person createPerson(String name, String age, String sex, String raceName, String eyeColor, String hairColor){
        Race raceName1 = map.get("raceName");
        if (raceName1 == null){
            raceName1= new Race(raceName, eyeColor, hairColor);
            map.put(raceName, raceName1);
        }
        return new Person(name, age, sex, raceName1);
    }
}

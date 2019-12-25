package design.pattern.structural.flyweight;


/**
 * @author Ming
 * @date 2019-12-05
 */
public class Person {

    private String name;
    private String age;
    private String sex;
    private Race race;

    public Person(String name, String age, String sex, Race race) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.race = race;
    }
}

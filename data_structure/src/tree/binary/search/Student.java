package tree.binary.search;


public class Student implements Comparable<Student> {


    private int id;
    private String name;

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id + this.name;
    }

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }

}

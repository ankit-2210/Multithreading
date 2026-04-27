package inheritance.humans;

public class Grandparent {

    private String name;
    private int age;
    private boolean hasSuperPowers;

    public Grandparent(String name, int age){
        this.name=name;
        this.age=age;
        hasSuperPowers=false;
        System.out.println("Grandparent constructor called!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHasSuperPowers() {
        return hasSuperPowers;
    }

}

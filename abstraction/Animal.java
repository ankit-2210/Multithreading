package abstraction;

public abstract class Animal {

    private String name;
    private int age;

    private boolean hasSuperPower;

    protected Animal(){
        this.hasSuperPower=false;
    }

    // abstract method
    public abstract void sayHello();

    // concrete method
    public void sleep(){
        System.out.println("zzz...");
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
}

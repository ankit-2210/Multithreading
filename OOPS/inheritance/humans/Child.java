package inheritance.humans;

public class Child extends Parent{    // multi-level inheritance
    public Child(String name, int age){
        super(name, age);    // constructor called of parent class
        System.out.println("Child constructor called!");
    }

    public void childMethod(){
        System.out.println("Child method called");
        super.parentMethod();
    }
}

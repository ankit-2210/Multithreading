package inheritance.humans;

public class Parent extends Grandparent{
    public Parent(String name, int age){
        super(name, age);
        System.out.println("Parent constructor called!");
    }

    public void parentMethod(){
        System.out.println("Parent method called");
    }

}

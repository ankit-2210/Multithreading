package inheritance.animals;

public class Cat extends Animal{

    @Override
    public void sayHello(){     // method overriding
        System.out.println("Meow");
    }
}

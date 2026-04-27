package oops.Polymorphism;

public class Test {
    public static void main(String[] args){
        Animal dog = new Dog();   // object created for Dog but referencing it to Animal.
        dog.makeSound();

    }
}

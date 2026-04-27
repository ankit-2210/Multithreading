package accessmodifiers.zoo;

public class Test {
    public static void main(String[] args) {
        Dog dog=new Dog("Blob");
        dog.makeSound();
        dog.changeSound("Woof");  // Test main class is on same package where protected method is there so it can be useable
        dog.makeSound();
        dog.wagTail();

    }
}
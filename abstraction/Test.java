package abstraction;

public class Test {
    public static void main(String[] args){

        // Animal animal=new Animal();  // Animal class is abstract and cannot be instantiated

        Animal dog=new Dog();
        dog.sayHello();
    }
}

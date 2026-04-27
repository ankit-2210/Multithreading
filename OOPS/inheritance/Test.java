package inheritance;

import inheritance.animals.Cat;
import inheritance.animals.Dog;
import inheritance.humans.Child;
import inheritance.humans.Parent;
import inheritance.multipleInheritance.Smartphone;

public class Test {
    public static void main(String[] args){
        Dog dog = new Dog();      // single inheritance
        dog.setName("John");
        dog.setAge(17);
        System.out.println(dog.getName() + " " + dog.getAge());
        dog.eat();
        dog.sayHello();

        Child child=new Child("Ram", 9);     // multi-level inheritance
        Parent parent=new Parent("Mukesh", 30);

        Dog dog1=new Dog();    // hierarchical inheritance
        Cat cat=new Cat();

        Child child1=new Child("Shyam", 20);    // new -> dynamic memory allocation  (In, Runtime memory will be allocated)
        System.out.println(child1.isHasSuperPowers());
        child1.setAge(12);
        child1.childMethod();


        Smartphone smartphone = new Smartphone();
        smartphone.clickPhoto();
        smartphone.powerOn();   // ambiguity -> which powerOn method will call (Camera/MusicPlayer)


    }
}

package inheritance.animals;

import inheritance.animals.Animal;

public class Dog extends Animal {

    @Override
    public void sayHello(){     // method overriding
        System.out.println("Woof");
    }

    public void sayBye(){
        System.out.println("Woof Bye");
    }

}

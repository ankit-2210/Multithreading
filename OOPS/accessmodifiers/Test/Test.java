package accessmodifiers.Test;

import accessmodifiers.school.Student;
import accessmodifiers.school.Utils;
import accessmodifiers.zoo.Dog;

// public - anywhere can access it
// private -  class level
// protected -
// default - no keyword  (In same package the class/methods will be called but not from another package



public class Test {
    public static void main(String[] args){
        Student student=new Student();
        student.name="Ram";
        student.age=12;
        student.sayHello();
        student.sayBye();
        Student.sayBye();   // the class is calling a method as the method is static

        Utils.sayHello();

        School.getInstance();
        School.getInstance();

        Dog dog=new Dog("Blob");
        dog.makeSound();
//      dog.changeSound("Woof"); // 'changeSound(java.lang.String)' has protected access in 'accessmodifiers.zoo.Animal' - Test main class is on another package
        dog.setDogSound("Woof");
        dog.makeSound();
        dog.wagTail();






    }
}

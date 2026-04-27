package accessmodifiers.zoo;

public class Dog extends Animal{

    public Dog(String name){
        super(name, "Bark");
    }

    public void wagTail(){
        System.out.println(getName() + " is wagging its tail");
    }

    private String getName(){
        return getClass().getSimpleName();
    }

   public void setDogSound(String newSound){   // only those class can use this method whose is extends Animal class
        changeSound(newSound);
   }




}

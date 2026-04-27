package encapsulation;

public class Student {
    // properties/fields/instance variable & behaviour

    private String name;   // instance variable
    private int rollNumber;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<0){
            this.age=0;
            System.out.println("Invalid Number");
        }
        else {
            this.age = age;
        }
    }

    //    public static void main(String[] args){
//        String name;  // local variable
//    }


}

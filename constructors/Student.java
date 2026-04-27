package constructors;

// constructors used to initialize the object.

public class Student {
    private String name;   // instance variable
    private int rollNumber;
    private int age;

    public Student(){   // overloaded constructor
        this.age=10;
    }

    public Student(int age, String name, int rollNumber){   // parameterized constructors
        this.age=age;
        this.name=name;
        this.rollNumber=rollNumber;
    }

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
        this.age=age;
    }
}

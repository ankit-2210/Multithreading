package FinalKeyword;

import abstraction.Vehicle;

public class Car extends Vehicle {

    private final int speedLimt=200;    // it is final value so it will not initialize another value.

    public int getSpeedLimt(){
        return speedLimt;
    }

    @Override
    public void accelerate() {

    }

    @Override
    public void decelerate() {

    }

    public final void airBags(){
        System.out.println("4 Air bags");
    }
}


// If the class is final then we cannot inherit from another class.
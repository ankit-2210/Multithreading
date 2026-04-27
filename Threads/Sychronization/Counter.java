package com.thread.Sychronization;

public class Counter {

    private int count=0;

    public synchronized void increment(){   // solution of race condition is to make method synchronized - mutual exclusive (multiple thread use the method simultaneously)
        count++;
    }

    public int getCount(){
        return count;
    }

}

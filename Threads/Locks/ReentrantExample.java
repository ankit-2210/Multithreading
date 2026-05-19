package com.thread.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private final Lock lock=new ReentrantLock();  // reenter inside the lock

    public void outerMethod(){
        lock.lock();
        try{
            System.out.println("Outer Method");
            innerMethod();
        }
        finally {
            lock.unlock();
        }
    }

    public void innerMethod(){
        lock.lock();   // Deadlock  --> not happens it will acquire again ie, reentered
        try{
            System.out.println("Inner Method");
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        ReentrantExample example=new ReentrantExample();
        example.outerMethod();
    }

}

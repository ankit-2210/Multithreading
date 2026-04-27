package com.thread.ThreadLifeCycle;

public class ThreadLifecycle extends Thread{
    @Override
    public void run(){
        System.out.println("RUNNING");  // RUNNING
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadLifecycle t1=new ThreadLifecycle();
        System.out.println(t1.getState());   // NEW
        t1.start();
        System.out.println(t1.getState());   // RUNNABLE
        Thread.sleep(100);
        System.out.println(t1.getState());    // TIMED_WAITING
        t1.join();   // waits for t1 to terminate execute.
        System.out.println(t1.getState());    // TERMINATED


    }
}

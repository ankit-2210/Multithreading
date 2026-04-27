package com.thread.ThreadClassMethods;

public class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }

    @Override
    public void run(){
        for(int i=1; i<5; i++){
            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority() + " - count: " + i);

            try {
                Thread.sleep(1000);
                System.out.println("Thread is running..." + i);
                Thread.yield();
            }
            catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread l = new MyThread("Low Priority Thread");    // l, m, h are user Thread here
        MyThread m = new MyThread("Medium Priority Thread");
        MyThread h = new MyThread("High Priority Thread");
        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);
        l.start();
        m.start();
        h.start();

        System.out.println("Hello");

        MyThread t1=new MyThread("Interrupt");    // t1 is Daemon Thread here
        t1.setDaemon(true);   // The shutdown sequence begins when all started non-daemon(background) threads have terminated.
        t1.start();
//        t1.interrupt();
        System.out.println("Main done");

    }

}


// start
// run
// sleep
// join
// setPriority
// interrupt
// yield
// setDaemon
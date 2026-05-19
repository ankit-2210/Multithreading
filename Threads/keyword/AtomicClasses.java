package keyword;

import java.util.concurrent.atomic.AtomicInteger;

// AtomicInteger is a class used in multithreading to perform thread-safe atomic operations on an integer without using locks.

public class AtomicClasses {
    public AtomicInteger atomicInteger = new AtomicInteger();
    public void increment(){
        atomicInteger.incrementAndGet();
    }

    public int getCounter(){
        return atomicInteger.get();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicClasses atomicClasses = new AtomicClasses();
        Thread t1 = new Thread(()->{
            for(int i=0; i<1000; i++){
                atomicClasses.increment();;
            }
        });
        Thread t2 = new Thread(()->{
            for(int i=0; i<1000; i++){
                atomicClasses.increment();;
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(atomicClasses.getCounter());


    }
}

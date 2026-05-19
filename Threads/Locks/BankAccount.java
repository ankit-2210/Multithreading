package com.thread.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class BankAccount {

    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);

        try {
            // Try to acquire lock within 1 second
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                        Thread.sleep(3000); // Simulate processing
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining amount: " + balance);
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // restore interrupt flag
                        System.out.println(Thread.currentThread().getName() + " was interrupted during sleep");
                    }
                    finally {
                        lock.unlock();
                    }
                }
                else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance");
                }

            }
            else {
                System.out.println(Thread.currentThread().getName() + " could not acquire lock, skipping withdrawal");
            }
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // restore interrupt flag
            System.out.println(Thread.currentThread().getName() + " was interrupted while waiting for lock");
        }

        if(Thread.currentThread().isInterrupted()){
            System.out.println("Interrupted");
        }
    }
}

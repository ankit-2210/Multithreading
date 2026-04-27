package com.thread.ThreadCommunication;

class SharedResources{
    private int data;

    private boolean hasData;

    public synchronized void produce(int value){
        while (hasData){
            try {
                wait();
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        data=value;
        hasData=true;
        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized int consume(){
        while (!hasData){
            try {
                wait();
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        hasData=false;
        System.out.println("Consumed: " + data);
        notify();
        return data;
    }
}

class Producer implements Runnable{
    private SharedResources resource;

    public Producer(SharedResources resource){
        this.resource=resource;
    }

    @Override
    public void run(){
        for(int i=0; i<5; i++){
            resource.produce(i);
        }
    }
}

class Consumer implements Runnable{
    private SharedResources resource;

    public Consumer(SharedResources resource){
        this.resource=resource;
    }

    @Override
    public void run(){
        for(int i=0; i<5; i++){
            int val=resource.consume();
            System.out.println(val);
        }
    }
}


public class Communication {
    public static void main(String[] args){
        SharedResources resource = new SharedResources();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();
    }
}

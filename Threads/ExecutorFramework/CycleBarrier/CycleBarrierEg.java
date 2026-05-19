package ExecutorFramework.CycleBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CycleBarrierEg {
    public static void main(String[] args) {
        int numberOfSubsystems=4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfSubsystems, new Runnable() {
            @Override
            public void run() {
                System.out.println("All subsystems are up and running. System startup complete.");
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfSubsystems);
        executorService.submit(new Subsystem("Web Server", 2000, cyclicBarrier));
        executorService.submit(new Subsystem("Database", 4000, cyclicBarrier));
        executorService.submit(new Subsystem("Cache", 3000, cyclicBarrier));
        executorService.submit(new Subsystem("Messaging Service", 3500, cyclicBarrier));

        executorService.shutdown();
    }
}

class Subsystem implements Runnable{
    private String name;
    private int initializationTime;
    private CyclicBarrier cyclicBarrier;

    public Subsystem(String name, int initializationTime, CyclicBarrier cyclicBarrier){
        this.name = name;
        this.initializationTime = initializationTime;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " initialization started.");
            Thread.sleep(initializationTime);
            cyclicBarrier.await();
            System.out.println(name + " initialization complete.");
        }
        catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

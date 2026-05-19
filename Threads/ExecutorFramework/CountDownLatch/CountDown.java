package ExecutorFramework.CountDownLatch;

import java.util.concurrent.*;

// CountDownLatch is a synchronization utility that allows one or more threads to wait until a set of operations
// being performed in other threads completes. It is part of the Java Concurrency API.
//  e.g Think of it like a gate that opens only after a certain number of signals are received.

// You create a CountDownLatch with a count (number of tasks).
// Worker threads perform tasks.
// Each worker calls countDown() when finished.
// The waiting thread calls await() and blocks until the count becomes 0.
// Once the count reaches 0, all waiting threads continue.

public class CountDown {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numOfServices=3;
        ExecutorService executorService = Executors.newFixedThreadPool(numOfServices);
        CountDownLatch countDownLatch = new CountDownLatch(numOfServices);
        executorService.submit(new DependentService(countDownLatch));
        executorService.submit(new DependentService(countDownLatch));
        executorService.submit(new DependentService(countDownLatch));
        countDownLatch.await();

        System.out.println("All dependent services finished. Starting main services!!");
        executorService.shutdown();
    }
}

class DependentService implements Callable<String>{

    private final CountDownLatch countDownLatch;

    public DependentService(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started..");
        Thread.sleep(2000);
        countDownLatch.countDown();
        return "ok";
    }
}
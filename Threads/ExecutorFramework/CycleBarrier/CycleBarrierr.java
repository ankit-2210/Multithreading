package ExecutorFramework.CycleBarrier;


// A CyclicBarrier lets multiple threads wait at a barrier point until
// all threads arrive, and then all threads continue execution together.
// Eg:-  Imagine 3 runners in a race checkpoint:
// Each runner reaches the checkpoint.
// They wait until all runners arrive.
// Once all are there → the race continues together.

import java.util.concurrent.*;

public class CycleBarrierr {
    public static void main(String[] args) {
        int numOfServices = 3;

        ExecutorService executorService = Executors.newFixedThreadPool(numOfServices);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(numOfServices, () ->
                System.out.println("All dependent services finished. Starting main services!!")
        );

        executorService.submit(new DependentServiceee(cyclicBarrier));
        executorService.submit(new DependentServiceee(cyclicBarrier));
        executorService.submit(new DependentServiceee(cyclicBarrier));

        System.out.println("Main");  // cycle barrier is not applicable for main class.

        executorService.shutdown();

    }
}

class DependentServiceee implements Callable<String> {
    private final CyclicBarrier cyclicBarrier;

    public DependentServiceee(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started..");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " waiting at barrier..");
        cyclicBarrier.await();   // when all the threads coming at this position then carrier action will perform ie, i have done print.
        System.out.println(Thread.currentThread().getName() + " passed the barrier");
        return "ok";
    }
}
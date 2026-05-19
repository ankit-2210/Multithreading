package ExecutorFramework;

import java.util.concurrent.*;
//import java.util.concurrent.TimeUnit;

// ScheduledExecutorService extends ExecutorService extends Executor
// Used to schedule tasks after a delay or periodically.

public class ScheduleExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//        scheduledExecutorService.schedule(()->System.out.println("Task executed after 5 second"), 5,  5);

//        scheduledExecutorService.scheduleWithFixedDelay(()->{
//           System.out.println("Task executed after 5 second");
//           }, 5, 5, 5);

//        scheduledExecutorService.schedule(()-> {
//                    System.out.println("Initiating shutdown...");
//                    scheduledExecutorService.shutdown();
//                }, 20, 5);
//        scheduledExecutorService.shutdown();

    }
}

// .schedule()
// .scheduleAtFixedRate()

// Thread Pools:
// 1. newScheduledThreadPool();
// 2. newFixedThreadPool();
// 3. newSingleThreadExecutor();
// 4. newCachedThreadPool();



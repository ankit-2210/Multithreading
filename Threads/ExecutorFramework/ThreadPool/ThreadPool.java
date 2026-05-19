package ExecutorFramework.ThreadPool;

import java.util.concurrent.*;

// Thread Pools:
// 1. newScheduledThreadPool();
// 2. newFixedThreadPool();
// 3. newSingleThreadExecutor();
// 4. newCachedThreadPool();

// Collection of pre-initialized threads that are ready to perform a task
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(()->{
            System.out.println("Task executed by " + Thread.currentThread().getName());
        });

        ExecutorService executorService1 = Executors.newCachedThreadPool();
        executorService1.submit(()->{
            System.out.println("Running Task");
        });

        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        executorService2.submit(()->{
            System.out.println("Task 1");
        });
        executorService2.submit(()->{
            System.out.println("Task 2");
        });

//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
//        scheduledExecutorService.schedule(()->{
//           System.out.println("Task after 3 seconds");
//        }, 3, TimeUnit.SECONDS);

        executorService.shutdown();
        executorService1.shutdown();
        executorService.shutdown();
    }
}

// why?
// 1. Resource Management
// 2. Response Time
// 3. Control over Thread count


// 1. newFixedThreadPool() -> Creates a thread pool with a fixed number of threads.
// Number of threads is constant.
// If all threads are busy, tasks wait in a queue.
// Good for controlling CPU usage.

// 2. newCachedThreadPool() -> Creates a dynamic thread pool.
// Creates new threads when needed.
// Reuses previously created threads.
// Idle threads are removed after 60 seconds.


// 3. newSingleThreadExecutor() -> Creates a thread pool with only one worker thread.
// Executes tasks sequentially.
// Guarantees order of execution.


// 4. newScheduledThreadPool() -> Creates a pool that runs tasks after a delay or periodically.
// Supports delayed execution
// Supports repeated tasks










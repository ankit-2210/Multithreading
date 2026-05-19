package ExecutorFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.*;

public class Futuree<I extends Number> {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        java.util.concurrent.Future<?> future =  executorService.submit(()->{
            System.out.println("Hello");
            return 1;
        });

        System.out.println(((java.util.concurrent.Future<?>) future).get());
        executorService.shutdown();

        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        Callable<Integer> callable1=()->{
            Thread.sleep(1000);
            System.out.println("Task 1");
            return 1;
        };
        Callable<Integer> callable2=()->{
            Thread.sleep(1000);
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3=()->{
            Thread.sleep(1000);
            System.out.println("Task 3");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);
        List<java.util.concurrent.Future<Integer>> futures = executorService1.invokeAll(list);
        for(java.util.concurrent.Future<Integer> future1: futures){
            System.out.println(future1.get());
        }

        Integer i = executorService1.invokeAny(list);
        System.out.println(i);   // return 1 as first task is running first.

        executorService1.shutdown();
        System.out.println("Hello World");
        System.out.println(executorService1.isTerminated());


    }
}


// Difference between Runnable & Callable
// Runnable - no returnable, run method, no signature but write try catch block
// Callable = returnable, call method, signature throws Exception


// ExecutorService
// .submit(Runnable r)     .submit(Callable call)     .submit(Runnable r, return)
// .shutdown()
// .shutdownNow()
// .awaitTermination()
// .isShutdown()
// .isTerminated()
// .invokeAll()
// .invokeAny()

// Task (Runnable / Callable)
//        ↓
// ExecutorService
//        ↓
// Thread Pool
//        ↓
// Worker Thread executes task


// Future
// .get()
// .isDone()
// .isCancelled
// .get(time)





package ExecutorFramework;

import java.util.concurrent.CompletableFuture;


// It represents a future result of an asynchronous computation.

// Unlike Future, it allows:
// 1. Async execution
// 2. Task chaining
// 3. Combining multiple tasks
// 4. Exception handling
// 5. Non-blocking callbacks
// eg. Think of it like a pipeline of asynchronous tasks.
//     Task1 → Task2 → Task3 → Final Result
//     Each step runs automatically after the previous one completes.

public class CompletableFuturee {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(()->{
           try {
               Thread.sleep(5000);
               System.out.println("Completable Future 1");
           }
           catch (Exception e){
               e.printStackTrace();
           }
            return "ok";
        });

        String s = completableFuture1.getNow("Y");
        System.out.println(s);

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(5000);
                System.out.println("Completable Future 2");
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return "ok";
        });

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(completableFuture1, completableFuture2);
        completableFuture.join();   // Useful for parallel processing.

        System.out.println("Main");
    }
}

// supplyAsync() runs the task in another thread
// join() waits for the result


// By default, CompletableFuture tasks often run on daemon threads ue to the use of ForkJoinPool.commonPool
// You can control the thread type by providing a custom executor service.
// The CompletableFuture task itself doesn't dictate whether it's a daemon or user thread.


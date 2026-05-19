package ExecutorFramework;

import java.util.concurrent.*;


// A Future represents the result of an asynchronous computation that will be available later.
// a. Cannot chain tasks
// b. Cannot combine multiple futures easily
// Problem with Future:
//       get() blocks the thread until the result is available.
//       future.get() -→ waiting

// CompletableFuture solves the limitations of Future.
// It supports:
// a. async pipelines
// b. callbacks
// c. parallel execution

// Execution flow:
// Async Task → Transform → Print
// No blocking required.

public class FutureVsCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(2000);
            return 10;
        });
        Integer i = future.get(); // blocking call
        System.out.println(i);

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            }
            catch (Exception e) { }
            return 10;
        });
        future1.thenApply(n -> n * 2).thenAccept(result -> System.out.println("Result: " + result));   // it is not block other threads

        System.out.println("Main thread continues...");
    }
}

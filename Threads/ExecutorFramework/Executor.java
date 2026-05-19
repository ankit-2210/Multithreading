package ExecutorFramework;

// The Executors framework was introduced in Java 5 as part of the java.util.concurrent package
// to simplify the development of concurrent applications by abstracting away many of the complexities
// involved in creating and managing threads

// Why Executor Framework is Used?
// Problems with creating threads manually:
// 1. Thread creation is expensive
// 2. Hard to manage many threads
// 3. No lifecycle management

// Executor framework solves this by:
// 1. ✅ Managing thread pools
// 2. ✅ Scheduling tasks
// 3. ✅ Improving performance
// 4. ✅ Controlling concurrency

// Three core interfaces:
// 1. Executor
// 2. ExecutorService
// 3. ScheduledExecutorService

// The Executor Framework is a framework in java.util.concurrent that helps manage threads efficiently using thread pools.
// Instead of manually creating threads, you submit tasks to an executor, and it manages the threads for you.

public class Executor {
    private static long factorial(int n) throws InterruptedException {
        Thread.sleep(1000);
        long result=1;
        for(int i=1; i<=n; i++){
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[9];
        for(int i=1; i<10; i++){
            int finalI = i;
            threads[i-1] = new Thread(()->{
                try {
                    System.out.println(factorial(finalI));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i-1].start();
        }

        for(Thread thread: threads){
            try {
                thread.join();
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Total time: " + (System.currentTimeMillis()-startTime));

    }
}









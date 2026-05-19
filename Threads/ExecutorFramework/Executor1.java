package ExecutorFramework;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Extended interface that provides task management and lifecycle control.
// Common methods:
// submit()
// shutdown()
// shutdownNow()
// invokeAll()

public class Executor1 {
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
        ExecutorService executorService = Executors.newFixedThreadPool(3);   // 3 executor handles 3 threads at a time
        for(int i=1; i<10; i++){
            int finalI = i;
            Future<?> future = executorService.submit(()->{  // if the methods is return something or want to know the methods is close, use Future.
                try {
                    System.out.println(factorial(finalI));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            if(future.isDone()){    // it will not println as future is not done
                System.out.println("Task is Done!!");
            }
        }
        executorService.shutdown();

        System.out.println("Total time: " + (System.currentTimeMillis()-startTime));

    }
}

package ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.*;


public class Future1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        java.util.concurrent.Future<?> future = executorService.submit(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });

        Thread.sleep(2000);    // sleep 2 sec so the task is not cancel so after that the print will executed.
        future.cancel(true);
        System.out.println(future.isCancelled());

        Integer i=null;
        try{
            i = (Integer) future.get();       // if the future is cancelled, then this will not run and print anything.
            System.out.println(future.isDone());
            System.out.println(i);
        }
        catch (Exception e){

        }
        executorService.shutdown();
    }
}

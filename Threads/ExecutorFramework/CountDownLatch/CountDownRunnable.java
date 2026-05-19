package ExecutorFramework.CountDownLatch;

import java.util.concurrent.*;

public class CountDownRunnable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numOfServices=3;
        CountDownLatch countDownLatch = new CountDownLatch(numOfServices);
        for(int i=0; i<numOfServices; i++){
            new Thread(new DependentServicee(countDownLatch)).start();
        }
        countDownLatch.await();
        System.out.println("All dependent services finished. Starting main services!!");
    }
}

class DependentServicee implements Runnable {
    private final CountDownLatch countDownLatch;
    public DependentServicee(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }

    @Override
    public void run(){
        try {
            System.out.println(Thread.currentThread().getName() + " service started..");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            countDownLatch.countDown();
        }
    }
}
package keyword;


// When a variable is declared as volatile, every thread reads the value directly from main memory instead of its local CPU cache.
// Problem Without volatile:
// Each thread may keep its own cached copy of a variable.
//        Main Memory
//            │
//        ┌───┴────┐
//        Thread A  Thread B
//        (cache)   (cache)
// If Thread A updates the value, Thread B might still see the old cached value.


// Without volatile:
// Thread A → update variable
// Thread B → reads cached value

// With volatile:
// Thread A → update variable
// Thread B → reads updated value from main memory


class SharedObj{
    private volatile boolean flag=false;

    public void setFlagTrue(){
        System.out.println("Writer thread made the flag true !");
        flag=true;
    }

    public void printIfFlagTrue(){
        while(!flag){
            // do nothing
        }
        System.out.println("Flag is true!");
    }
}

public class VolatileKeyword {
    public static void main(String[] args) {
        SharedObj sharedObj = new SharedObj();
        Thread writerThread = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                sharedObj.setFlagTrue();
            }
        });

        Thread readerThread = new Thread(()-> sharedObj.printIfFlagTrue());

        writerThread.start();
        readerThread.start();
    }
}

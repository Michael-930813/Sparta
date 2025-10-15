package chapter3.thread;

public class MultiTaskSum implements Runnable {
// - Variable
    private int start = 0;
    private int end = 0;
    private int sum = 0;

// - Function
    // - Structor
    public MultiTaskSum(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // - Get
    public int  getSum() {
        return this.sum;
    }

    // - Runnable Start
    @Override
    public void run() {
        for(int i = start; i <= end; i++){
            this.sum += i;
            try {
                Thread.sleep(10);
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
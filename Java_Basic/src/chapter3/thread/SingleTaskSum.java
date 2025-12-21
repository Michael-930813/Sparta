package chapter3.thread;

public class SingleTaskSum {
    public long calculateSum( long start, long end ) {
        long sum = 0;

        for(long i = start ; i <= end; i++) {
            // - calculate sum
            sum += i;
            // - Time sleep
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return sum;
    }
}

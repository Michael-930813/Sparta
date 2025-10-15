package chapter3.thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        for( int i = 0 ; i < 10 ; i++ ) {
            System.out.println("Now thread : " + threadName + " - " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
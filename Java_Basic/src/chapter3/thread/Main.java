package chapter3.thread;

public class Main {
    public static void main(String[] args) {
        // - Step1 : Thread
        System.out.println("::: main thread start :::");
        MyThread thread0 = new MyThread();
        MyThread thread1 = new MyThread();

        // - Time record
        long startTime = System.currentTimeMillis();

        // - thread1 start
        System.out.println("::: main run thread0 :::");
        thread0.start();
        // - thread2 start
        System.out.println("::: main run thread1 :::");
        thread1.start();

        // - Wait main thread
        try {
            thread0.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total runtime : " + totalTime + "ms");
        System.out.println("::: main thread end :::");

        // - Step2 : Runnable
        MyRunnable task =  new MyRunnable();

        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread2.start();
        thread3.start();

        try {
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // - Practice
        // - Single Thread
        SingleTaskSum singletask = new SingleTaskSum();

        startTime = System.currentTimeMillis();
        System.out.println("::: single calculate start :::");

        long singlesum = singletask.calculateSum(1, 1000);

        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Total runtime : " + totalTime + "ms");
        System.out.println("Total Sum : " + singlesum);

        System.out.println("::: single calculate end :::");

        // - MultiThread
        MultiTaskSum    multitask0 = new MultiTaskSum(1, 250);
        MultiTaskSum    multitask1 = new MultiTaskSum(251, 500);
        MultiTaskSum    multitask2 = new MultiTaskSum(501, 750);
        MultiTaskSum    multitask3 = new MultiTaskSum(751, 1000);

        Thread multithread0 = new Thread(multitask0);
        Thread multithread1 = new Thread(multitask1);
        Thread multithread2 = new Thread(multitask2);
        Thread multithread3 = new Thread(multitask3);

        startTime = System.currentTimeMillis();
        System.out.println("::: multi calculate start :::");

        multithread0.start();
        multithread1.start();
        multithread2.start();
        multithread3.start();

        try {
            multithread0.join();
            multithread1.join();
            multithread2.join();
            multithread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long multisum = 0;
        multisum += multitask0.getSum();
        multisum += multitask1.getSum();
        multisum += multitask2.getSum();
        multisum += multitask3.getSum();

        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Total runtime : " + totalTime + "ms");
        System.out.println("Total Sum : " + multisum);

        System.out.println("::: multi calculate end :::");
    }
}

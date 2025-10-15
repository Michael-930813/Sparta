package chapter3.lambda;

public class Main {
    // - Step3 ~ Step5
    public static int calculate(int a, int b, Calculator calculator) {
        return calculator.sum(a, b);
    }
    public static void main(String[] args) {
        // - Step1
        Calculator calc1 = new Calculator() {
            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        };

        int sum1 = calc1.sum(11, 21);
        System.out.println(sum1);

        // - Step2
        Calculator calc2 = (a, b) -> a+b;
        int sum2 = calc2.sum(12, 22);
        System.out.println(sum2);

        // - Step3
        int sum3 = calculate(13, 23, calc1);
        System.out.println(sum3);

        // - Step4
        int sum4 = calculate(14, 24, calc2);
        System.out.println(sum4);

        // - Step5
        int sum5 = calculate(15, 25, (a,b) -> a+b);
        System.out.println(sum5);
    }
}
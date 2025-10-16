package level3;

// - Level3 : Enum, Generic, Lambda & Stream을 이해한 계산기 만들기
// - Step1 : Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리하고 이를 사칙연산 계산기 ArithmeticCalculator 클래스에 활용 해봅니다.
// - Step2 : 실수, 즉 double 타입의 값을 전달 받아도 연산이 수행하도록 만들기 - 피연산자를 여러 타입으로 받을 수 있도록 기능을 확장
// - Step3 : 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력

import java.util.Scanner;

public class App {
    private static final long INPUT_MIN = -100_000_000L;
    private static final long INPUT_MAX = 100_000_000L;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArithmeticCalculator<Number> calc = new ArithmeticCalculator<>();

        // - Run Calculator
        System.out.println("=== Calculator On ===");
        while (true) {
            // - Input Formula
            System.out.print("Input FirstNumber(" + INPUT_MIN + " ~ " + INPUT_MAX + ") : ");
            String input0 = input.next();
            if( !isNumeric(input0) ) { outputWrong(); continue; }
            System.out.print("Input SecondNumber(" + INPUT_MIN + " ~ " + INPUT_MAX + ") : ");
            String input1 = input.next();
            if( !isNumeric(input1) ) { outputWrong(); continue; }

            double num0 = Double.parseDouble(input0);
            double num1 = Double.parseDouble(input1);
            if( outOfRange(num0) || outOfRange(num1)) { outputWrong(); continue; }

            System.out.print("Input Operator(+,-,*,/) : ");
            char inputop = input.next().charAt(0);
            Operator op = Operator.fromChar(inputop);
            if( op == null ) { outputWrong(); continue; }

            // - Calculate
            calc.setNum0(num0);
            calc.setNum1(num1);
            calc.setOperator(op);

            double prev = calc.getLastResult();
            if(!calc.Calculate()) { outputWrong(); continue; }
            double now = calc.getLastResult();

            // - Output Result
            System.out.println("Previous Calculate Result : " + formatNumber(prev));
            System.out.println("Current Calculate Result : " + formatNumber(now));

            // - Check Continue
            System.out.println("Continue?(Program OFF Keyword : exit)");
            System.out.print("Input Any Keyword : ");
            String continues = input.next();
            if( continues.equalsIgnoreCase("exit")) break;
        }
        System.out.println("=== Calculator OFF ===");
    }

    // - Utility
    // - Check InputNumber( Long || Double )
    private static boolean isNumeric(String s) {
        if( s == null || s.isEmpty() ) return false;

        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // - Check InputNumber OutOfRange
    private static boolean outOfRange(double num) {
        return (num < (double)INPUT_MIN || num > (double)INPUT_MAX);
    }

    // - Output WrongInput
    private static void outputWrong() {
        System.out.println("Wrong Input. Please try again.");
    }

    // - Output Long from Double
    private static String formatNumber(double num) {
        if( num == Math.floor(num)) {
            return String.valueOf((long)num);
        } else {
            return String.valueOf(num);
        }
    }
}
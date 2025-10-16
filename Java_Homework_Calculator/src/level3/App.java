package level3;

// - Level3 : Enum, Generic, Lambda & Stream을 이해한 계산기 만들기
// - Step1 : Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리하고 이를 사칙연산 계산기 ArithmeticCalculator 클래스에 활용 해봅니다.
// - Step2 : 실수, 즉 double 타입의 값을 전달 받아도 연산이 수행하도록 만들기 - 피연산자를 여러 타입으로 받을 수 있도록 기능을 확장
// - Step3 : 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalcualtor calc = new ArithmeticCalcualtor();
        Scanner input = new Scanner(System.in);
        Integer num0 = 0, num1 = 0;
        Long prevresult = 0L, nowresult = 0L;
        Character inputop = ' ';

        // - Run Calculator
        System.out.println("=== Calculator On ===");
        while (true) {
            // - Input Formula
            System.out.print("Input FirstNumber(0 ~ 1,000,000,000) : ");
            num0 = input.nextInt();
            if (isUnderZero(num0) || isOverMax(num0)) {
                continue;
            }
            System.out.print("Input SecondNumber(0 ~ 1,000,000,000) : ");
            num1 = input.nextInt();
            if (isUnderZero(num1) || isOverMax(num1)) {
                continue;
            }
            System.out.print("Input Operator(+,-,*,/) : ");
            inputop = input.next().charAt(0);
            Operator op = Operator.fromChar(inputop);

            // - Calculate
            calc.setNum0(num0);
            calc.setNum1(num1);
            calc.setOperator(op);

            prevresult = calc.getLastResult();
            if( calc.Calculate() ) {
                nowresult = calc.getLastResult();
            } else {
                outputWrong();
                continue;
            }

            // - Output Result & Check Continue
            System.out.println("이전 계산 결과 : " + prevresult);
            System.out.println("이번 계산 결과 : " + nowresult);
            System.out.println("계속하시겠습니까?(종료 키워드 : exit)");
            System.out.print("글자를 입력하세요 : ");
            String continues = input.next();
            if (continues.equals("exit")) {
                break;
            }
        }

        System.out.println("=== Calculator OFF ===");
    }

    // - Check InputNumber
    private static boolean isUnderZero(long num) {
        if (num < 0) {
            outputWrong();
            return true;
        } else {
            return false;
        }
    }
    private static boolean isOverMax(long num) {
        if (num > (long) 1_000_000_000L) {
            outputWrong();
            return true;
        } else {
            return false;
        }
    }

    // - Output WrongInput
    public static void outputWrong() {
        System.out.println("잘못 입력하셨습니다. 처음부터 다시 입력해주세요.");
    }
}

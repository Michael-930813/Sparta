package level2;

// - Level2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기
// - Step1 : 사칙연산을 수행 후, 결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Clculator 클래스 생성
// - Step2 : Lv1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정
// - Step3 : App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정(캡슐화)
// - Step4 : Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현한 후 App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner input = new Scanner(System.in);
        Integer num0 = 0, num1 = 0;
        Long result = 0L;
        Character operator = ' ';

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
            operator = input.next().charAt(0);

            // - Calculate
            calc.setNum0(num0);
            calc.setNum1(num1);
            calc.setOperator(operator);
            long prev = calc.popFirstResult();
            if( calc.Calculate() ) {
                result = calc.getLastResult();
            }
            else {
                outputWrong();
                continue;
            }

            // - Output Result & Check Continue
            System.out.println("이전 계산 결과 : " + prev);
            System.out.println("이번 계산 결과 : " + result);
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

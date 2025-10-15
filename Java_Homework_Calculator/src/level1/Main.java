package level1;

import java.util.Scanner;

// - Level1 : 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기
// - 0을 포함한 양의 정수 입력 받기
// - 사칙연산 기호를 입력받기
// - 위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기
// - 반복문을 사용하되, 반복의 종료를 알려주는 "exit"문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스를 수정하기

public class Main {
    public static void main(String[] args) {
        long num0 = 0, num1 = 0;
        long sum = 0;
        char symbol = ' ';
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.print("첫번째 숫자를 입력하세요(0 ~ 1억) : ");
            num0 = input.nextLong();
            if(isUnderZero(num0) || isOverMax(num0)) { continue; }
            System.out.print("두번째 숫자를 입력하세요(0 ~ 1억) : ");
            num1 = input.nextLong();
            if(isUnderZero(num1) || isOverMax(num1)) { continue; }
            System.out.print("연산할 기호를 입력하세요(+,-,*,/) : ");
            symbol = input.next().charAt(0);
            switch(symbol) {
                case '+':
                    sum = num0 + num1;
                    break;
                case '-':
                    sum = num0 - num1;
                    break;
                case '*':
                    sum = num0 * num1;
                    break;
                case '/':
                    if( num1 == 0 ) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        outputWrong();
                        continue;
                    }
                    sum = num0 / num1;
                    break;
                default:
                    outputWrong();
                    continue;
            }
            System.out.println("계산 결과 : " + sum);
            System.out.println("계속하시겠습니까?(종료 키워드 : exit)");
            System.out.println("글자를 입력하세요 : ");
            String continues = input.next();
            if(continues.equals("exit")) {
                break;
            }
        }
    }

    static boolean isUnderZero(long num)
    {
        if( num < 0 ) {
            outputWrong();
            return true;
        }
        else {
            return false;
        }
    }
    static boolean isOverMax(long num)
    {
        if( num > (long)1_00_000_000L ) {
            outputWrong();
            return true;
        }
        else {
            return false;
        }
    }

    static void outputWrong()
    {
        System.out.println("잘못 입력하셨습니다. 처음부터 다시 입력해주세요.");
    }
}

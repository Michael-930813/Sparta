package level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
// - Variable

// - Function
    // - Calculate
    public long Calculate(long num0, long num1, char operator) {
        long result = 0;

        switch(operator) {
            case '+':
                result = num0 + num1;
                break;
            case '-':
                result = num0 - num1;
                break;
            case '*':
                result = num0 * num1;
                break;
            case '/':
                if( num1 == 0 ) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    outputWrong();
                    break;
                }
                result = num0 / num1;
                break;
            default:
                break;
        }

        return result;
    }

    // - Output WrongInput
    static void outputWrong()
    {
        System.out.println("잘못 입력하셨습니다. 처음부터 다시 입력해주세요.");
    }
}

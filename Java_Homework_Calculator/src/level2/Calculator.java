package level2;

public class Calculator {
// - Variable
    private Long result;


// - Function
    // - Structor : Initialize
    public Calculator() {
        result = 0L;
    }

    // - Calculate
    public long Calculate(long num0, long num1, char operator) {
        switch(operator) {
            case '+':
                this.result = num0 + num1;
                break;
            case '-':
                this.result = num0 - num1;
                break;
            case '*':
                this.result = num0 * num1;
                break;
            case '/':
                if( num1 == 0 ) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return -1;
                }
                this.result = num0 / num1;
                break;
            default:
                return -1;
        }

        return result;
    }
}

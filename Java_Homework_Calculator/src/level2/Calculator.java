package level2;

import java.util.List;
import java.util.ArrayList;

public class Calculator {
// - Variable
    private Integer num0, num1;
    private Character operator;
    private List<Long> resultlist;


// - Function
    // - Structor : Initialize
    public Calculator() {
        num0 = 0;
        num1 = 0;
        operator = null;
        resultlist = new ArrayList<>();
    }

    // - Get & Set
    public long getLastResult() {
        return resultlist.get(resultlist.size()-1);
    }
    public void setNum0(Integer num0) {
        this.num0 = num0;
    }
    public void setNum1(Integer num1) {
        this.num1 = num1;
    }
    public void setOperator(Character operator) {
        this.operator = operator;
    }

    // - Calculate
    public boolean Calculate() {
        switch(this.operator) {
            case '+':
                resultlist.add((long)(num0 + num1));
                break;
            case '-':
                resultlist.add((long)(num0 - num1));
                break;
            case '*':
                resultlist.add(num0.longValue() * num1.longValue());
                break;
            case '/':
                if( num1 == 0 ) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return false;
                }
                resultlist.add((long)(num0 / num1));
                break;
            default:
                return false;
        }

        return true;
    }
}

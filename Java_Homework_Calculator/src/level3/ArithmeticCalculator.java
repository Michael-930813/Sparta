package level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArithmeticCalculator<T extends Number> {
// - Variable
    private T num0, num1;
    private Operator operator;
    private List<Double> resultlist;


// - Function
    // - Structor : Initialize
    public ArithmeticCalculator() {
        num0 = null;
        num1 = null;
        operator = null;
        resultlist = new ArrayList<>();
    }

    // - Get & Set
    public double getFirstResult() { return getSafeResult(0); }
    public double popFirstResult() { return removeSafeResult(0); }
    public double getLastResult() { return getSafeResult(resultlist.size() - 1); }
    public double popLastResult() { return removeSafeResult(resultlist.size() - 1); }
    public List<Double> getResultlist() { return resultlist; }

    public void setNum0(T num0) { this.num0 = num0; }
    public void setNum1(T num1) {
        this.num1 = num1;
    }
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    // - Calculate
    public boolean Calculate() {
        // - Cast to double
        double x = num0.doubleValue();
        double y = num1.doubleValue();

        // - Calculate
        double result = switch (operator) {
            case PLUS -> x + y;
            case MINUS -> x - y;
            case MULTYPLE ->  x * y;
            case DIVIDE ->  {
                if( y == 0 ) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    yield Double.NaN;
                }
                yield x / y;
            }
        };

        // - Nan is false
        if(Double.isNaN(result)) return false;
        // - Add Resultlist
        resultlist.add(result);
        return true;
    }

    // - get & remove SafeValue in ResultList
    private double getSafeResult(int index) {
        return Optional.ofNullable(resultlist)
                .filter(list -> index >= 0 && index < list.size())
                .map(list -> list.get(index))
                .orElse(0.0);
    }
    private double removeSafeResult(int index) {
        return Optional.ofNullable(resultlist)
                .filter( list -> index >= 0 && index < list.size())
                .map( list -> list.remove(index))
                .orElse(0.0);
    }
}

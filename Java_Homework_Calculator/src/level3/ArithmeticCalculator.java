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
        double result = 0;

        // - Calculate
        switch(this.operator) {
            case PLUS :
                result = x + y;
                break;
            case MINUS :
                result = x - y;
                break;
            case MULTYPLE :
                result = x * y;
                break;
            case DIVIDE :
                if( y == 0 ) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return false;
                }
                result = x / y;
                break;
            default:
                return false;
        }

        // - Add Resultlist
        resultlist.add(result);

        return true;
    }

    // - get & remove SafeValue in ResultList
    private double getSafeResult(int index) {
        // - Check List is null
        Optional<List<Double>> optionallist = Optional.ofNullable(resultlist);
        if( !optionallist.isPresent() ) { return 0L; }
        // - Check index is normal
        List<Double> safelist = optionallist.get();
        if( index < 0 || index >= safelist.size() ) { return 0L; }
        // - Check Value in List[index]
        Double value = safelist.get(index);
        return (value != null) ? value : 0.0;
    }
    private double removeSafeResult(int index) {
        // - Check List is null
        Optional<List<Double>> optionallist = Optional.ofNullable(resultlist);
        if( !optionallist.isPresent() ) { return 0L; }
        // - Check index is normal
        List<Double> safelist = optionallist.get();
        if( index < 0 || index >= safelist.size() ) { return 0L; }
        // - Check Value in List[index]
        Double value = safelist.remove(index);
        return (value != null) ? value : 0.0;
    }
}

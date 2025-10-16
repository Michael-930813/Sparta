package level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class ArithmeticCalcualtor {
// - Variable
    private Integer num0, num1;
    private Operator operator;
    private List<Long> resultlist;


// - Function
    // - Structor : Initialize
    public ArithmeticCalcualtor() {
        num0 = 0;
        num1 = 0;
        operator = null;
        resultlist = new ArrayList<>();
    }

    // - Get & Set
    public long getFirstResult() { return getSafeResult(0); }
    public long popFirstResult() { return removeSafeResult(0); }
    public long getLastResult() { return getSafeResult(resultlist.size() - 1); }
    public long popLastResult() { return removeSafeResult(resultlist.size() - 1); }

    public void setNum0(Integer num0) { this.num0 = num0; }
    public void setNum1(Integer num1) {
        this.num1 = num1;
    }
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    // - Calculate
    public boolean Calculate() {
        switch(this.operator) {
            case PLUS :
                resultlist.add((long)(num0 + num1));
                break;
            case MINUS :
                resultlist.add((long)(num0 - num1));
                break;
            case MULTYPLE :
                resultlist.add(num0.longValue() * num1.longValue());
                break;
            case DIVIDE :
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

    // - get & remove SafeValue in ResultList
    private long getSafeResult(int index) {
        // - Check List is null
        Optional<List<Long>> optionallist = Optional.ofNullable(resultlist);
        if( !optionallist.isPresent() ) { return 0L; }
        // - Check index is normal
        List<Long> safelist = optionallist.get();
        if( index < 0 || index >= safelist.size() ) { return 0L; }
        // - Check Value in List[index]
        Long value = safelist.get(index);
        return (value != null) ? value : 0L;
    }
    private long removeSafeResult(int index) {
        // - Check List is null
        Optional<List<Long>> optionallist = Optional.ofNullable(resultlist);
        if( !optionallist.isPresent() ) { return 0L; }
        // - Check index is normal
        List<Long> safelist = optionallist.get();
        if( index < 0 || index >= safelist.size() ) { return 0L; }
        // - Check Value in List[index]
        Long value = safelist.remove(index);
        return (value != null) ? value : 0L;
    }
}

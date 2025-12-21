package chapter2;

public class WrapperClass {
    public static void main(String[] args) {
        Integer integer = 300;

        System.out.println(integer);

        CustomDouble customduoble = new CustomDouble(integer);
        System.out.println(customduoble.ToString());
    }
}

// - Custom WrapperClass
class CustomDouble {
    // - Var
    double value;

    // - Method
    CustomDouble(double value) {
        this.value = value;
    }

    public String ToString() {
        return String.valueOf(value);
    }
}
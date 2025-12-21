package chapter2;

public class StaticKeyword {

    public static void main(String[] args) {
        CustomInteger customint1 = new CustomInteger();
        CustomInteger customint2 = new CustomInteger();

        customint1.normal_int = 10;
        customint1.static_int = 20;
        customint2.normal_int = 30;
        customint2.static_int = 40;

        System.out.println(customint1.normal_int);
        System.out.println(customint1.static_int);
        System.out.println(customint2.normal_int);
        System.out.println(customint2.static_int);
    }
}

class CustomInteger
{
    public static int static_int = 0;
    int normal_int = 0;
}

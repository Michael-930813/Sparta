package Chapter2;

public class FinalKeyword
{
    static final short MAX_SHORT = (short)32767;

    public static void main(String[] args)
    {
        int temp = MAX_SHORT;

        System.out.println("MAX SHORT is " + MAX_SHORT);
        // - MAX_SHORT = 300; <- THis is Error, Not change
    }
}
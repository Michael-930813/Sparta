package chapter3.generic;

public class Main {
    public static void main(String[] args) {
        GenericBax<String> strGBox = new GenericBax<>("Temp");
        GenericBax<Integer> intGBox = new GenericBax<>(10);

        strGBox.printItem();
        strGBox.printBoxItem(3.141592);
        strGBox.printBoxItem(intGBox.getItem());
    }
}
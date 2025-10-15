package chapter1;

public class Calculate {
    void MultipleTable() {
        for (int i = 2; i <= 9; i++) {
            System.out.println("=== " + i + "단 ===");
            for (int j = 1; j < 9; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));
            }
        }
    }
}

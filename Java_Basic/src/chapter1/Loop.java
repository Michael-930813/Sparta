package chapter1;

import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("출력할 구구단 단수(2~19) : ");
        int multiple = sc.nextInt();

        // - for
        System.out.println("===== " + multiple + "단 =====");
        for (int i = 2; i <= 19; i++) {
            System.out.println(i + " x " + multiple + " = " + (multiple * i));
        }

        // - while, do while
        int i = 1, j = 1;
        while (j++ < 9) {
            System.out.println("===== " + j + "단 =====");
            do {
                System.out.println(i + " x " + j + " = " + (i * j));
            } while (i++ < 9);
            i = 1;
        }
    }
}

package level1;

import java.util.Scanner;

public class Main {
    // - Main
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int input_case = 1;

        while(input_case != 0) {
            OutputMenu();
            System.out.print(">");
            input_case = input.nextInt();

            switch(input_case) {
                case 1 :
                    System.out.println("1. ShackBurger  | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                    break;
                case 2 :
                    System.out.println("2. SmokeShack   | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                    break;
                case 3 :
                    System.out.println("3. CheeseBurger | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                    break;
                case 4 :
                    System.out.println("4. HamBurger    | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
                    break;
                case 0 :
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default :
                    System.out.println("Wrong input");
            }
        }
    }

// - Function
    static void OutputMenu() {
        System.out.println("[SHAKESHAKE MENU]");
        System.out.println("1. ShackBurger  | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        System.out.println("2. SmokeShack   | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        System.out.println("3. CheeseBurger | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        System.out.println("4. HamBurger    | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
        System.out.println("0. Exit         | 종료");
    }
}
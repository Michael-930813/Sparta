package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // - Main
    public static void main(String[] args) {
        List<MenuItem> items = new ArrayList<MenuItem>();
        items.add( new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        items.add(new MenuItem("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        items.add(new MenuItem("CheeseBurger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        items.add(new MenuItem("HamBurger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거") );

        Scanner input = new Scanner(System.in);
        int input_case = 1;

        while(input_case != 0) {
            System.out.println("[SHAKESHAKE MENU]");
            for( int i = 1 ; i <= items.size() ; i++ ) {
                System.out.print(i + ". ");
                OutputMenuItem(items.get(i-1));
            }
            System.out.println("0. Exit          | 종료");
            System.out.print(">");
            input_case = input.nextInt();

            switch(input_case) {
                case 1 :
                    OutputMenuItem(items.get(input_case-1));
                    break;
                case 2 :
                    OutputMenuItem(items.get(input_case-1));
                    break;
                case 3 :
                    OutputMenuItem(items.get(input_case-1));
                    break;
                case 4 :
                    OutputMenuItem(items.get(input_case-1));
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
    static void OutputMenuItem( MenuItem item ) {
        System.out.println( item.name + "\t | W " + item.price + " | " + item.description);
    }
}
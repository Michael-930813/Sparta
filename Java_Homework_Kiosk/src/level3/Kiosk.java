package level3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {
// - Variable
    List<MenuItem> menuItems = new ArrayList<MenuItem>();
    Scanner input = new Scanner(System.in);
    int inputMenu = 1;


// - Function
    // - Structor
    Kiosk(List<MenuItem> burgerList) {
        this.menuItems = burgerList;
    }

    // - Kiosk Start
    public void start() {
        while (inputMenu != 0) {
            // - Output Menu
            System.out.println("[SHAKESHAKE MENU]");
            for (int i = 1; i <= menuItems.size(); i++) {
                System.out.print(i + ". ");
                OutputMenuItem(menuItems.get(i - 1));
            }
            System.out.println("0. Exit          | 종료");
            // - Input Menu
            while (true) {
                System.out.print(">");
                try {
                    inputMenu = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Wrong input");
                    input.nextLine();
                }
            }
            // - Output Enter Menu
            switch (inputMenu) {
                case 1:
                    OutputMenuItem(menuItems.get(inputMenu - 1));
                    break;
                case 2:
                    OutputMenuItem(menuItems.get(inputMenu - 1));
                    break;
                case 3:
                    OutputMenuItem(menuItems.get(inputMenu - 1));
                    break;
                case 4:
                    OutputMenuItem(menuItems.get(inputMenu - 1));
                    break;
                case 0:
                    System.out.println("Exit Kiosk.");
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }

    void OutputMenuItem(MenuItem item) {
        System.out.println(item.name + "\t | W " + item.price + " | " + item.description);
    }
}
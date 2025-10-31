package level4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    // - Property
    List<Menu> menuList = new ArrayList<Menu>();
    Scanner input = new Scanner(System.in);
    int mainindex = 1, menuindex = 0;


    // - Method
    // - Structor
    Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    // - Kiosk Start
    public void start() {
        System.out.println("Kiosk Start.");
        while (true) {
            // - Output MenuList
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menuList.size(); i++) {
                System.out.print(i + 1 + ". ");
                menuList.get(i).outputMenu();
            }
            System.out.println("0. Exit");
            // - Input MenuList
            mainindex = getValidatedInt(input, ">");
            if (mainindex == 0) {
                System.out.println("Kiosk End.");
                break;
            } else if (mainindex > menuList.size()) {
                mainindex = 0;
            }

            menuloop:
            while (true) {
                // - Output Entered MenuList
                if (mainindex < menuList.size()) {
                    switch (mainindex) {
                        case 1:
                            System.out.println("[ BURGERS MENU ]");
                            outputMenuList(menuList.get(mainindex - 1));
                            break;
                        case 2:
                            System.out.println("[ DRINKS MENU ]");
                            outputMenuList(menuList.get(mainindex - 1));
                            break;
                        case 3:
                            System.out.println("[ DESSERTS MENU ]");
                            outputMenuList(menuList.get(mainindex - 1));
                            break;
                        case 0:
                            break menuloop;
                    }
                } else {
                    System.out.println("Wrong input.");
                }

                // - Input Menu
                menuindex = getValidatedInt(input, ">");
                // - Output Menu
                if (menuindex < menuList.get(mainindex - 1).menuItems.size()) {
                    switch (menuindex) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            menuList.get(mainindex - 1).menuItems.get(menuindex -1).outputMenuitem();
                            break;
                        case 0:
                            mainindex = 0;
                            break;
                        default:
                            break;
                    }
                } else {
                    System.out.println("Wrong input.");
                }
            }
        }
    }

    static int getValidatedInt(Scanner sc, String message) {
        int value = 0;
        while (true) {
            System.out.print(message);
            try {
                value = sc.nextInt();
                sc.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
                value = 0;
                sc.nextLine();
            }
        }
    }

    static void outputMenuList(Menu menu) {
        menu.outputMenuList();
        System.out.println("0. Return.");
    }
}
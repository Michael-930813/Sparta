package challenge1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
// - Property
    private List<Menu> menuList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private int mainindex = 1, menuindex = 0, orderindex = 0;
    private List<MenuItem> cart = new ArrayList<>();


// - Method
    // - Structor
    Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    // - Kiosk Start
    public void start() {
        System.out.println("Kiosk Start.");
        // - Main Loop
        while (true) {
            // - Output MAIN MENU
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menuList.size(); i++) {
                System.out.print(i + 1 + ". ");
                menuList.get(i).outputMenu();
            }
            System.out.println("0. Exit");
            // - Output ORDER MENU
            if (!cart.isEmpty()) {
                System.out.println("\n[ ORDER MENU ]");
                System.out.println("4. Orders\t\t| 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel\t\t| 진행중인 주문을 취소합니다.");
                // - Input MAINMENU
                mainindex = validatedInputInt(input, ">", 0, 5);
            } else {
                mainindex = validatedInputInt(input, ">", 0, 3);
            }
            if (mainindex == 0) {
                System.out.println("Kiosk End.");
                break;
            } else if (mainindex > menuList.size() + 2) {
                mainindex = 0;
            }

            // - Menu Loop
            menuloop:
            while (mainindex <= menuList.size()) {
                // - Output Entered MenuList
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
                // - Input Menu
                menuindex = validatedInputInt(input, ">", 0, 4);
                // - Output Menu
                switch (menuindex) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        MenuItem item = new MenuItem(menuList.get(mainindex - 1).getMenuItems().get(menuindex - 1));
                        item.outputMenuitem();
                        // - Cart Input
                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.println("1. 확인 \t 2. 취소ㅓ");
                        menuindex = validatedInputInt(input, ">", 1, 2);
                        if (menuindex == 1) {
                            cart.add(item);
                        } else { menuindex = 0; }
                        break;
                    case 0:
                        mainindex = 0;
                        break;
                    default:
                        break;
                }
            }
            // - Order Loop
            if(mainindex > menuList.size()) {
                switch (mainindex) {
                    case 4:
                        // - Output Order
                        System.out.println("아래와 같이 주문 하시겠습니까? \n");
                        System.out.println("[ Orders ]");
                        for (MenuItem item : cart) {
                            item.outputMenuitem();
                        }
                        System.out.println("\n[Total]");
                        float sum = 0.0f;
                        for (MenuItem item : cart) {
                            sum += item.getPrice();
                        }
                        System.out.println("W " + sum + "\n");
                        System.out.println("1. 주문 \t 2. 메뉴판");
                        // - Input Order
                        orderindex =  validatedInputInt(input, ">", 1, 2);
                        switch (orderindex) {
                            case 1:
                                System.out.println("주문이 완료되었습니다. 금액은 W " + sum + "입니다.");
                            case 2:
                                break;
                        }
                        break;
                    case 5:
                        System.out.println("장바구니가 비워졌습니다.");
                        cart.clear();
                        break;
                }
            }
        }
    }

    // - GetValidatedInt
    static int validatedInputInt(Scanner sc, String message, int min, int max) {
        int value = 0;
        while (true) {
            System.out.print(message);
            try {
                value = sc.nextInt();
                if( value < min || value > max ) {
                    System.out.println("Wrong input");
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
                sc.nextLine();
            }
        }
    }
    // - OutputMenuList
    static void outputMenuList(Menu menu) {
        menu.outputMenuList();
        System.out.println("0. Return.");
    }
}
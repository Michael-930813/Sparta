package challenge2;

import java.util.*;
import java.util.stream.Collectors;

public class Kiosk {
// - Property
    private List<Menu> menuList;
    private Scanner sc = new Scanner(System.in);
    private List<MenuItem> cart = new ArrayList<>();


// - Method
    // - Structor
    Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    // - Kiosk Start
    public void start() {
        System.out.println("Kiosk Start.");

        while (true) {
            // - Print MainMenu
            printMainMenu();
            // - Input MainMenu
            int input = validatedInputInt(">", 0, cart.isEmpty() ? 3 : 5);
            // - If End Kiosk
            if (input == 0) {
                System.out.println("Kiosk End");
                break;
            }

            // -
            if (input >= 1 && input <= menuList.size()) {
                handleMenu(input);
            } else if (input == 4 && !cart.isEmpty()) {
                handleOrder();
            } else if (input == 5 && !cart.isEmpty()) {
                System.out.println("장바구니가 비워졌습니다.");
                cart.clear();
            } else {
                System.out.println("Wrong input!");
            }
        }
    }

    // - Print MainMenu
    private void printMainMenu() {
        System.out.println("\n[ MAIN MENU ]");
        for (int i = 0; i < menuList.size(); i++)
            System.out.println((i + 1) + ". " + menuList.get(i).getName());
        System.out.println("0. 종료\t | 종료");

        if (!cart.isEmpty()) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.println("4. Orders\t | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel\t | 진행중인 주문을 취소합니다.");
        }
    }

    // - Handle Menu
    private void handleMenu(int mainIndex) {
        Menu selectedMenu = menuList.get(mainIndex - 1);
        System.out.println("\n[ " + selectedMenu.getName().toUpperCase() + " MENU ]");
        selectedMenu.printMenu();

        int choice = validatedInputInt(">", 0, selectedMenu.getItems().size());
        if (choice == 0) return;

        MenuItem item = new MenuItem(selectedMenu.getItems().get(choice - 1));
        System.out.print("선택한 메뉴: ");
        item.printItem();

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인\t 2. 취소");
        int confirm = validatedInputInt(">", 1, 2);

        if (confirm == 1) {
            cart.add(item);
            System.out.println(item.getName() + " 이(가) 장바구니에 추가되었습니다.");
        }
    }

    // - Handle Order
    private void handleOrder() {
        System.out.println("\n아래와 같이 주문 하시겠습니까?\n");
        System.out.println("[ Orders ]");
        cart.forEach(MenuItem::printItem);

        float total = (float) cart.stream().mapToDouble(MenuItem::getPrice).sum();
        System.out.println("\n[ Total ]");
        System.out.printf("W %.1f%n%n", total);

        System.out.println("1. 주문\t 2. 메뉴판");
        int choice = validatedInputInt(">", 1, 2);

        if (choice == 1) {
            applyDiscountAndCheckout(total);
        }
    }

    // - Apply DiscountAndCheckout
    private void applyDiscountAndCheckout(float total) {
        System.out.println("\n할인 정보를 입력해주세요.");
        System.out.println("1. 국가유공자 : 10%");
        System.out.println("2. 군인\t : 5%");
        System.out.println("3. 학생\t : 3%");
        System.out.println("4. 일반\t : 0%");
        int type = validatedInputInt(">", 1, 4);

        DiscountType discount = DiscountType.fromInt(type);
        float discountAmount = total * discount.getRate();
        float finalTotal = total - discountAmount;

        System.out.printf("%n주문이 완료되었습니다. 금액은 W %.1f 입니다.%n", finalTotal);
        cart.clear();
    }

    // - GetValidatedInt
    private int validatedInputInt(String msg, int min, int max) {
        while(true) {
            System.out.println(msg);
            try {
                int val = sc.nextInt();
                if (val < min || val > max) {
                    System.out.println("Wrong input");
                    continue;
                }
                return val;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
                sc.nextLine();
            }
        }
    }
}
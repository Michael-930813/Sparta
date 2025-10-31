package level5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // - Main
    public static void main(String[] args) {
        List<Menu> menuList = new ArrayList<>();
        List<MenuItem> menuItemList;

        // - Add Burger List
        menuItemList = new ArrayList<>();
        menuItemList.add( new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("CheeseBurger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("HamBurger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거") );
        menuList.add(new Menu("Burgers", menuItemList));
        // - Add Drink List
        menuItemList = new ArrayList<>();
        menuItemList.add(new MenuItem("Coke", 1.5f, "펩시 제로") );
        menuItemList.add(new MenuItem("Sprite", 1.5f, "스프라이트 제로") );
        menuItemList.add(new MenuItem("OrangeJuice", 1.0f, "오렌지 주스") );
        menuList.add(new Menu("Drinks", menuItemList));
        //- Add Dessert List
        menuItemList = new ArrayList<>();
        menuList.add(new Menu("Dessrts", menuItemList));

        // - New Kiosk, Start()
        Kiosk kiosk = new Kiosk(menuList);
        kiosk.start();
    }
}
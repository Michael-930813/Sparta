package challenge2;

import java.util.List;

public class Main {
    // - Main
    public static void main(String[] args) {
        List<Menu> menuList = List.of(
                new Menu("Burgers", List.of(
                        new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                        new MenuItem("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                        new MenuItem("Cheeseburger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                        new MenuItem("Hamburger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거")
                )),
                new Menu("Drinks", List.of(
                        new MenuItem("Coke", 1.5f, "펩시 제로"),
                        new MenuItem("Sprite", 1.5f, "스프라이트 제로"),
                        new MenuItem("OrangeJuice", 1.0f, "오렌지 주스")
                )),
                new Menu("Desserts", List.of())
        );

        Kiosk kiosk = new Kiosk(menuList);
        kiosk.start();
    }
}
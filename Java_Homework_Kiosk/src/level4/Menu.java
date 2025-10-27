package level4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
// - Variable
    String name = "";
    List<MenuItem> menuItems = new ArrayList<>();


// - Function
    // - Structor
    public Menu(String name, List<MenuItem> menuItems) {
        this.name = name;
        if (menuItems.isEmpty()) return;
        this.menuItems = menuItems;
    }

    // - OutputMenu
    public void outputMenu() {
        System.out.println(name);
    }
    public void outputMenuList() {
        if(menuItems.isEmpty()) {
            System.out.println("There is no menu item!");
            return;
        }
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.print(i+1 + ". ");
            menuItems.get(i).outputMenuitem();
        }
    }
}

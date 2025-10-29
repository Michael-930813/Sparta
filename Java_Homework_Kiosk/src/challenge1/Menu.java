package challenge1;

import java.util.ArrayList;
import java.util.List;

public class Menu {
// - Property
    private String name = "";
    private List<MenuItem> menuItems = new ArrayList<>();


// - Method
    // - Structor
    public Menu(String name, List<MenuItem> menuItems) {
        this.name = name;
        if (menuItems.isEmpty()) return;
        this.menuItems = menuItems;
    }
    // - Get
    public List<MenuItem> getMenuItems() {
        return menuItems;
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

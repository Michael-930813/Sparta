package challenge2;

import java.util.List;
import java.util.stream.IntStream;

public class Menu {
// - Property
    private String name = "";
    private List<MenuItem> items;


// - Method
    // - Structor
    public Menu(String name, List<MenuItem> items) {
        this.name = name;
        this.items = items;
    }
    // - Get
    public String getName() { return name; }
    public List<MenuItem> getItems() {
        return items;
    }

    // - OutputMenu
    public void printMenu() {
        if (items.isEmpty()) {
            System.out.println("There is no menu item!");
            return;
        }
        IntStream.range(0, items.size())
                .forEach(i -> {
                    System.out.print((i + 1) + ". ");
                    items.get(i).printItem();
                });
        System.out.println("0. 뒤로가기");
    }
}

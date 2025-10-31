package challenge1;

public class MenuItem {
// - Property
    private String name;
    private float price;
    private String description;


// - Method
    // - Structor
    MenuItem(String name, float price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    MenuItem(MenuItem menuItem) {
        this.name = menuItem.name;
        this.price = menuItem.price;
        this.description = menuItem.description;
    }
    // - Get & Set
    public float getPrice() {
        return price;
    }

    // - OutputMenuItem
    public void outputMenuitem() {
        System.out.println(name + "\t | W " + price + " | " + description);
    }
}
package level5;

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

    // - OutputMenuItem
    public void outputMenuitem() {
        System.out.println(name + "\t | W " + price + " | " + description);
    }
}

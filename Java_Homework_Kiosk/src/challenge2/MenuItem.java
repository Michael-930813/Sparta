package challenge2;

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
    MenuItem(MenuItem item) { this(item.name, item.price, item.description); }
    // - Get & Set
    public String getName() { return name; }
    public float getPrice() { return price; }
    public String getDescription() { return description; }

    // - OutputMenuItem
    public void printItem() {
        System.out.println(name + "\t | W " + price + " | " + description);
    }
}
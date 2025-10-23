package level2;

public class MenuItem {
// - Variable
    String name;
    float price;
    String description;


// - Function
    // - Structor
    MenuItem() {
        name = "";
        price = 0.0f;
        description = "";
    }
    MenuItem(String name, float price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}

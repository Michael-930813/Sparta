package chapter3.collection;

public class Product {
// - Variable
    private String name;
    private int price;


// - Function
    // - Constructor
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // - Get
    public String getName() {
        return this.name;
    }
    public int getPrice() {
        return this.price;
    }

    // - Set
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}

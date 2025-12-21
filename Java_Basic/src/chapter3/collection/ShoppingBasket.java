package chapter3.collection;

import java.util.ArrayList;
import java.util.Optional;

public class ShoppingBasket {
// - Variable
    private ArrayList<Product> list_products;


// - Func
    // - Constructor
    public ShoppingBasket() {
        list_products = new ArrayList<>();
    }

    // - Get
    public ArrayList<Product> getList_products() {
        return list_products;
    }

    // - Add Product
    public void AddProduct(Optional<Product> product) {
        if(product.isPresent()) {
            list_products.add(product.get());
        }
    }
    // - Output List
    public void OutputListProducts()
    {
        System.out.println("=== 현재 장바구니 물품목록 ===");
        for(Product product : list_products)
        {
            System.out.print("물품 : "+ product.getName() + ", ");
            System.out.print("가격 : " + product.getPrice() + "\n");
        }
    }
    // - Subtract Product
    public void SubtractProduct(Optional<Product> product) {
        if(product.isPresent()) {
            list_products.remove(product.get());
        }
    }
    // - Calculate TotalPrice
    public void CalculateTotalPrice()
    {
        int total = 0;

        System.out.println("=== 현재 장바구니 총 가격 ===");
        for(Product product : list_products)
        {
            total += product.getPrice();
        }
        System.out.println(total + "원");
    }
}

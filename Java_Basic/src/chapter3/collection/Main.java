package chapter3.collection;

import java.util.Arrays;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product("양파", 1200),
                new Product("사과", 2700),
                new Product("생선", 4500),
                new Product("두부", 1500)
        };

        ShoppingBasket basket = new ShoppingBasket();

        // - Add Product
        for( Product product : products ) {
            basket.AddProduct(Optional.ofNullable(product));
        }
        // - Output List
        basket.OutputListProducts();
        // - Subtract Product
        basket.SubtractProduct(Optional.ofNullable(products[0]));
        basket.SubtractProduct(Optional.ofNullable(products[0]));
        // - Calculate TotalPrice
        basket.OutputListProducts();
        basket.CalculateTotalPrice();
    }
}

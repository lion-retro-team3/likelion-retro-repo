package product;

import product.domain.Alcohol;
import product.domain.Beverage;
import product.domain.Product;
import product.domain.Snack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public class ProductFactory {

    public static Product createProduct(long id, String name, int price, int stockQuantity, String category) {

        switch (category) {
            case "alcohol":
                return new Alcohol(id, name, price, stockQuantity);
            case "beverage":
                return new Beverage(id, name, price, stockQuantity);
            case "snack":
                return new Snack(id, name, price, stockQuantity);
            default:
                return null;
        }

    }

    public static Product createProduct(String name, int price, int stockQuantity, String category) {

        switch (category) {
            case "alcohol":
                return new Alcohol(name, price, stockQuantity);
            case "beverage":
                return new Beverage(name, price, stockQuantity);
            case "snack":
                return new Snack(name, price, stockQuantity);
            default:
                return null;
        }

    }
}

package product;

import product.domain.Alcohol;
import product.domain.Beverage;
import product.domain.Product;
import product.domain.Snack;


public class ProductFactory {

    //from db
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

    //from controller
    public static Product createProduct(String name, int price, int stockQuantity, String category) {

        if (price <= 0 || stockQuantity <= 0) {
            return null;
        }

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

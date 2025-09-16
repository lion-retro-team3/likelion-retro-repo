package product;

import product.domain.Alcohol;
import product.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public class ProductFactory {

    private static final Map<String , Supplier<Product>> PRODUCT_MAP = new HashMap<>();

    static {
        PRODUCT_MAP.put("ALCOHOL", () -> new Alcohol())
    }

    public static Product createProduct(String type){

    }
}

package product;

import product.Product;
import repository.ProductRepo;

import java.util.*;

public class ProductService {

    private static final ProductService INSTANCE = new ProductService();

    public static ProductService getInstance()
    {
        return INSTANCE;
    }
    private Map<Long, Product> productMap; //물건 리스트

    private ProductService() {
        this.productMap = new HashMap<>();
        System.out.println("just one thing");
        this.createInit();

    }



    public Optional<Product> findByCode(Long code) {

        Product product = productMap.get(code);
        return Optional.ofNullable(productMap.get(code));
    }

    public List<Product> getAllSortedByCode() {
        List<Product> values = productMap.values().stream().sorted(Comparator.comparing(Product::getCode)).toList();
        return values;
    }

    public List<Product> getAllSortedByPrice() {
        List<Product> values = productMap.values().stream().sorted(Comparator.comparing(Product::getPrice)).toList();
        return values;
    }

    public List<Product> getAllSortedByStockQuantity() {
        List<Product> values = productMap.values().stream().sorted(Comparator.comparing(Product::getStockQuantity)).toList();
        return values;
    }

    public void createInit() {
        ProductRepo.initTestProduct(this.productMap);
    }
}

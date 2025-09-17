package product;

import product.domain.Product;
import product.dto.ProductDTO;
import product.repository.ProductRepository;

import java.util.*;

public class ProductService {

    private static final ProductService INSTANCE = new ProductService(ProductRepository.getInstance());

    public static ProductService getInstance()
    {
        return INSTANCE;
    }

    private final ProductRepository productRepository;

    private ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    public Product findById(Long id) {

        Product product = productRepository.findById(id);
        if (product == null) return null;
        return product;
    }

    public List<Product> getAllSortedById() {
        List<Product> productList = productRepository.findProductList();
        productList.sort(Comparator.comparing(Product::getId));

        return productList;
    }

    public List<Product> getAllSortedByPrice() {

        List<Product> productList = productRepository.findProductList();
        productList.sort(Comparator.comparing(Product::getPrice));


        return productList;
    }

    public List<Product> getAllSortedByStockQuantity() {

        List<Product> productList = productRepository.findProductList();
        productList.sort(Comparator.comparing(Product::getStockQuantity));
        return productList;
    }


}

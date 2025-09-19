package product;

import product.domain.Product;
import product.dto.ProductDTO;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStockQuantity(),
                product.getCategory());

        return productDTO;
    }

    public static Product toEntity(ProductDTO productDTO) {
        Product product = ProductFactory.createProduct(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getStockQuantity(),
                productDTO.getCategory());

        return product;
    }
}

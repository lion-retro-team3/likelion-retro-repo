package product.dto;

public class ProductDTO {

    private final Long id;
    private final String name;
    private final int price;
    private final int stockQuantity;
    private final String category;

    public ProductDTO(Long id, String name, int price, int stockQuantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }
}

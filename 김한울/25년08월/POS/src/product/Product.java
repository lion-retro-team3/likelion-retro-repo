package product;

public abstract class Product {

    private final Long code;
    private String name;
    private Long price;
    private int stockQuantity;
    private boolean hasPromotion;

    public Product(Long code, String name, Long price, int stockQuantity, boolean hasPromotion) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.hasPromotion = hasPromotion;
    }

    public Product(Long code, String name, Long price, int stockQuantity) {
        this(code, name, price, stockQuantity, false);
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public boolean isHasPromotion() {
        return hasPromotion;
    }

    public void setHasPromotion(boolean hasPromotion) {
        this.hasPromotion = hasPromotion;
    }
}

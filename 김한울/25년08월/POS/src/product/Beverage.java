package product;

public class Beverage extends Product{
    public Beverage(Long code, String name, Long price, int stockQuantity, boolean hasPromotion) {
        super(code, name, price, stockQuantity, hasPromotion);
    }

    public Beverage(Long code, String name, Long price, int stockQuantity) {
        super(code, name, price, stockQuantity);
    }
}

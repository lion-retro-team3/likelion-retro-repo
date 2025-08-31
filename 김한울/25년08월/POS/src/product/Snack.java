package product;

public class Snack extends Product{
    public Snack(Long code, String name, Long price, int stockQuantity, boolean hasPromotion) {
        super(code, name, price, stockQuantity, hasPromotion);
    }

    public Snack(Long code, String name, Long price, int stockQuantity) {
        super(code, name, price, stockQuantity);
    }
}

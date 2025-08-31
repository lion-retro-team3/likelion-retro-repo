package product;

public class Cigarette extends Product{
    public Cigarette(Long code, String name, Long price, int stockQuantity, boolean hasPromotion) {
        super(code, name, price, stockQuantity, hasPromotion);
    }

    public Cigarette(Long code, String name, Long price, int stockQuantity) {
        super(code, name, price, stockQuantity);
    }
}

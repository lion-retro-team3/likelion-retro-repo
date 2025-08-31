package product;

public class Food extends Product{
    public Food(Long code, String name, Long price, int stockQuantity, boolean hasPromotion) {
        super(code, name, price, stockQuantity, hasPromotion);
    }

    public Food(Long code, String name, Long price, int stockQuantity) {
        super(code, name, price, stockQuantity);
    }
}

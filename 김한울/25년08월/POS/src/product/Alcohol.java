package product;

public class Alcohol extends Product{


    public Alcohol(Long code, String name, Long price, int stockQuantity, boolean hasPromotion) {
        super(code, name, price, stockQuantity, hasPromotion);
    }

    public Alcohol(Long code, String name, Long price, int stockQuantity) {
        super(code, name, price, stockQuantity);
    }
}

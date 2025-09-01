package product;

public class Alcohol extends Product{


    public Alcohol(String name, int price, int stockQuantity, boolean hasPromotion) {
        super(name, price, stockQuantity, hasPromotion);
    }

    public Alcohol(String name, int price, int stockQuantity) {
        super(name, price, stockQuantity);
    }
}

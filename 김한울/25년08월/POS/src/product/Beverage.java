package product;

public class Beverage extends Product{

    public Beverage(String name, int price, int stockQuantity, boolean hasPromotion) {
        super(name, price, stockQuantity, hasPromotion);
    }

    public Beverage(String name, int price, int stockQuantity) {
        super(name, price, stockQuantity);
    }
}

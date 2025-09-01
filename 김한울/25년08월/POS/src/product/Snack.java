package product;

public class Snack extends Product{


    public Snack(String name, int price, int stockQuantity, boolean hasPromotion) {
        super(name, price, stockQuantity, hasPromotion);
    }

    public Snack(String name, int price, int stockQuantity) {
        super(name, price, stockQuantity);
    }
}

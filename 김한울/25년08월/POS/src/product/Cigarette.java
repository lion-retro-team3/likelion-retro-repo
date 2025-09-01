package product;

public class Cigarette extends Product{

    public Cigarette(String name, int price, int stockQuantity, boolean hasPromotion) {
        super(name, price, stockQuantity, hasPromotion);
    }

    public Cigarette(String name, int price, int stockQuantity) {
        super(name, price, stockQuantity);
    }
}

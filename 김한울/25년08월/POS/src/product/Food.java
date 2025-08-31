package product;

public class Food extends Product{

    public Food(String name, int price, int stockQuantity, boolean hasPromotion) {
        super(name, price, stockQuantity, hasPromotion);
    }

    public Food(String name, int price, int stockQuantity) {
        super(name, price, stockQuantity);
    }
}

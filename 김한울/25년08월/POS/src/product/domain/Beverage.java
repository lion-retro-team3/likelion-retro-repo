package product.domain;

public class Beverage extends Product{


    public Beverage(Long id, String name, int price, int stockQuantity) {
        super(id, name, price, stockQuantity);
    }

    public Beverage(String name, int price, int stockQuantity) {
        super(name, price, stockQuantity);
    }
}

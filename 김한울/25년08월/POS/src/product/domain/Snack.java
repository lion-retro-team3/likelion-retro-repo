package product.domain;

public class Snack extends Product{


    public Snack(Long id, String name, int price, int stockQuantity) {
        super(id, name, price, stockQuantity);
    }

    public Snack(String name, int price, int stockQuantity) {
        super(name, price, stockQuantity);
    }
}

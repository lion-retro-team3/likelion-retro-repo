package product.domain;

public class Alcohol extends Product{


    public Alcohol(Long id, String name, int price, int stockQuantity) {
        super(id, name, price, stockQuantity);
    }

    public Alcohol(String name, int price, int stockQuantity) {
        super(name, price, stockQuantity);
    }

}

package product;

import java.util.Objects;

public abstract class Product {

    private final Long code;
    private String name;
    private int price;
    private int stockQuantity;
    private boolean hasPromotion;

    private static Long idSequence =0L;

    //code 는 setter 없음  idSequence 로 자동 할당.
    public Product(String name, int price, int stockQuantity, boolean hasPromotion) {
        this.code = idSequence++;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.hasPromotion = hasPromotion;
    }

    public Product(String name, int price, int stockQuantity) {
        this(name, price, stockQuantity, false);
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public boolean isHasPromotion() {
        return hasPromotion;
    }

    public void setHasPromotion(boolean hasPromotion) {
        this.hasPromotion = hasPromotion;
    }

    @Override
    public String toString() {
        return
                "제품 번호 : " + code +
                "\t제품명 : '" + name + '\'' +
                "\t가격 : " + price +
                "\t재고 수량 : " + stockQuantity +
                "\t행사 : " + hasPromotion +"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(code, product.code) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, price);
    }
}

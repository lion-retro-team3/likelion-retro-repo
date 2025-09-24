package product.domain;

import java.util.Objects;

public abstract class Product {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private String category;

    public Product(Long id, String name, int price, int stockQuantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;

    }

    public Product(String name, int price, int stockQuantity, String category) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }


    public Long getId() {
        return id;
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

    private void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return
                "제품 번호 : " + id +
                "\t제품명 : '" + name + '\'' +
                "\t가격 : " + price +
                "\t재고 수량 : " + stockQuantity + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(id, product.id) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    public boolean decreaseStock(int quantity){
        //음수 불가능.
        if (quantity <  getStockQuantity()){
            int stock = getStockQuantity() - quantity;
            this.setStockQuantity(stock);
            return true;
        }else return false;
    }

}

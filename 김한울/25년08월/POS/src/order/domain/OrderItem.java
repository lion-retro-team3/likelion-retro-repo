package order.domain;

import product.domain.Product;

import java.util.Objects;

public class OrderItem {
    private Long id;
    private Long  orderId;
    private Product product;
    private int orderQuantity;

    public OrderItem(Long id, Long  orderId, int orderQuantity, Product product) {
        this.id = id;
        this.orderId = orderId;
        this.orderQuantity = orderQuantity;
        this.product = product;
    }


    public OrderItem(int orderQuantity, Product product) {
        this.product = product;
        this.orderQuantity = orderQuantity;
    }

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public int getOrderQuantity() {
        return this.orderQuantity;
    }

    private void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getOrderPrice() {
        return product.getPrice() * this.getOrderQuantity();
    }

    @Override
    public String toString() {
        return "상품 코드 : " + product.getId() +
                "\t주문 상품 : " + product.getName() +
                "\t상품 가격 : " + product.getPrice() +
                "\t요청 수량 : " + this.getOrderQuantity() +
                "\t|\t" +
                "\t지불 금액 : " + this.getOrderPrice() + "\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(product, orderItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }


    public void updateOrderQuantity(int qty) {
        this.setOrderQuantity(qty);
    }


}

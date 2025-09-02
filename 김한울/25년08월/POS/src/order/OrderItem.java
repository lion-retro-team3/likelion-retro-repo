package order;

import product.Product;

import java.util.Objects;

public class OrderItem {
    private Product product;
    private int orderQuantity;

    public OrderItem(Product product, int orderQuantity) {
        this.product = product;
        this.orderQuantity = orderQuantity;
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

    public int getOrderPrice(){
        return product.getPrice() * this.getOrderQuantity();
    }

    @Override
    public String toString() {
        return "상품 코드 : " + product.getCode() +
                "\t주문 상품 : " + product.getName() +
                "\t상품 가격 : " +product.getPrice() +
                "\t요청 수량 : " + this.getOrderQuantity() +
                "\t|\t" +
                "\t지불 금액 : " + this.getOrderPrice() +"\n";
                
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

    public boolean  tryAddOrderQuantity(int newOrderQuantity){
        int sumQuantity = this.getOrderQuantity() + newOrderQuantity;
        if (sumQuantity <= 0) return false;
        this.updateOrderQuantity(sumQuantity);
        return true;

    }

    public void updateOrderQuantity(int sum) {
        this.setOrderQuantity(sum);
    }


}

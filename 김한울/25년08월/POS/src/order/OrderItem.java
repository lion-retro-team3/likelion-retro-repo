package order;

import product.Product;

public class OrderItem {
    private Product product;
    private int orderQuantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public String toString() {
        return "상품 코드 : " + product.getCode() +
                "\t주문 상품 : " + product.getName() +
                "\t상품 가격 : " +product.getPrice() +
                "\t요청 수량 : " + this.orderQuantity + "\n";
                
    }
}

package order.dto;

public class OrderItemCreateDTO {

    private final Long productId;
    private final int quantity;
    private final int price;

    public OrderItemCreateDTO(Long productId, int quantity, int price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

}

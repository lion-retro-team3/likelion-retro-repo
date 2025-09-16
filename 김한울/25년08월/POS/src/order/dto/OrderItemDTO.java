package order.dto;

public class OrderItemDTO {
    private final Long id;
    private final Long orderId;
    private final Long productId;
    private final int quantity;
    private final int price;

    public OrderItemDTO(Long id, Long orderId, Long productId, int quantity, int price) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

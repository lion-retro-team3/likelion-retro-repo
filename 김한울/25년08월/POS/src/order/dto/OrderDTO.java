package order.dto;

import util.Status;

public class OrderDTO {
    private final Long id;
    private final Status status;
    private final int totalPrice;

    public OrderDTO(Long id, Status status, int totalPrice) {
        this.id = id;
        this.status = status;
        this.totalPrice = totalPrice;
    }
}

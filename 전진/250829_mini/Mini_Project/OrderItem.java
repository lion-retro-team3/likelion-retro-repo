package Mini_Project;

public class OrderItem {
    private static int ordernumber=1;
    private int orderId;
    private String restaurantName;
    private String menuName;
    private int price;
    private OrderStatus orderStatus;

    public OrderItem(String restaurantName, String menuName, int price) {
        this.restaurantName = restaurantName;
        this.menuName = menuName;
        this.price = price;
        this.orderId=ordernumber++;
        this.orderStatus=OrderStatus.주문_접수;
    }
    public int getPrice() {
        return price;
    }
    public int getOrderId() {
        return orderId;
    }
    public String getRestaurantName() {
        return restaurantName;
    }
    public String getMenuName() {
        return menuName;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String toString() {
        return "주문번호 : "+orderId+"\n음식점 : "+restaurantName + " / " + menuName + " - " + price + "원 [" + orderStatus + "]";
    }

}

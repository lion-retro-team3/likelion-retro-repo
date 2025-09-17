package order.repository;

import order.OrderService;
import order.domain.Order;
import order.domain.OrderItem;
import util.DBUtil;
import util.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private final OrderItemRepository orderItemRepository;
    private static final OrderRepository INSTANCE = new OrderRepositoryImpl(OrderItemRepositoryImpl.getInstance());

    public static OrderRepository getInstance()
    {
        return INSTANCE;
    }

    private OrderRepositoryImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public List<Order> findOrderList() {
        List<Order> orderList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM orders";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                orderList.add(getOrder(resultSet));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeResultSet(connection, preparedStatement, resultSet);
        }
        return orderList;
    }

    @Override
    public Order findById(long id) {
        Order order = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM orders WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                order = getOrder(resultSet);
            }
            return order;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeResultSet(connection, preparedStatement, resultSet);
        }

    }

    @Override
    public boolean insert(Order order) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO orders(status, total_price) VALUES(?,?)";
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, order.getStatus().toString());
            preparedStatement.setDouble(2, order.getTotalPrice());
            return preparedStatement.executeUpdate() == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Order order) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "Update orders set status = ?, total_price = ? where id = ?";
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, order.getStatus().toString());
            preparedStatement.setDouble(2, order.getTotalPrice());
            preparedStatement.setLong(3, order.getId());
            return preparedStatement.executeUpdate() == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM orders WHERE id = ?";
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private Order getOrder(ResultSet resultSet) throws SQLException {
        Order order = null;
        long orderId = resultSet.getLong("id");
        String orderStatus = resultSet.getString("status");
        int orderTotalPrice = resultSet.getInt("total_price");
        List<OrderItem> orderItemList = orderItemRepository.findByOrderId(orderId);


        Status status = Status.fromString(orderStatus);
        order = new Order(orderId, orderItemList, status, orderTotalPrice);

        return order;
    }

}

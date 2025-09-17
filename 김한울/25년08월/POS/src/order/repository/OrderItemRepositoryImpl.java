package order.repository;

import order.OrderService;
import order.domain.OrderItem;
import product.domain.Product;
import product.repository.ProductRepository;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemRepositoryImpl implements OrderItemRepository {

    private static final OrderItemRepository INSTANCE = new OrderItemRepositoryImpl(ProductRepository.getInstance());
    private final ProductRepository productRepository;

    public static OrderItemRepository getInstance()
    {
        return INSTANCE;
    }

    private OrderItemRepositoryImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<OrderItem> findOrderItemList() {
        List<OrderItem> orderItemList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM order_items";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                orderItemList.add(getOrderItem(resultSet));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeResultSet(connection, preparedStatement, resultSet);
        }
        return orderItemList;
    }

    @Override
    public OrderItem findById(long id) {
        OrderItem orderItem = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM order_items WHERE id = ?";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                orderItem = getOrderItem(resultSet);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeResultSet(connection, preparedStatement, resultSet);
        }

        return orderItem;
    }

    @Override
    public List<OrderItem> findByOrderId(long orderId) {
        List<OrderItem> orderItemList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM order_items WHERE order_id = ?";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, orderId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderItemList.add(getOrderItem(resultSet));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeResultSet(connection, preparedStatement, resultSet);
        }

        return orderItemList;
    }

    @Override
    public boolean insert(OrderItem orderItem) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO order_items(order_id, product_id, quantity) VALUES(?,?,?)";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, orderItem.getOrderId());
            preparedStatement.setLong(2, orderItem.getProduct().getId());
            preparedStatement.setInt(3, orderItem.getOrderQuantity());
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeStatement(connection, preparedStatement);
        }
    }

    @Override
    public boolean update(OrderItem orderItem) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE order_items SET quantity = ? WHERE id = ?";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderItem.getOrderQuantity());
            preparedStatement.setLong(2, orderItem.getId());
            return preparedStatement.executeUpdate() == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeStatement(connection, preparedStatement);
        }
    }

    @Override
    public boolean delete(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM order_items WHERE id = ?";
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeStatement(connection, preparedStatement);
        }
    }

    private OrderItem getOrderItem(ResultSet resultSet) throws SQLException {
        OrderItem orderItem = null;

        long id = resultSet.getLong("id");
        long orderId = resultSet.getLong("order_id");
        long productId = resultSet.getLong("product_id");
        Product byId = productRepository.findById(productId);
        int orderQuantity = resultSet.getInt("quantity");


        orderItem = new OrderItem(id,orderId, orderQuantity, byId);
        return orderItem;
    }

}

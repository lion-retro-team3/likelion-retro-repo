package product.repository;

import product.ProductFactory;
import product.domain.Product;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public List<Product> findProductList() {

        List<Product> productList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM pruductsqqqq";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                productList.add(getProduct(resultSet));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeResultSet(connection, preparedStatement, resultSet);
        }
        return productList;
    }

    public Product findById(Long id) {
        Product product = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM pruducts WHERE id = ?";
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = getProduct(resultSet);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeResultSet(connection, preparedStatement, resultSet);
        }
        return product;
    }

    public boolean insert(Product product) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO pruducts (name, price, stockQuantity) VALUES(?, ?, ?)";
        try {

            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getStockQuantity());
            preparedStatement.executeUpdate();

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeStatement(connection, preparedStatement);
        }
    }

    public boolean update(Product product) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE pruducts SET price = ?, stockQuantity = ? WHERE id = ?";
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getPrice());
            preparedStatement.setInt(2, product.getStockQuantity());
            preparedStatement.setLong(3, product.getId());
            return preparedStatement.executeUpdate() == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeStatement(connection, preparedStatement);
        }
    }

    public boolean updateStockQuantity(int id, int quantity) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE pruducts SET stockQuantity = ? WHERE id = ?";
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setLong(2, id);
            return preparedStatement.executeUpdate() == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeStatement(connection, preparedStatement);
        }
    }

    public boolean delete(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM pruducts WHERE id = ?";
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeStatement(connection, preparedStatement);
        }
    }


    private Product getProduct(ResultSet resultSet) throws SQLException {
        Product product = null;
        if (resultSet.next()) {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            int stockQuantity = resultSet.getInt("stockQuantity");

            String category = resultSet.getString("category");
            product = ProductFactory.createProduct(id, name, price, stockQuantity, category);
        }
        return product;
    }

}

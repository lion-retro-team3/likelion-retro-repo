package product.repository;

import product.domain.Product;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo {

    StringBuilder sql = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    ProductRepo() {
    }

    public List<Product> findAll(Connection connection) {
        List<Product> products = new ArrayList<>();
        sql = new StringBuilder();
        sql.append("SELECT * FROM pruduct");
        try {
            preparedStatement = connection.prepareStatement(sql.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  products;
    }



    private Product getProduct(ResultSet resultSet) throws SQLException {
        Product product;
        if (resultSet.next()) {
            long id = resultSet.getLong("id");
            int price = resultSet.getInt("price");
            int stockQuantity = resultSet.getInt("stockQuantity");
            String category = resultSet.getString("category");

        }
        return null;
    }

}

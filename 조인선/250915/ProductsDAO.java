package lionjdbc.ProductsExample;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class ProductsDAO {

    //insert
    public int insertProducts(ProductsDTO productsDTO) {
        String sql = "insert into products(name, price, reg_date) values(?,?,?)";
        int result = 0;
        try (
                Connection conn = ProductsDBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);

        ) {
            ps.setString(1, productsDTO.getName());
            ps.setInt(2, productsDTO.getPrice());
            ps.setDate(3, Date.valueOf(productsDTO.getReg_date()));


            int resultCount = ps.executeUpdate();
            if (resultCount >= 0) {
                result = 1;
                System.out.println(resultCount + "건 입력완료");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result;

    }
}


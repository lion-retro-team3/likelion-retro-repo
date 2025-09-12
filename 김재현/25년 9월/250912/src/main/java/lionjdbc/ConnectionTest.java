package lionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/liondb";
        String name = "wogus";
        String password = "wogus77";
        connection = DriverManager.getConnection(url, name, password);

        if (connection != null) {
            System.out.println("^^");
        } else {
            System.out.println("-_-;");
        }
    }
}

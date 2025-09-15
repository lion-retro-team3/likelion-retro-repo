package lionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertTest {
    public static void main(String[] args) throws Exception {
        // 0. 드라이버로딩 - MySQL 드라이버를 메모리에 올려준다.

        String url = "jdbc:mysql://localhost:3306/liondb";
        String name = "wogus";
        String password = "wogus77";

        // 1. 접속 - Connection
        Connection conn = null;
        conn = DriverManager.getConnection(url, name, password);

        // 2. 쿼리 작성 -- PreparedStatement
        String sql = "insert into a(name) values(?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        // 반드시 ?에 값을 채워주어야한다.
        ps.setInt(1, 10);
        int resultCount = ps.executeUpdate();
        if (resultCount == 1) {
            System.out.println("입력 성공!!");
        }
        ps.close();
        conn.close();

    }
}

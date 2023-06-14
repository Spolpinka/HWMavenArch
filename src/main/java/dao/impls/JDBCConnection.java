package dao.impls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    final static String user = "postgres";
    final static String password = "421243266";
    final static String url = "jdbc:postgresql://localhost:5432/skypro";

    public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, user, password);
    }
}

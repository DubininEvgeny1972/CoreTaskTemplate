package jm.task.core.jdbc.util;
import java.sql.*;

public class Util {
    public static final String URL = "jdbc:mysql://localhost:3306/User?useSSL=false";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;

    public Connection getConnection() throws  SQLException {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException throwables) {
            System.out.println("Соединение не создано");
            throwables.printStackTrace();
        }
        return connection;
    }
}

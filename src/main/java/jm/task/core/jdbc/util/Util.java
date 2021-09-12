package jm.task.core.jdbc.util;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Util {
//    public static final String USER_NAME = "root";
//    public static final String PASSWORD = "root";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static Statement statement;
    public static Connection connection;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public Statement getConnection(){

            Connection connection;
            try {
                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);

                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                if (!connection.isClosed()) {
                    System.out.println("Соединение с БД установлено");
                }
            }catch (SQLException e) {
                System.out.println("Не удалось загрузить класс драйвера");
            }
//        try {
//            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//
//            }
//        try {
//                statement = connection.createStatement();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//
//            }
        return statement;
    }


}

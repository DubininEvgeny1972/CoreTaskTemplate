package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.Main;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        Util UT = new Util();
        Connection connection = UT.getConnection();
        Statement statement = connection.createStatement();
        if(statement.executeUpdate("CHECK TABLE USER") != -1) {
            statement.executeUpdate("CREATE TABLE USER " +
                    "(id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "NAME VARCHAR(20) not null, " +
                    "LASTNAME VARCHAR(20) not null, " +
                    "AGE INT not null)");
        }
        connection.close();
        statement.close();
    }

    public void dropUsersTable() throws SQLException {
        Util UT = new Util();
        Connection connection = UT.getConnection();
        Statement statement = connection.createStatement();
        if(statement.executeUpdate("CHECK TABLE USER") == -1) {
            statement.executeUpdate("DROP TABLE USER");
        }
        connection.close();
        statement.close();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        Util UT = new Util();
        Connection connection = UT.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO USER (NAME, LASTNAME, AGE) VALUES (\"" + name + "\", " + "\"" + lastName +"\", " + age + ")");
        connection.close();
        statement.close();
    }

    public void removeUserById(long id) throws SQLException{
        Util UT = new Util();
        Connection connection = UT.getConnection();
        Statement statement = connection.createStatement();
        String idStr = Long.toString(id);
        statement.executeUpdate("DELETE FROM USER WHERE id = \"" + idStr + "\"");
        connection.close();
        statement.close();
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> user = new ArrayList<>();
        Util UT = new Util();
        Connection connection = UT.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM USER;");
        while(rs.next()) {
            User us = new User(rs.getString(2), rs.getString(3), rs.getByte(4));
            user.add(us);
        }
        connection.close();
        statement.close();
        return user;
    }

    public void cleanUsersTable()  throws SQLException {
        Util UT = new Util();
        Connection connection = UT.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("TRUNCATE TABLE USER");
        connection.close();
        statement.close();
    }
}

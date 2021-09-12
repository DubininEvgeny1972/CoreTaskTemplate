package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {

    }

    public void dropUsersTable() {

    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() throws SQLException {
        List<User> user = new ArrayList<>();
        ResultSet rs = Util.statement.executeQuery("SELECT * FROM USER;");
        while(rs.next()) {
            User us = new User(rs.getString(1), rs.getString(2), rs.getByte(3));
            user.add(us);
        }
        return user;
    }

    public void cleanUsersTable() {

    }
}

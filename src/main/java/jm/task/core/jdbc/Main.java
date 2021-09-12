package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Util ut = new Util();
            Statement statement = ut.getConnection();
            statement.executeUpdate("CREATE TABLE USER " +
                    "(id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "NAME VARCHAR(20) not null, " +
                    "LASTNAME VARCHAR(20) not null, " +
                    "AGE INT not null)");
            User user1 = new User("Ivan", "Ivanov", (byte) 25);
            User user2 = new User("Jon", "Lennon", (byte) 35);
            User user3 = new User("Bob", "Dillan", (byte) 52);
            User user4 = new User("Kirk", "Duglas", (byte) 48);
            statement.executeUpdate("INSERT INTO USER (NAME, LASTNAME, AGE) VALUES" +
                    " (" + user1.getName() + ", " + user1.getLastName() +", " +user1.getAge() + ")");
            System.out.println("User с именем – " + user1.getLastName() + "добавлен в базу данных ");
            statement.executeUpdate("INSERT INTO USER (NAME, LASTNAME, AGE) VALUES ('Jon', 'Lennon', 35)");
            statement.executeUpdate("INSERT INTO USER (NAME, LASTNAME, AGE) VALUES" +
                    " (" + user2.getName() + ", " + user2.getLastName() +", " +user2.getAge() + ")");
            System.out.println("User с именем – " + user2.getLastName() + "добавлен в базу данных ");
            statement.executeUpdate("INSERT INTO USER (NAME, LASTNAME, AGE) VALUES ('Bob', 'Dillan', 52)");
            statement.executeUpdate("INSERT INTO USER (NAME, LASTNAME, AGE) VALUES" +
                    " (" + user3.getName() + ", " + user3.getLastName() +", " +user3.getAge() + ")");
            System.out.println("User с именем – " + user3.getLastName() + "добавлен в базу данных ");
            statement.executeUpdate("INSERT INTO USER (NAME, LASTNAME, AGE) VALUES ('Kirk', 'Duglas', 48)");
            statement.executeUpdate("INSERT INTO USER (NAME, LASTNAME, AGE) VALUES" +
                    " (" + user4.getName() + ", " + user4.getLastName() +", " +user4.getAge() + ")");
            System.out.println("User с именем – " + user4.getLastName() + "добавлен в базу данных ");
            UserServiceImpl usi = new UserServiceImpl();
            List<User> list = usi.getAllUsers();
            for(User us : list) {
                System.out.println(us.getName() + ", " + us.getLastName() + ", " + us.getAge());
            }
    }
}

package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<User> listUser = new ArrayList<>();
    public static void main(String[] args) throws SQLException {
        UserServiceImpl userDaoJDBC = new UserServiceImpl();
        userDaoJDBC.createUsersTable();//Создаю таблицу

        User user1 = new User("Ivan", "Ivanov", (byte) 25);
        User user2 = new User("Jon", "Lennon", (byte) 35);
        User user3 = new User("Bob", "Dillan", (byte) 52);
        User user4 = new User("Kirk", "Duglas", (byte) 48);

        listUser.add(user1);
        listUser.add(user2);
        listUser.add(user3);
        listUser.add(user4);
        for(User user : listUser) {
            userDaoJDBC.saveUser(user.getName(), user.getLastName(),user.getAge());//Добавляю всех пользователей в таблицу
            System.out.println("User с именем – " + user.getName() + " добавлен в базу данных");
        }

        List<User> list = userDaoJDBC.getAllUsers();//Получаю всех пользователей из таблицы
        for(User us : list) {
            System.out.println(us.toString());//Выводим юзеров в консоль
        }
        userDaoJDBC.removeUserById(2); //Удаляем Юзера с ИД = 2
        userDaoJDBC.cleanUsersTable();//Очищаю таблицу
        userDaoJDBC.dropUsersTable();//Удаляю таблицу
    }
}
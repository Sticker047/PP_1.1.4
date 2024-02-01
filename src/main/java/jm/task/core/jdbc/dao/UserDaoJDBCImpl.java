package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    //todo: codeStyle ..это очень необычно, constructor - вверху класса
    public UserDaoJDBCImpl() {
    }


    private int executeUpdate(String query) {
        try {
            Statement statement = Util.getConnection().createStatement();
            int result = statement.executeUpdate(query);
            return result;
        } catch (SQLException e) {
            return 0;
        }
    }



    public void createUsersTable() {
        String usersTableQuery = "CREATE TABLE users (\n" +
                "    id INTEGER AUTO_INCREMENT PRIMARY KEY, \n" +
                "    firstname VARCHAR(30), \n" +
                "    lastname VARCHAR(30), \n" +
                "    age INTEGER\n" +
                ")";

        executeUpdate(usersTableQuery);
    }

    public void dropUsersTable() {
        executeUpdate("DROP TABLE users");
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            String sql = "INSERT INTO users (firstname, lastname, age) VALUES (?, ?, ?)";
            PreparedStatement statement = Util.getConnection().prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement statement = Util.getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            final Statement statement = Util.getConnection().createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getByte(4)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        try {
            final Statement statement = Util.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

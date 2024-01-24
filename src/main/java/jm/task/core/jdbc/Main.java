package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

        userDaoJDBC.createUsersTable();

        userDaoJDBC.saveUser("Иван", "Иванов", (byte) 20);
        userDaoJDBC.saveUser("Петр", "Петров", (byte) 20);
        userDaoJDBC.saveUser("Сидор", "Сидоров", (byte) 20);
        userDaoJDBC.saveUser("Василий", "Васечкин", (byte) 20);

        userDaoJDBC.getAllUsers().forEach(System.out::println);
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();

    }
}

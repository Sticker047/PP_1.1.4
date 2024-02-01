package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД//todo: ?? лишние комменты
    private static Connection connection;

    public static Connection getConnection() {//todo: избавляемтся от static - так мы ломаем парадигму ООП
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/usersdb",
                        "root",
                        "password"//todo: выносим константы, описано как..
                );
            } catch (SQLException e) {
                //todo: если в дальнейшей работе приложения нет смысла - роняем его:
                throw new RuntimeException("... .. .. : " + e.getMessage());
//                e.printStackTrace();
            }
        }
        return connection;
    }
}

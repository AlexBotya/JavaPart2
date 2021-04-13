package Server;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://192.168.0.19:3306/chatusers",
                    "root",
                    "1"
            );
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}

package Server;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/chatusers",
                    "root",
                    null
            );
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}

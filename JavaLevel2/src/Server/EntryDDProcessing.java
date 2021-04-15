package Server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class EntryDDProcessing {

    public Optional<Entry> findByLoginAndPassword(String login, String password) {
        Connection connection = DBConnection.getConnection();
        try {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM users WHERE login = ? AND password = ?");
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(
                            new Entry(
                                    resultSet.getString("name"),
                                    resultSet.getString("login"),
                                    resultSet.getString("password")
                            )
                    );
                }return Optional.empty();


            } catch (SQLException throwables) {
                throw new RuntimeException(throwables);
            }
        } finally {
            close(connection);
        }
    }

    private void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

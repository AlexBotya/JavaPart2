package Server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EntryDDProcessing {
    public List<Entry> findAll() {
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CHATUSERS");

            List<Entry> entries = new ArrayList<>();
            while (resultSet.next()) {
                entries.add(
                        new Entry(
                                resultSet.getString("name"),
                                resultSet.getString("login"),
                                resultSet.getString("password")
                        )
                );
            }

            return entries;

        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            close(connection);
        }
    }

    public Optional<Entry> findByLoginAndPassword(String login, String password) {
        Connection connection = DBConnection.getConnection();


        try {

            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM CHATUSERS WHERE LOGIN = '" + login +
                        "' AND PASSWORD = '" + password + "'");
                if (resultSet.next()) {
                    return Optional.of(
                            new Entry(
                                    resultSet.getString("name"),
                                    resultSet.getString("login"),
                                    resultSet.getString("password")
                            )
                    );
                }

                return Optional.empty();

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

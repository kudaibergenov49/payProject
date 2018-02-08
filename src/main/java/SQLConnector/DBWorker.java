package SQLConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * класс для создания соедиения с БД
 */
public class DBWorker {
    private final String URL = "jdbc:mysql://localhost:3306/world?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    private Connection connection;

    public DBWorker() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Не загружен класс драйвера");
        }
    }

    /**
     *
     * @return Соедиение с базой данных
     */
    public Connection getConnection() {
        return connection;
    }

}

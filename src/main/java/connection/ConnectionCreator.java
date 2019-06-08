package connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {
    private static final String DB_PROPERTIES = "database.properties";
    private static final String URL_PROPERTY = "url";
    private static final String USER_PROPERTY = "user";
    private static final String PASSWORD_PROPERTY = "password";
    private String url;
    private String user;
    private String password;

    public ConnectionCreator() throws ConnectionException {
        Properties properties = new Properties();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(DB_PROPERTIES)) {
            properties.load(input);
            url = properties.getProperty(URL_PROPERTY);
            user = properties.getProperty(USER_PROPERTY);
            password = properties.getProperty(PASSWORD_PROPERTY);
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage(), e);
        }
    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}

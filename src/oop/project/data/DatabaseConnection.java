package oop.project.data;
import java.io.FileInputStream;
import java.io.IOException;
import oop.project.data.IDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection implements IDB {
    private static final Properties properties = new Properties();
    private static DatabaseConnection instance;

    static {
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("Error: config.properties file not found!");
        }
    }
    private static final String URL = properties.getProperty("db.url");
    private static final String USER = properties.getProperty("db.user");
    private static final String PASSWORD = properties.getProperty("db.password");

    private DatabaseConnection() { }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

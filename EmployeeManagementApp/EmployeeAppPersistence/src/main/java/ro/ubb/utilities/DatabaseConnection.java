package ro.ubb.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private final String url;
    private final String user;
    private final String password;
    private Connection databaseConnection;

    public DatabaseConnection() {
        this.url = "jdbc:mysql://127.0.0.1:3306/proiectcolectiv";
        this.user = "admin";
        this.password = "admin123";
        this.databaseConnection = null;
    }

    public Connection getConnection () throws SQLException {
        databaseConnection = DriverManager.getConnection(url, user, password);
        return databaseConnection;
    }

    public void close() throws SQLException {
        databaseConnection.close();
    }


}


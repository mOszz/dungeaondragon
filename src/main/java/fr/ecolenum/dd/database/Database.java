package fr.ecolenum.dd.database;

import java.sql.*;
import java.util.Properties;
/**
 * This class manages the database connection for the Donjon & Dragon application.
 * It implements a Singleton to ensure a shared single instance of the connection.
 */
public class Database {
    private static Connection connection;

    /**
     * Retrieves the instance of the database connection, creating it if it doesn't exist yet.
     *
     * @return The instance of the database connection.
     */
    public static Connection databaseGetInstance() {
        if (connection == null) {
            connection = connection();
        }
        return connection;
    }

    /**
     * Establishes a connection to the database using configuration information.
     *
     * @return The Connection object representing the established connection.
     * @throws RuntimeException If an error occurs during the connection.
     */
    private static Connection connection() {
        Properties env = DotenvProperties.propertiesGetInstance();

        String url = "jdbc:mysql://localhost:3306/donjondragon?serverTimezone=UTC";
        String user = env.getProperty("DB_USER");
        String password = env.getProperty("DB_PASSWORD");

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



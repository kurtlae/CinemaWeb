package group1.cinema.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Cinema database class
 */
public final class Database {

    /**
     * Database URL
     */
    private static final String DB_URL = "jdbc:mysql://localhost:3306";

    /**
     * Database name
     */
    private static final String DB_DATABASE = "cinema";

    /**
     * Database username
     */
    private static final String DB_USERNAME = "cinema";

    /**
     * Database password
     */
    private static final String DB_PASSWORD = "cinema";

    /**
     * Database Connection
     */
    private static Connection conn;

    /**
     * Attempts to connect to the database
     * 
     * @throws SQLException SQL/Connection Error
     * @throws ClassNotFoundException 
     */
    public static final void connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");  // Inlagd
        conn = DriverManager.getConnection(DB_URL + "/" + DB_DATABASE, DB_USERNAME, DB_PASSWORD);
    }

    /**
     * Gets the connection interface associated with the database
     * 
     * @return Connection interface
     * @throws SQLException SQL/Connection error
     * @throws ClassNotFoundException 
     */
    public static final Connection getConnection() throws SQLException, ClassNotFoundException {
        if (conn == null) {
            connect();
        }

        return conn;
    }

    /**
     * Closes the connection to the database
     *
     * @throws SQLException SQL/Connection Error
     * @return True if the connection was closed successfully, false if the
     *         connection was null
     */
    public static final boolean close() throws SQLException {
        if (conn != null) {
            conn.close();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Generates an error message based on the given exception
     * 
     * @param e SQL Exception
     * @param message Message
     * @return Generated error message
     */
    public static String generateErrorMsg(SQLException e) {
        return String.format("SQL Error %d: '%s'", e.getErrorCode(), e.getMessage());
    }

    /**
     * Generates an error message based on the given exception along with a
     * custom error message
     * 
     * @param e SQL Exception
     * @param message Message
     * @return Generated error message
     */
    public static String generateErrorMsg(SQLException e, String message) {
        return String.format("%s, SQL Error %d: %s", message, e.getErrorCode(), e.getMessage());
    }

}

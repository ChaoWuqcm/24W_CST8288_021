package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Database connection pool
 */
public class DbConnectionPool {
    private final Queue<Connection> pool;

    public static final String URL = "jdbc:mysql://localhost:3306/db_reduce_wast?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&nullCatalogMeansCurrent=true&rewriteBatchStatements=true";
    public static final String USER = "root";
    public static final String PASSWORD = "r0yL3mY8Rnff";
    public static final int INITIAL_SIZE = 10;

    private volatile static DbConnectionPool instance;

    /**
     * Get the instance of database connection pool
     *
     * @return Database connection pool
     * @throws SQLException SQL exception
     */
    public static DbConnectionPool getInstance() throws SQLException {
        if (instance == null) {
            synchronized (DbConnectionPool.class) {
                if (instance == null) {
                    try {
                        instance = new DbConnectionPool(INITIAL_SIZE);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException("Database driver not found", e);
                    }
                }
            }
        }
        return instance;
    }

    /**
     * Create a new database connection pool
     *
     * @throws SQLException SQL exception
     * @throws ClassNotFoundException Class not found exception
     */
    private DbConnectionPool(int initialSize)
            throws SQLException, ClassNotFoundException {
        pool = new ConcurrentLinkedQueue<>();

        Class.forName("com.mysql.jdbc.Driver");
        for (int i = 0; i < initialSize; i++) {
            pool.add(createConnection());
        }
    }

    /**
     * Get a database connection
     *
     * @return Database connection
     * @throws SQLException SQL exception
     */
    public Connection getConnection() throws SQLException {
        Connection connection = pool.poll();
        if (connection == null || !connection.isValid(1)) {
            // If no available connection, create a new one
            connection = createConnection();
        }
        return connection;
    }

    /**
     * Release a database connection
     *
     * @param connection Database connection
     */
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            pool.add(connection);
        }
    }

    /**
     * Create a new database connection
     *
     * @return Database connection
     * @throws SQLException SQL exception
     */
    private Connection createConnection()
            throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

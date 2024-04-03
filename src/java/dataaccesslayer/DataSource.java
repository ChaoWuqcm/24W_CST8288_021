
package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataSource {
    
    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/fwrp"; // &&allowPublicKeyRetrieval=true
    private String username = "root";
    private String password = "123456";

    public DataSource() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
 * Only use one connection for this application, prevent memory leaks.
     */
    public Connection createConnection() {
        //System.out.println("create new connection, one exists already");
        try {
            if (connection != null) {
                //System.out.println("Cannot create new connection, one exists already");
            } else {
                System.out.println("Cannot create new connection, one exists already");
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
    
    
/*
    private Connection connection = null;
    //private String url = "jdbc:mysql://localhost:3306/books?useSSL=false&allowPublicKeyRetrieval=true";
    private String url = "jdbc:mysql://localhost:3306/fwrp";
    private String username = "root";
    private String password = "123456";

    
    public DataSource() {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    /*
 * Only use one connection for this application, prevent memory leaks.
     
    public Connection createConnection() throws SQLException {
        try {
            if (connection != null) {
                System.out.println("Cannot create new connection, one exists already");
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return connection;
    }*/
}

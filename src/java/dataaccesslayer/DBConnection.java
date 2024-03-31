/*File name:DBConnection.java 
* Author: Yu,Dunxing, 040885864
* Course: CST8288 – 021
* Assignment: lab2
* Date:2024-02-25
* Professor: Sivaneswaran, Shajiiv
* Purpose: Demo lab2
*/
package dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


//Create DB connection.
/**
 * Create DB connection
 * @author Dunxing Yu
 *
 */
public class DBConnection {
	/** define connection to hold connection instance*/
	public static Connection connection = null;
	/** define connection to hold connection instance*/
	private static DBConnection dbconnection;
	
	/**
	 * Private constructor
	 */
	private DBConnection() {};
	
	/**Create Singleton DB connection.
	 * @return DB connection
	 * @throws SQLException
	 */
	public static DBConnection getInstance() throws SQLException {
		
		String[] connectionInfo = openPropsFile();

	        if (dbconnection == null) {
	        	dbconnection = new DBConnection();
	        }
	        try {
	    		
	    		connection =DriverManager.getConnection(connectionInfo[0], connectionInfo[1], connectionInfo[2]);
    		}
	        catch(SQLException e ) {
	        	e.printStackTrace();	        	
	        }
	       
	        return dbconnection;
	    }
	/**
	 * Read database.properties to get the DB connection information
	 * @return info DB connection information
	 */
	 private static String[] openPropsFile() {
	        // added use of Properties and try-with-resources 
	        Properties props = new Properties();

	        try  {
	        	InputStream in = Files.newInputStream(Paths.get("database.properties"));
	            props.load(in);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        String connectionString = props.getProperty("url");
	        String username = props.getProperty("username");
	        String password = props.getProperty("password");

	        String[] info = new String[3];
	        info[0] = connectionString;
	        info[1] = username;
	        info[2] = password;

	        return info;
	    }
	
    
}

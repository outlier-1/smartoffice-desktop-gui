package main.java.persistence_layer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
*
* @author mirac
*/

public class ConnectionFactory {
	
	public Connection connection;    
    private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String CONNECTION_IP = "35.195.116.80:3306";
    private static final String DB_NAME = "smart_office";
    // TEST SERVER URL FOR DEVELOPING.
    private static final String CONNECTION_URL = "jdbc:mysql://localhost/SmartOffice";
    // Production URL = String.format("jdbc:mysql://%s/%s", CONNECTION_IP, DB_NAME);
    
    /**
     * @param dbUser Username Of Database Client
     * @param dbPassword Password Of Database Client
     * @return 
     * @throws ClassNotFoundException 
     * @throws SQLException 
     */
    public static Connection EstablishConnection(String dbUser, String dbPassword) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Class.forName(DRIVER_CLASS_NAME);
        conn = DriverManager.getConnection(CONNECTION_URL, dbUser, dbPassword);
        return conn;
    }
    
}

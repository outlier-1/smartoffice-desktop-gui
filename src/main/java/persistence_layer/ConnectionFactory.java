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
    private static final String CONNECTION_URL = String.format("jdbc:mysql://%s/%s", CONNECTION_IP, DB_NAME);
    
    /**
     * @param dbUser Username Of Database Client
     * @param dbPassword Password Of Database Client
     * @return 
     */
    public static Connection EstablishConnection(String dbUser, String dbPassword){
        Connection conn = null;
        try{
            Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection(CONNECTION_URL, dbUser, dbPassword);
        }
        catch(ClassNotFoundException e){
        }
        catch (SQLException ex) {
            System.out.println(String.format("Access Denied for user %s",dbUser));
        }
        return conn;
    }
    
}

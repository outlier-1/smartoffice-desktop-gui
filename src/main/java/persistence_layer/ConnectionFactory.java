package main.java.persistence_layer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
*
* @author mirac
*/

public class ConnectionFactory {
	
	protected String dbUser;
	protected String dbPass;
	protected String connectionIP;
	protected Connection connection;

	private static final String DB_NAME = "smart_office";
	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String CONNECTION_URL = "jdbc:mysql://localhost/SmartOffice";
    // Production URL = String.format("jdbc:mysql://%s/%s", CONNECTION_IP, DB_NAME);
   
    public ConnectionFactory(){
    	checkJDBCDrivers();
		this.setConnectionIP("35.195.116.80:3306");
    }
    
    public ConnectionFactory(String dbUser, String dbPass){
    	checkJDBCDrivers();
    	this.setDbUser(dbUser);
		this.setDbPass(dbPass);
		
		// Use Default Values of IP
		this.setConnectionIP("35.195.116.80:3306");
    }
    
    public ConnectionFactory(String dbUser, String dbPass, String connectionIP){
    	checkJDBCDrivers();
    	this.setDbUser(dbUser);
		this.setDbPass(dbPass);
		this.setConnectionIP(connectionIP);
    }
    
    private static void checkJDBCDrivers() {
    	try { Class.forName(DRIVER_CLASS_NAME); }
    	catch (ClassNotFoundException e) {
    		// -- WILL CREATE A LOG FILE AT EXCEPTION HANDLING PHASE -- 
			e.printStackTrace(); // Temporary
		}
    }
    
    public void EstablishConnection() {
    	try { this.connection = DriverManager.getConnection(CONNECTION_URL, this.dbUser, this.dbPass); }
        catch(SQLException e) {
        	e.printStackTrace();
        }
        finally { /* Will be edited */ }
    }
	
	/**
	 * @return the connectionIP
	 */
	public String getConnectionIP() {
		return connectionIP;
	}
	
	/**
	 * @param connectionIP the connectionIP to set
	 */
	public void setConnectionIP(String connectionIP) {
		this.connectionIP = connectionIP;
	}
	
	/**
	 * @return the dbUser
	 */
	public String getDbUser() {
		return dbUser;
	}
	
	/**
	 * @param dbUser the dbUser to set
	 */
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	
	/**
	 * @return the dbPass
	 */
	public String getDbPass() {
		return dbPass;
	}
	
	/**
	 * @param dbPass the dbPass to set
	 */
	
	public void setDbPass(String dbPass) {
		this.dbPass = dbPass;
	}
	
	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
    
}

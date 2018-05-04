package main.java.persistence_layer;

import main.java.persistence_layer.LoggedUser;

/**
 * @author mirac
 *
 */
public final class AppConnection extends ConnectionFactory {

	private LoggedUser loggedUser;
	
	public AppConnection() { }
	
	public AppConnection(String dbUser, String dbPass) {
		super(dbUser, dbPass);
	}
	
	public AppConnection(String dbUser, String dbPass, String connectionIP) {
		super(dbUser, dbPass, connectionIP);
	}

	/**
	 * @return the loggedUser
	 */
	public LoggedUser getLoggedUser() {
		return loggedUser;
	}

	/**
	 * @param loggedUser the loggedUser to set
	 */
	public void setLoggedUser(LoggedUser loggedUser) {
		this.loggedUser = loggedUser;
	}
	

}

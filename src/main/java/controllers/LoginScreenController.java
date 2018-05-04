package main.java.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.controllers.BaseScreenController;
import main.java.persistence_layer.AppConnection;
import main.java.persistence_layer.LoggedUser;
import main.java.persistence_layer.implementations.EmployeeDaoIMP;

public class LoginScreenController implements Initializable {
	
	private AppConnection conn;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		this.conn = new AppConnection(); 
	}  
	
	/** Elements of Login Screen */
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
	@FXML private Button btnLogin; 
    
	
	@FXML
	public void clickLoginButton() throws InterruptedException{
		try{
			conn.setDbUser(txtUsername.getText());
			conn.setDbPass(txtPassword.getText());
			conn.EstablishConnection();

			LoggedUser loggedUser = new LoggedUser(new EmployeeDaoIMP().getEmployee(Integer.parseInt(conn.getDbUser()), conn));
			conn.setLoggedUser(loggedUser);

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../../resources/view/BaseScreenView.fxml"));
			loader.load();
			BaseScreenController controller = loader.getController();
			controller.setConnection(conn);
			
			Parent baseScreenView = loader.getRoot();
			Stage baseWindow = new Stage();
			this.setViewProperties(baseWindow);
			baseWindow.setScene(new Scene(baseScreenView));
			baseWindow.show();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setViewProperties(Stage window){
		window.setResizable(false);
		window.setHeight(600);
		window.setWidth(950);
	}
}

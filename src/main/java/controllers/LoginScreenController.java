package main.java.controllers;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.persistence_layer.ConnectionFactory;

public class LoginScreenController implements Initializable {
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// will be overridden later.
	}  
	
	/** Elements of Login Screen */
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
	@FXML private Button btnLogin; 
    
	@FXML
	public void clickLoginButton() throws ClassNotFoundException {
		Connection conn = ConnectionFactory.EstablishConnection(txtUsername.getText(), txtPassword.getText());
	}
}

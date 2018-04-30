package main.java.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.persistence_layer.ConnectionFactory;

import main.java.persistence_layer.implementations.EmployeeDaoIMP;

public class LoginScreenController implements Initializable {
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// will be overridden later.
	}  
	
	/** Elements of Login Screen */
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
	@FXML private Button btnLogin; 
    
	// NOT DONE. YOU HAVE TO PASS THE CONNECTED USER'S NAME TO NEXT STAGE --> HYPERLINK
	@FXML
	public void clickLoginButton(ActionEvent event){
		try{
			Connection conn = ConnectionFactory.EstablishConnection(txtUsername.getText(), txtPassword.getText());
			Parent baseScreenView = FXMLLoader.load(getClass().getResource("../../resources/view/BaseScreenView.fxml"));
			Scene baseScreenScene = new Scene(baseScreenView);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setResizable(false);
			window.setHeight(600);
			window.setWidth(950);
			window.setScene(baseScreenScene);
			window.show();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}

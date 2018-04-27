package main.java.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.control.TextField;
import main.java.persistence_layer.ConnectionFactory;

public class BaseScreenController implements Initializable {

	@FXML private Hyperlink hypName;
	
	@FXML private Spinner<String> spHour;
	@FXML private Spinner<String> spMin;
	
	@FXML private TextField txtDuration;
	@FXML private Button btnSearch;

	
	@FXML 
	private void hypClicked() {
		// Go to Settings.
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Set The HyperText
		hypName.setText("Miraç Baydemir");
		hypName.setBorder(Border.EMPTY);
		
		// Initialize The Spinners
		ObservableList<String> hour = FXCollections.observableArrayList();
		for(int i=8; i<19; i++) {
			if(i<10) hour.add(String.format("0%s", i));
			else hour.add(Integer.toString(i));
		}
		
		ObservableList<String> min = FXCollections.observableArrayList();
		for(int i=0; i<60; i++) {
			if(i<10) min.add(String.format("0%s", i));
			else min.add(Integer.toString(i));
		}
	 
		SpinnerValueFactory<String> hrValueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<String>(hour);
		SpinnerValueFactory<String> minValueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<String>(min);

		spHour.setValueFactory(hrValueFactory);
		spMin.setValueFactory(minValueFactory);
		
	}

}

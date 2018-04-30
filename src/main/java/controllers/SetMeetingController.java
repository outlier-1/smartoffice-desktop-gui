package main.java.controllers;

import main.java.persistence_layer.dto.Departments;
import main.java.persistence_layer.dto.Employees;
import main.java.persistence_layer.implementations.DepartmentDaoIMP;
import main.java.persistence_layer.implementations.EmployeeDaoIMP;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class SetMeetingController implements Initializable {

	/* FORM CONTROLS */
	@FXML private Label lblMeetingTime;
	@FXML private Label lblDuration;
	@FXML private ComboBox<String> cmbDepartment;
	@FXML private ComboBox<String> cmbEmployee;
	@FXML private Button btnAddEmployee;
	@FXML private Button btnDeleteEmployee;
	@FXML private Button btnSetMeeting;
	
	// Department List and Binding Employee List
	private List<Departments> depList;
	private List<Employees> empList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Fill depList
		DepartmentDaoIMP imp = new DepartmentDaoIMP();
		depList = imp.getAllDepartments();
		
		// Fill ComboBox Departments With depList
		for (Departments dept : this.depList) {
		    cmbDepartment.getItems().add(dept.getDepartmentName());
		}	
		
		// Choose First and Select First Item
		cmbDepartment.getSelectionModel().selectFirst();
		this.fillCmbEmployee(depList.get(0));
	}
	
	@FXML
	public void cmbItemChanged(){
		cmbEmployee.getItems().clear();
		// Find Chosen Department And Fill
		for (Departments dept : this.depList) {
		    if(dept.getDepartmentName().equals(cmbDepartment.getValue())) {
				this.fillCmbEmployee(dept);
		    	break;
		    }
		}
	}
	
	private void fillCmbEmployee(Departments chosen){
		String query = String.format("SELECT employees.first_name, employees.last_name FROM employees INNER JOIN dept_emp ON employees.emp_no = dept_emp.emp_no AND dept_emp.dept_no =%s",chosen.getDepartmentNo());
		EmployeeDaoIMP imp = new EmployeeDaoIMP();
		ResultSet rs = imp.getResultSetByQuery(query);
		if(empList == null) empList = new ArrayList<Employees>();
		else empList.clear();
		
		try {
			while (rs.next()) {
				empList.add(new Employees(rs.getString("first_name"), rs.getString("last_name")));	            
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (Employees emp : this.empList) {
			cmbEmployee.getItems().add(String.format("%s %s",emp.getFirstName(), emp.getLastName()));
		}	
		cmbEmployee.getSelectionModel().selectFirst();
	}
}

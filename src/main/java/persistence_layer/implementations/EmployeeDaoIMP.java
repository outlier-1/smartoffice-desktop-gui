/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.persistence_layer.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.persistence_layer.AppConnection;
import main.java.persistence_layer.dto.Employees;
import main.java.persistence_layer.dao.EmployeesDAO;
/**
 *
 * @author mirac
 */
public class EmployeeDaoIMP implements EmployeesDAO {

	private AppConnection conn;
	
	@Override
	public List<Employees> getAllEmployees(String condition) {
		Statement stmt = null;
		
		String selectQuery = "SELECT emp_no, first_name, last_name FROM employees ";
		if(!condition.isEmpty()) selectQuery += condition;
		selectQuery += "ORDER by first_name";
		List<Employees> empList = new ArrayList<Employees>();
		try{
			Connection conn = ConnectionFactory.EstablishConnection("root", "sananela17");
	        stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(selectQuery);
	        while (rs.next()) {
	        	empList.add(new Employees(rs.getInt("emp_no"), rs.getString("first_name"), rs.getString("last_name")));	            
	        }
	    }
		catch(SQLException e ){
	    	e.printStackTrace();
	    }
		finally{
	        /* will be edited*/
	    }
		return empList;
	}
	
	public ResultSet getResultSetByQuery(String query){
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Connection conn = AppConnection.EstablishConnection("root", "sananela17");
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(query);
	    }
		catch(SQLException e ){
	    	e.printStackTrace();
	    }
		finally{
	        /* will be edited*/
	    }
		return rs;
	}
	
	@Override
	public Employees getEmployee(int no, AppConnection conn) {
		PreparedStatement stmt = null;
		String selectQuery = "SELECT emp_no, first_name, last_name, gsm FROM employees WHERE emp_no=?";
		Employees emp = new Employees();
		emp.setEmpNo(no);
		
		try{
			if(conn.getConnection() == null) {
				throw new IllegalArgumentException("Please pass an established connection");
			}
			stmt = conn.getConnection().prepareStatement(selectQuery);
			stmt.setInt(1, no);
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	        	emp.setFirstName(rs.getString(2));
	        	emp.setLastName(rs.getString(3));
	        	emp.setGsm(rs.getString(4));
	        }
	    }
		catch(SQLException e ){
	    	e.printStackTrace();
	    }
		finally{
	        /* will be edited*/
	    }
		return emp;
	}

	@Override
	public void addEmployee() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee() {
		// TODO Auto-generated method stub
		
	}
    
}

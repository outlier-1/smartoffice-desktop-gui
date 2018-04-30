/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.persistence_layer.implementations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.persistence_layer.ConnectionFactory;
import main.java.persistence_layer.dto.Departments;
import main.java.persistence_layer.dao.DepartmentsDAO;

/**
 *
 * @author mirac
 */
public class DepartmentDaoIMP implements DepartmentsDAO {

	@Override
	public List<Departments> getAllDepartments() {
		Statement stmt = null;
		String selectQuery = "SELECT DISTINCT dept_no, dept_name FROM departments ORDER BY dept_name";
		List<Departments> depList = new ArrayList<Departments>();
		try{
			Connection conn = ConnectionFactory.EstablishConnection("root", "sananela17");
	        stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(selectQuery);
	        while (rs.next()) {
	        	depList.add(new Departments(rs.getInt("dept_no"), rs.getString("dept_name")));	            
	        }
	    }
		catch(SQLException e ){
	    	e.printStackTrace();
	    }
		finally{
	        /* will be edited*/
	    }
		return depList;
	}

	@Override
	public Departments getDepartment(int number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDepartments() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDepartments() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDepartments() {
		// TODO Auto-generated method stub
		
	}
    
}

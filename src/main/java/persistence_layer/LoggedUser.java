package main.java.persistence_layer;

import main.java.persistence_layer.dto.Employees;

public class LoggedUser extends Employees{

	public LoggedUser(){
		
	}
	
	/**
	 * 
	 * @param emp Is A Parent Instance Returned By DAO Implementation
	 * Down casting throws ClassCastException, this is a temporary solution
	 * Function will set the other properties as soon as database records become solid.
	 * For now, it will throw a null pointer exception because of null dates at database table.
	 */
	public LoggedUser(Employees emp){
		this.setEmpNo(emp.getEmpNo());
		this.setFirstName(emp.getFirstName());
		this.setLastName(emp.getLastName());
		this.setGsm(emp.getGsm());
	}
	
}

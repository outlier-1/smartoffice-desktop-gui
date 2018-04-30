/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.persistence_layer.dto;

/**
 *
 * @author mirac
 */
public class Departments {
    private int departmentNo;
    private String departmentName;

    public Departments(int departmentNo, String departmentName) {
    	this.departmentNo = departmentNo;
    	this.departmentName = departmentName;
    }
    public int getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(int departmentNo) {
        this.departmentNo = departmentNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

   
}

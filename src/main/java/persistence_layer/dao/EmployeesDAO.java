/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.persistence_layer.dao;

import java.util.List;

import main.java.persistence_layer.AppConnection;
import main.java.persistence_layer.dto.Employees;

/**
 *
 * @author mirac
 */
public interface EmployeesDAO {
    public List<Employees> getAllEmployees(String condition);
    public Employees getEmployee(int no, AppConnection conn);
    public void addEmployee();
    public void updateEmployee();
    public void deleteEmployee();
}

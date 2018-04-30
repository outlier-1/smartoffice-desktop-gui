/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.persistence_layer.dao;

import java.util.List;
import main.java.persistence_layer.dto.DepartmentEmployee;

/**
 *
 * @author mirac
 */
public interface DepartmentEmpDAO {
    public List<DepartmentEmployee> getAllDepEmployees(String condition);
    public DepartmentEmployee getDepEmployees(int id);
    public void addDepEmployee();
    public void updateDepEmployee();
    public void deleteDepEmployee();
}

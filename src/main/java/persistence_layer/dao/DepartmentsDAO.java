/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.persistence_layer.dao;

import java.util.List;
import main.java.persistence_layer.dto.Departments;

/**
 *
 * @author mirac
 */
public interface DepartmentsDAO {
    public List<Departments> getAllDepartments();
    public Departments getDepartment(int number);
    public void addDepartments();
    public void updateDepartments();
    public void deleteDepartments();
}

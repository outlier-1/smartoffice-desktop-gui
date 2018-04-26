/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.persistence_layer.dao;

import java.util.List;
import main.java.persistence_layer.dto.Salary;

/**
 *
 * @author mirac
 */
public interface SalaryDAO {
    public List<Salary> getAllSalaries();
    public Salary getSalary(int id);
    public void addSalary();
    public void updateSalary();
    public void deleteSalary();
}

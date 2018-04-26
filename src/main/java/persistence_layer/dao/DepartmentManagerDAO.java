/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.persistence_layer.dao;

import java.util.List;
import main.java.persistence_layer.dto.DepartmentManager;

/**
 *
 * @author mirac
 */
public interface DepartmentManagerDAO {
    public List<DepartmentManager> getAllDepManagers();
    public DepartmentManager getDepManager(int id);
    public void addDepManager();
    public void updateDepManager();
    public void deleteDepManager();
}

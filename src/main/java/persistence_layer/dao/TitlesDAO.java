/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.persistence_layer.dao;

import java.util.List;
import main.java.persistence_layer.dto.Titles;

/**
 *
 * @author mirac
 */
public interface TitlesDAO {
    public List<Titles> getAllTitles();
    public Titles getTitles(int id);
    public void addTitles();
    public void updateTitles();
    public void deleteTitles();
}

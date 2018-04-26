/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.persistence_layer.implementations;

import java.util.List;
import main.java.persistence_layer.ConnectionFactory;
import main.java.persistence_layer.dto.Reservation;
import main.java.persistence_layer.dao.ReservationsDAO;

/**
 *
 * @author mirac
 * @version 1.0
 */
public class ReservationDaoProd implements ReservationsDAO {
    
    List<Reservation> reservation;
    
    public ReservationDaoProd(){
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Reservation> getAllReservations(){
       
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Reservation getReservation(int id){
        
    }
    
    /**
     *
     */
    @Override
    public void addReservation(Reservation reservation){
        Reservation reserv = new Reservation();
        reserv.setDepartmentNo(0);
        reserv.setRoomNo(0);
    }
    
    /**
     *
     */
    @Override
    public void deleteReservation(Reservation reservation){
            
    }
    
    /**
     *
     */
    @Override
    public void updateReservation(Reservation reservation){
            
    }
}

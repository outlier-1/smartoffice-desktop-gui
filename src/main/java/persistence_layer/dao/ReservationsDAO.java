/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.persistence_layer.dao;

import java.util.List;
import main.java.persistence_layer.dto.Reservation;

/**
 *
 * @author mirac
 */
public interface ReservationsDAO {
    public List<Reservation> getAllReservations();
    public Reservation getReservation(int id);
    public void addReservation(Reservation reservation);
    public void updateReservation(Reservation reservation);
    public void deleteReservation(Reservation reservation);
}

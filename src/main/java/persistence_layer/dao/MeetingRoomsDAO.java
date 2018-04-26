/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.persistence_layer.dao;

import java.util.List;
import main.java.persistence_layer.dto.MeetingRooms;

/**
 *
 * @author mirac
 */
public interface MeetingRoomsDAO {
    public List<MeetingRooms> getAllMeetingRooms();
    public MeetingRooms getMeetingRoom(int no);
    public void addMeetingRooms();
    public void updateMeetingRooms();
    public void deleteMeetingRooms();
}

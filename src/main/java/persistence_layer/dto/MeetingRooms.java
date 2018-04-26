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
public class MeetingRooms {
    
    private int roomNo;
    private int departmentNo;
    
    private float temperature;
    
    private byte curtainStatus;
    
    private boolean lightStatus;
    private boolean projectionStatus;
    private boolean availability;

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(int departmentNo) {
        this.departmentNo = departmentNo;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public byte getCurtainStatus() {
        return curtainStatus;
    }

    public void setCurtainStatus(byte curtainStatus) {
        this.curtainStatus = curtainStatus;
    }

    public boolean isLightStatus() {
        return lightStatus;
    }

    public void setLightStatus(boolean lightStatus) {
        this.lightStatus = lightStatus;
    }

    public boolean isProjectionStatus() {
        return projectionStatus;
    }

    public void setProjectionStatus(boolean projectionStatus) {
        this.projectionStatus = projectionStatus;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    
}

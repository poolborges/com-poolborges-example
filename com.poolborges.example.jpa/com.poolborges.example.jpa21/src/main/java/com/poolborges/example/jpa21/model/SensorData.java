/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.jpa21.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Index;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Borges
 */
@Table(indexes = {
    @Index(columnList = "NAME")})
@Entity
public class SensorData extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String deviceID;
    private String sensorkey;
    private double sensorValue;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @ManyToOne()
    @JoinColumn(name = "device_id")
    private Device device;

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getSensorkey() {
        return sensorkey;
    }

    public void setSensorkey(String sensorkey) {
        this.sensorkey = sensorkey;
    }

    public double getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(double sensorValue) {
        this.sensorValue = sensorValue;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
    
    
}
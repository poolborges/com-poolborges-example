/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.jpa21.model;

import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.eclipse.persistence.annotations.ConversionValue;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.ObjectTypeConverter;

/**
 *
 * @author Borges
 */
@Entity
public class Device extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @OneToMany
    private Set<SensorData> sensorData;
    @ObjectTypeConverter(name = "deviceType", objectType = DeviceType.class, dataType = String.class, conversionValues = {
        @ConversionValue(objectValue = "GATEWAY", dataValue = "G"),
        @ConversionValue(objectValue = "COORDINATOR", dataValue = "C"),
        @ConversionValue(objectValue = "ROUTER", dataValue = "R"),
        @ConversionValue(objectValue = "ENDDEVICE", dataValue = "E")})
    @Basic
    @Convert("deviceType")
    private DeviceType deviceType;
    
    private String name;

    public Set<SensorData> getSensorData() {
        return sensorData;
    }

    public void setSensorData(Set<SensorData> sensorData) {
        this.sensorData = sensorData;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{ID:"+super.id + ", NAME:'"+ name+ "', TYPE:'" +deviceType +"'}";
    }
    
    
}
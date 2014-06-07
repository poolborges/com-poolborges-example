package com.poolborges.example.springjpa.employee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Borges
 */
@Entity
public class Employee extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;
    
    @Column(length = 30)
    private String name;
    @Column(length = 30)
    private String type;
    @Column(length = 30)
    private String emis;
    @Column(length = 15)
    private String telephone;
    @Column(length = 15)
    private String fax;
    private String address;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the emis
     */
    public String getEmis() {
        return emis;
    }

    /**
     * @param emis the emis to set
     */
    public void setEmis(String emis) {
        this.emis = emis;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + getId() + ", name=" + name + ", type=" + type + ", emis=" + emis + ", telephone=" + telephone + ", fax=" + fax + ", address=" + address + '}';
    }
}

package com.mkyong.model;

import java.util.Date;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

@PersistenceCapable
public class Customer {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Column(name="customer_id")
    private Long key;
    
    @Persistent
    @Column(name="customer_name", jdbcType="VARCHAR", length=50, allowsNull="false")
    private String name;
    
    @Persistent
    @Column(name="customer_email", jdbcType="VARCHAR")
    @Unique(name="customer_email_unique")
    private String email;
    
    @Persistent
    @Column(name="customer_date")
    private Date date;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer() {
        super();
    }

    @Override
    public String toString() {
        return this.key + " " + this.name + " " +this.email + " " + this.date;
    }
    
    
}
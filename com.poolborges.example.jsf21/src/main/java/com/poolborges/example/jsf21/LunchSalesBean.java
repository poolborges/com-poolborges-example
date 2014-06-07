/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.jsf21;

/**
 *
 * @author Borges
 */
public class LunchSalesBean {

    private String dishName;
    private int salesPercentage;

    public LunchSalesBean() {
    }

    public LunchSalesBean(String dishName, int salesPercentage) {
        this.dishName = dishName;
        this.salesPercentage = salesPercentage;
    }

    /**
     * @return the dishName
     */
    public String getDishName() {
        return dishName;
    }

    /**
     * @param dishName the dishName to set
     */
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    /**
     * @return the salesPercentage
     */
    public int getSalesPercentage() {
        return salesPercentage;
    }

    /**
     * @param salesPercentage the salesPercentage to set
     */
    public void setSalesPercentage(int salesPercentage) {
        this.salesPercentage = salesPercentage;
    }
}

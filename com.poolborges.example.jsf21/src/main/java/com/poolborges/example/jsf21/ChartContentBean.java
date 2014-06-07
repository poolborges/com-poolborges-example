package com.poolborges.example.jsf21;

public class ChartContentBean {

    private int year;
    private int passPercentage;
    private int failedPercentage;

    public ChartContentBean() {
    }

    public ChartContentBean(int year, int passPercentage, int failedPercentage) {
        this.year = year;
        this.passPercentage = passPercentage;
        this.failedPercentage = failedPercentage;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the passPercentage
     */
    public int getPassPercentage() {
        return passPercentage;
    }

    /**
     * @param passPercentage the passPercentage to set
     */
    public void setPassPercentage(int passPercentage) {
        this.passPercentage = passPercentage;
    }

    /**
     * @return the failedPercentage
     */
    public int getFailedPercentage() {
        return failedPercentage;
    }

    /**
     * @param failedPercentage the failedPercentage to set
     */
    public void setFailedPercentage(int failedPercentage) {
        this.failedPercentage = failedPercentage;
    }
}

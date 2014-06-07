package com.poolborges.example.jsf21;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean
public class ChartBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private CartesianChartModel categoryModel;
    private CartesianChartModel linearModel;
    private CartesianChartModel energyModel;

    public ChartBean() {
        
        createCategoryModel();
        createLinearModel();
        createEnergyModel();
    }

    public CartesianChartModel getCategoryModel() {
        return categoryModel;
    }

    public CartesianChartModel getLinearModel() {
        return linearModel;
    }

    public CartesianChartModel getEnergyModel() {
        return energyModel;
    }

    private void createCategoryModel() {
        categoryModel = new CartesianChartModel();

        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");

        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);

        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");

        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 135);
        girls.set("2008", 120);

        categoryModel.addSeries(boys);
        categoryModel.addSeries(girls);
    }

    private void createEnergyModel() {
        energyModel = new CartesianChartModel();

        ChartSeries year1 = new ChartSeries();
        year1.setLabel("Consumo SA");

        year1.set("2004", 120);
        year1.set("2005", 100);
        year1.set("2006", 44);
        year1.set("2007", 150);
        year1.set("2008", 25);

        ChartSeries year2 = new ChartSeries();
        year2.setLabel("Consumo DM");

        year2.set("2004", 52);
        year2.set("2005", 60);
        year2.set("2006", 110);
        year2.set("2007", 135);
        year2.set("2008", 120);

        energyModel.addSeries(year1);
        energyModel.addSeries(year2);
    }

    private void createLinearModel() {
        linearModel = new CartesianChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");

        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
        series2.setMarkerStyle("diamond");

        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);

        linearModel.addSeries(series1);
        linearModel.addSeries(series2);
    }
}

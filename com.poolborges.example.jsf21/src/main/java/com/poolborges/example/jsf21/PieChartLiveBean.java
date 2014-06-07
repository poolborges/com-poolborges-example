package com.poolborges.example.jsf21;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Borges
 */
@ManagedBean(name = "PieChartLiveBean")
@SessionScoped
public class PieChartLiveBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private PieChartModel livePieModel;

    public PieChartLiveBean() {
        createLivePieModel();
    }

    public PieChartModel getLivePieModel() {
        livePieModel.getData().put("Barak Obama", (int) (Math.random() * 100));
        livePieModel.getData().put("Carlos Veiga", (int) (Math.random() * 100));
        return livePieModel;
    }

    private void createLivePieModel() {
        livePieModel = new PieChartModel();
        
        livePieModel.set("Carlos Veiga", 75);
        livePieModel.set("Barak Obama", 65);
        livePieModel.set("Socrates", 56);
        livePieModel.set("Cavaco Silva", 45);
        livePieModel.set("Mario Soares", 37);
        livePieModel.set("Salazar", 53);
        livePieModel.set("Gustavo", 23);
        livePieModel.set("Lubrano", 53);
    }
}

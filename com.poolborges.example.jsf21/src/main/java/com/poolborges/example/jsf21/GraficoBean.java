package com.poolborges.example.jsf21;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Borges
 */
@ManagedBean
public class GraficoBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private PieChartModel modelo;

    public GraficoBean() {
        criarModeloGrafico();
    }

    public PieChartModel getModelo() {
        return modelo;
    }

    public void setModelo(PieChartModel modelo) {
        this.modelo = modelo;
    }

    private void criarModeloGrafico() {
        
        modelo = new PieChartModel();
        
        List<Time> listaTime = new ArrayList<Time>();
        
        TimeDAO timeDAo = new TimeDAO();
        
        listaTime = timeDAo.listaTodos();
        
        for (Time time : listaTime) {
            modelo.set(time.getNomeTime(), time.getProbabilidade());
        }
    }
}

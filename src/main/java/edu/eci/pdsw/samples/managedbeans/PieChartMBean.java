/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.PieChartData;
import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Andres
 */
@ManagedBean(name="chartPie")
@ViewScoped
public class PieChartMBean {
    private String pieChartXgrupos;
    private List<KeyValue> pieDataListGrupo;
    private PieChartData pieXCurso;
    private String pieChartXCurso;
    private List<KeyValue> pieDataListCurso;
    private PieChartData pieXGrupo;
    public PieChartMBean() throws ExcepcionSistemaMonitores{
        pieXGrupo = new PieChartData();
        pieXCurso = new PieChartData();
        pieDataListGrupo = pieXGrupo.pieDataListDetallesXgrupo;
        pieDataListCurso = pieXGrupo.pieDataListDetallesXcurso;
        populateDataGrupo();
        populateDataCurso();
    
    }
    
  
    private void populateDataGrupo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (KeyValue pieData : pieDataListGrupo) {
            stringBuilder.append("[");
            stringBuilder.append("'");
            stringBuilder.append(pieData.getKey());
            stringBuilder.append("'");
            stringBuilder.append(",");
            stringBuilder.append(pieData.getValue());
            stringBuilder.append("]");
            stringBuilder.append(",");
        }
        pieChartXgrupos = stringBuilder.toString().substring(0,
        stringBuilder.toString().length() - 1);
    }
    private void populateDataCurso() {
        StringBuilder stringBuilder = new StringBuilder();
        for (KeyValue pieData : pieDataListCurso) {
            stringBuilder.append("[");
            stringBuilder.append("'");
            stringBuilder.append(pieData.getKey());
            stringBuilder.append("'");
            stringBuilder.append(",");
            stringBuilder.append(pieData.getValue());
            stringBuilder.append("]");
            stringBuilder.append(",");
        }
        pieChartXCurso = stringBuilder.toString().substring(0,
        stringBuilder.toString().length() - 1);
    }
    public String getPieChartXgrupos() {
        return pieChartXgrupos;
    }

    public void setPieChartXgrupos(String pieChartXgrupos) {
        this.pieChartXgrupos = pieChartXgrupos;
    }

    public List<KeyValue> getPieDataListGrupo() {
        return pieDataListGrupo;
    }

    public void setPieDataListGrupo(List<KeyValue> pieDataListGrupo) {
        this.pieDataListGrupo = pieDataListGrupo;
    }

    public PieChartData getPieXGrupo() {
        return pieXGrupo;
    }

    public void setPieXGrupo(PieChartData pieXGrupo) {
        this.pieXGrupo = pieXGrupo;
    }

    public PieChartData getPieXCurso() {
        return pieXCurso;
    }

    public void setPieXCurso(PieChartData pieXCurso) {
        this.pieXCurso = pieXCurso;
    }

    public String getPieChartXCurso() {
        return pieChartXCurso;
    }

    public void setPieChartXCurso(String pieChartXCurso) {
        this.pieChartXCurso = pieChartXCurso;
    }

    public List<KeyValue> getPieDataListCurso() {
        return pieDataListCurso;
    }

    public void setPieDataListCurso(List<KeyValue> pieDataListCurso) {
        this.pieDataListCurso = pieDataListCurso;
    }
    

    
    
    
    
}

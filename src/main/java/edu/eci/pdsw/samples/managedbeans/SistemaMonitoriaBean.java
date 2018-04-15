/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author sergiort
 */
@ManagedBean(name = "SistemaMonitoria")
@SessionScoped
public class SistemaMonitoriaBean {
    
    private String[] selectedFiltro;
    private List<String> opcionesFiltro;
    
    public SistemaMonitoriaBean(){
        opcionesFiltro = new ArrayList<>();
        opcionesFiltro.add("Fecha");
        opcionesFiltro.add("Carnet");
        opcionesFiltro.add("Tema");
        opcionesFiltro.add("Profesor");
        opcionesFiltro.add("Materia");
        opcionesFiltro.add("Grupo");
    }

    public String[] getSelectedFiltro() {
        return selectedFiltro;
    }

    public void setSelectedFiltro(String[] selectedFiltro) {
        this.selectedFiltro = selectedFiltro;
    }

    public List<String> getOpcionesFiltro() {
        return opcionesFiltro;
    }

    public void setOpcionesFiltro(List<String> opcionesFiltro) {
        this.opcionesFiltro = opcionesFiltro;
    }
    
    
    
}

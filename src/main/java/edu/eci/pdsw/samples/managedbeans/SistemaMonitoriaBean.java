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
<<<<<<< 6e7a7e556f54b1c1d8df950ede961211f3ce7023
<<<<<<< 75eadc78db1addc329c8c2fbde3e194ea3a98611
    private List<String> optionsFiltro;
    private List<String> selectedOptions;
    
    public SistemaMonitoriaBean(){
        optionsFiltro = new ArrayList<>();
        optionsFiltro.add("Fecha");
        optionsFiltro.add("Carnet");
        optionsFiltro.add("Tema");
        optionsFiltro.add("Profesor");
        optionsFiltro.add("Materia");
        optionsFiltro.add("Grupo");
=======
    private List<String> opcionesFiltro;
    
    public SistemaMonitoriaBean(){
        opcionesFiltro = new ArrayList<>();
        opcionesFiltro.add("Fecha");
        opcionesFiltro.add("Carnet");
        opcionesFiltro.add("Tema");
        opcionesFiltro.add("Profesor");
        opcionesFiltro.add("Materia");
        opcionesFiltro.add("Grupo");
>>>>>>> Base GUI consulta
=======
    private List<String> optionsFiltro;
    private List<String> selectedOptions;
    
    public SistemaMonitoriaBean(){
        optionsFiltro = new ArrayList<>();
        optionsFiltro.add("Fecha");
        optionsFiltro.add("Carnet");
        optionsFiltro.add("Tema");
        optionsFiltro.add("Profesor");
        optionsFiltro.add("Materia");
        optionsFiltro.add("Grupo");
>>>>>>> Adicion filtro consulta GUI
    }

    public String[] getSelectedFiltro() {
        return selectedFiltro;
    }

    public void setSelectedFiltro(String[] selectedFiltro) {
        this.selectedFiltro = selectedFiltro;
    }

<<<<<<< 6e7a7e556f54b1c1d8df950ede961211f3ce7023
<<<<<<< 75eadc78db1addc329c8c2fbde3e194ea3a98611
    public List<String> getOptionsFiltro() {
        return optionsFiltro;
    }

    public void setOptionsFiltro(List<String> optionsFiltro) {
        this.optionsFiltro = optionsFiltro;
    }

    public List<String> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(List<String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }
    
=======
    public List<String> getOpcionesFiltro() {
        return opcionesFiltro;
=======
    public List<String> getOptionsFiltro() {
        return optionsFiltro;
>>>>>>> Adicion filtro consulta GUI
    }

    public void setOptionsFiltro(List<String> optionsFiltro) {
        this.optionsFiltro = optionsFiltro;
    }
<<<<<<< 6e7a7e556f54b1c1d8df950ede961211f3ce7023
>>>>>>> Base GUI consulta
=======

    public List<String> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(List<String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }
    
>>>>>>> Adicion filtro consulta GUI
    
    
    
}

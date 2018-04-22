/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Asesoria;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author sergiort
 */
@ManagedBean(name = "InformacionAsesorias")
@SessionScoped
public class ConsultaInformacionAsesoriasBean {
    
    private String[] selectedFiltro;
    private List<String> optionsFiltro;
    private List<String> selectedOptions;
    private List<Asesoria> asesorias;
    
    public ConsultaInformacionAsesoriasBean(){
        optionsFiltro = new ArrayList<>();
        optionsFiltro.add("Materia");
        optionsFiltro.add("Grupo");
        optionsFiltro.add("Franja horaria");
        optionsFiltro.add("Tema");
        optionsFiltro.add("Número de asitentes");
    }

    public String[] getSelectedFiltro() {
        return selectedFiltro;
    }

    public void setSelectedFiltro(String[] selectedFiltro) {
        this.selectedFiltro = selectedFiltro;
    }

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

    public List<Asesoria> getAsesorias() {
        return asesorias;
    }

    public void setAsesorias(List<Asesoria> asesorias) {
        this.asesorias = asesorias;
    }
    
    
}

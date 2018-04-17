/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Asesoria;
import edu.eci.pdsw.samples.entities.Registro;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private List<String> optionsFiltro;
    private List<String> selectedOptions;
    private List<Asesoria> asesorias;
    private List<Registro> registros;
    private String Materia;
    private String Fecha;
    
    public SistemaMonitoriaBean(){
        registros=new ArrayList<>();
        optionsFiltro = new ArrayList<>();
        optionsFiltro.add("Monitor");
        optionsFiltro.add("Carnet");
        optionsFiltro.add("Tema");
        optionsFiltro.add("Profesor");
        optionsFiltro.add("Materia");
        optionsFiltro.add("Grupo");
        optionsFiltro.add("Fecha");
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String Materia) {
        this.Materia = Materia;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    public void filtrar(){
        Logger.getLogger(SistemaMonitoriaBean.class.getName()).log(Level.SEVERE,"Filtro:"+Arrays.toString(selectedFiltro) + "\nArgumentos:"+selectedOptions.toString());     
    }
    public String[] getSelectedFiltro(){
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
    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
    public void guardarRegistro(){
        registros.add(new Registro(Fecha, Materia));
        
      
        
    }
    
    public void mirarRegistros(){
         Logger.getLogger(SistemaMonitoriaBean.class.getName()).log(Level.SEVERE,"Filtro:"+registros+ "\nArgumentos:"+selectedOptions.toString());     
        
        
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Registro;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2135494
 */
@ManagedBean(name = "MonitorMonitoria")
@SessionScoped
public class MonitorBean {
    private String Materia;
    private String Fecha;
    private List<Registro> registros;
    private String codigoEstudiante;
    private String profesor;
    private String Observaciones;
    public MonitorBean(){
        registros = new ArrayList();
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String materia) {
        this.Materia = materia;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        this.Fecha = fecha;
    }
     public void guardarRegistro(){
        registros.add(new Registro(Fecha,Materia));

    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }
     
    
    
}

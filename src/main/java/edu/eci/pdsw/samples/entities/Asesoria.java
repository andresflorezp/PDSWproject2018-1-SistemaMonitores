/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.util.Date;
import java.util.List;

/**
 *
 * @author sergiort
 */
public class Asesoria {

    private String profesor;
    private String observaciones;
    private String monitor;
    private String materia;
    private Date fecha;
    private int grupo;
    private List<Integer> carnetAsistentes;
    private List<String> tema;

    public Asesoria(Date fecha, List<String> tema, String profesor,String monitor, String observaciones) {
        this.observaciones = observaciones;
        this.fecha = fecha;
        this.profesor = profesor;
        this.monitor = monitor;
        this.tema = tema;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<String> getTema() {
        return tema;
    }

    public void setTema(List<String> tema) {
        this.tema = tema;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public List<Integer> getCarnetAsistentes() {
        return carnetAsistentes;
    }

    public void setCarnetAsistentes(List<Integer> carnetAsistentes) {
        this.carnetAsistentes = carnetAsistentes;
    }  

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }
    
}

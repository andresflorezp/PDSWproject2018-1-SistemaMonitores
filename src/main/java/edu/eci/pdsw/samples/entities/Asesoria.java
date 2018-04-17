/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.util.Date;

/**
 *
 * @author sergiort
 */
public class Asesoria {

    private Date fecha;
    private String tema;
    private String profesor;
    private String descripcion;
    private String monitor;
    private String materia;
    private int grupo;
    private int carnetAsistente;

    public Asesoria(Date fecha, String tema, String profesor,String monitor, String descripcion) {
        this.descripcion = descripcion;
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

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public int getCarnetAsistente() {
        return carnetAsistente;
    }

    public void setCarnetAsistente(int carnetAsistente) {
        this.carnetAsistente = carnetAsistente;
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

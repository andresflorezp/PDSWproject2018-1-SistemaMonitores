/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sergiort
 */
public class Asesoria implements Serializable{
    
    private int asesoriaID;
    private Grupo grupo;
    private List<Tema> temas;
    private List<Estudiante> asistentes;
    private Date fecha;
    private String observaciones;

    public Asesoria(int asesoriaID, Grupo grupo, Date fecha, List<Tema> tema, List<Estudiante> asistentes, String observaciones) {
        this.asesoriaID = asesoriaID;
        this.grupo = grupo;
        this.temas = temas;
        this.asistentes = asistentes;
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    public int getAsesoriaID() {
        return asesoriaID;
    }

    public void setAsesoriaID(int asesoriaID) {
        this.asesoriaID = asesoriaID;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    public List<Estudiante> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(List<Estudiante> asistentes) {
        this.asistentes = asistentes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}

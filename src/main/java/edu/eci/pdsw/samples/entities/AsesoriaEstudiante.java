/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sergiort
 */
public class AsesoriaEstudiante implements Serializable{
    
    private int asesoriaID;
    private int estudianteID;
    private Estudiante asistente;
    private List<Tema> temas;
    private String observaciones;

    @Override
    public String toString() {
        return asistente+ " Temas: "+temas.toString()+" obsevaciones "+observaciones;
    }
    
    public AsesoriaEstudiante() {
    }

    public int getAsesoriaID() {
        return asesoriaID;
    }

    public void setAsesoriaID(int asesoriaID) {
        this.asesoriaID = asesoriaID;
    }

    public int getEstudianteID() {
        return estudianteID;
    }

    public void setEstudianteID(int estudianteID) {
        this.estudianteID = estudianteID;
    }
    
    

    public Estudiante getAsistente() {
        return asistente;
    }

    public void setAsistente(Estudiante asistente) {
        this.asistente = asistente;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}

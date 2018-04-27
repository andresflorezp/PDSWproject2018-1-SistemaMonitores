/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.io.Serializable;

/**
 *
 * @author sergiort
 */
public class Grupo implements Serializable{
    private String horarioMonitor;
    private int grupoID;
    private int grupoNombre;
    private int numeroDeEstudiantes;
    private Monitor monitor;
    private Materia materia;
    private Profesor profesor;
    private Semestre semestre;
    
    public Grupo(){
    }
    
    public Semestre getSemestre() {
        return semestre;
    }

    public String getHorarioMonitor() {
        return horarioMonitor;
    }

    public void setHorarioMonitor(String horarioMonitor) {
        this.horarioMonitor = horarioMonitor;
    }
    
    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public int getGrupoID() {
        return grupoID;
    }

    public void setGrupoID(int grupoID) {
        this.grupoID = grupoID;
    }
    
    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    public int getGrupoNombre() {
        return grupoNombre;
    }

    public void setGrupoNombre(int grupoNombre) {
        this.grupoNombre = grupoNombre;
    }

    public int getNumeroDeEstudiantes() {
        return numeroDeEstudiantes;
    }

    public void setNumeroDeEstudiantes(int numeroDeEstudiantes) {
        this.numeroDeEstudiantes = numeroDeEstudiantes;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    
}

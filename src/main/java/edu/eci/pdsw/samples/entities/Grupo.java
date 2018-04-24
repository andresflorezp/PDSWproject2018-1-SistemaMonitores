/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

/**
 *
 * @author sergiort
 */
public class Grupo {
//    private String horarioMonitor;
    private int grupoNombre;
    private int numeroDeEstudiantes;
    private Monitor monitor;
    private Materia materia;

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

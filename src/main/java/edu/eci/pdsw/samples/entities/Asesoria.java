/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author sergiort
 */
public class Asesoria implements Serializable {

    private int asesoriaID;
    private Grupo grupo;
    private List<AsesoriaEstudiante> asesoriasEstudiante;
    private Date fecha;
    private Set<Tema> temas;
    public Asesoria() {
    }

    public Asesoria(int asesoriaID, Grupo grupo, Date fecha, List<AsesoriaEstudiante> asesoriasEstudiante) {
        this.asesoriaID = asesoriaID;
        this.grupo = grupo;
        this.asesoriasEstudiante = asesoriasEstudiante;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Materia: " + grupo.getMateria().getNombre() + " Grupo: " + grupo.getGrupoNombre() + " Asesoria por Estudiante " + asesoriasEstudiante.toString();
    }

    public Set<Tema> getTemas() {
        temas = new HashSet();
        for (AsesoriaEstudiante aEstudiante : asesoriasEstudiante) {
            for (Tema tema : aEstudiante.getTemas()) {
                temas.add(tema);
            }
        }
        return temas;
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

    public List<AsesoriaEstudiante> getAsesoriasEstudiante() {
        return asesoriasEstudiante;
    }

    public void setAsesoriasEstudiante(List<AsesoriaEstudiante> asesoriasEstudiante) {
        this.asesoriasEstudiante = asesoriasEstudiante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}

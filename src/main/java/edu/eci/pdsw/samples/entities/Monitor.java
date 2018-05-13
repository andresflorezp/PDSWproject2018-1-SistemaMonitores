/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;

/**
 *
 * @author sergiort
 */
public class Monitor extends Persona implements Comparable<Monitor>{

    private int semestreIngreso;
    private int programaAcademico;
    private List<Grupo> grupos;//No va

    public Monitor() {
    }

    public Monitor(int codigoID, String nombre, String apellido, String correo, long telefono, int semestreIngreso, int programaAcademico) {
        super(codigoID, nombre, apellido, correo, telefono);
        this.programaAcademico = programaAcademico;
        this.semestreIngreso = semestreIngreso;
        grupos = new ArrayList<>();

    }

    public void addGrupo(Grupo g) throws Exception {
        if (grupos.size() < 2) {
            grupos.add(g);
        } else {
            throw new ExcepcionSistemaMonitores("no se puede adicionar mas de dos grupos a un monitor");
        }

    }

    @Override
    public String toString() {
        return getApellido()+" "+getNombre();
    }

    @Override
    public int compareTo(Monitor o) {
        return this.toString().compareTo(o.toString());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;

/**
 *
 * @author sergiort
 */
public class Monitor extends Persona implements Comparable<Monitor>, Serializable{

    private String semestreIngreso;
    private int programaAcademico;

    public Monitor() {
    }

    public Monitor(int codigoID, String nombre, String apellido, String correo, long telefono, String semestreIngreso, int programaAcademico) {
        super(codigoID, nombre, apellido, correo, telefono);
        this.programaAcademico = programaAcademico;
        this.semestreIngreso = semestreIngreso;

    }

    @Override
    public String toString() {
        return getApellido()+" "+getNombre();
    }

    @Override
    public int compareTo(Monitor o) {
        return this.toString().compareTo(o.toString());
    }

    public String getSemestreIngreso() {
        return semestreIngreso;
    }

    public void setSemestreIngreso(String semestreIngreso) {
        this.semestreIngreso = semestreIngreso;
    }

    public int getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(int programaAcademico) {
        this.programaAcademico = programaAcademico;
    }
    
    
}

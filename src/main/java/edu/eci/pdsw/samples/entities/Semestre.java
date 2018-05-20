/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author sergiort
 */
public class Semestre implements Serializable{
    private int semestreID;
    private int anno;
    private int periodoAcademico;
    private Date fechaInicio;
    private Date fechaFin;
    
    public Semestre(){
    }

    public int getSemestreID() {
        return semestreID;
    }

    public void setSemestreID(int semestreID) {
        this.semestreID = semestreID;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getPeriodoAcademico() {
        return periodoAcademico;
    }

    public void setPeriodoAcademico(int periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}

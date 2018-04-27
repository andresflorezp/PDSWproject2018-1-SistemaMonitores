/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.io.Serializable;


/**
 *
 * @author Andres
 */

public class Registro implements Serializable{
    private String Fecha;
    private String Materia;
    
    public Registro(String Fecha,String Materia){
        this.Fecha=Fecha;
        this.Materia=Materia;
        
    }
    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String Materia) {
        this.Materia = Materia;
    }

}

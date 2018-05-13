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
    private String fecha;
    private String materia;
    
    public Registro(){
    }
    
    public Registro(String fecha,String materia){
        this.fecha=fecha;
        this.materia=materia;
        
    }
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String Fecha) {
        this.fecha = Fecha;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String Materia) {
        this.materia = Materia;
    }

}

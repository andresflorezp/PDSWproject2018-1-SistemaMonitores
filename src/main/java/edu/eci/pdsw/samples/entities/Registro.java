/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;


/**
 *
 * @author Andres
 */

public class Registro{
    public String Fecha;
    public String Materia;
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

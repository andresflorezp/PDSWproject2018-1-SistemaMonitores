/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import static java.lang.String.format;


/**
 *
 * @author sergiort
 */
public class Estudiante implements Serializable{
    private long carnet;
    private String nombre;
    private int grupo;
    
    public Estudiante(){
    }
    
    public Estudiante(int carnet,String nombre, int grupo) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.grupo = grupo;
        
    }

    @Override
    public String toString() {
        return format("%s %d", nombre,carnet);
    }
    
    public long getCarnet() {
        return carnet;
    }

    public void setCarnet(long carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }
    
}

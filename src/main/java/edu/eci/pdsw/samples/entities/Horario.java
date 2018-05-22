/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafaeljimenez
 */
public class Horario {
    private List<String> hora;
    private List<String> lunes;
    private List<String> martes;
    private List<String> miercoles;
    private List<String> jueves;
    private List<String> viernes;
    private List<String> sabado;
    private Materia materia;
    private Integer horarioID;
    private String descripcion;
    
    public Horario(Integer horariID, String descripcion, Materia materia) {
        this.horarioID = horariID;
        this.descripcion = descripcion;
        this.materia = materia;
    }
    
    public Horario(){
    }
    
    public void horarioData(String hora, String lunes, String martes, String miercoles, String jueves, String viernes, String sabado) {
        this.hora.add(hora);
        this.lunes.add(lunes);
        this.martes.add(martes);
        this.miercoles.add(miercoles);
        this.jueves.add(jueves);
        this.viernes.add(viernes);
        this.sabado.add(sabado);
    }

    public Integer getHorariID() {
        return horarioID;
    }

    public void setHorariID(Integer horariID) {
        this.horarioID = horariID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    public String getMateriaName(){
       return materia.getNombre();
    }

    public List<String> getLunes() {
        return lunes;
    }

    public void setLunes(ArrayList<String> lunes) {
        this.lunes = lunes;
    }

    public List<String> getMartes() {
        return martes;
    }

    public void setMartes(ArrayList<String> martes) {
        this.martes = martes;
    }

    public List<String> getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(ArrayList<String> miercoles) {
        this.miercoles = miercoles;
    }

    public List<String> getJueves() {
        return jueves;
    }

    public void setJueves(ArrayList<String> jueves) {
        this.jueves = jueves;
    }

    public List<String> getViernes() {
        return viernes;
    }

    public void setViernes(ArrayList<String> viernes) {
        this.viernes = viernes;
    }

    public List<String> getSabado() {
        return sabado;
    }

    public void setSabado(ArrayList<String> sabado) {
        this.sabado = sabado;
    }
    
    

    public List<String> getHora() {
        return hora;
    }

    public void setHora(ArrayList<String> hora) {
        this.hora = hora;
    }
}

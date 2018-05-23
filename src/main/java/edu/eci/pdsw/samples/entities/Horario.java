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
    private String hora;
    private String salon;
    private String curso;
    private String lunes;
    private String martes;
    private String miercoles;
    private String jueves;
    private String viernes;
    private String sabado;
    private Materia materia;
    private Integer horarioID;
    private String descripcion;
    
    public Horario(Integer horariID, String descripcion, Materia materia) {
        this.horarioID = horariID;
        this.descripcion = descripcion;
        this.materia = materia;
    }
    
    public Horario(String hora, String lunes, String martes, String miercoles, String jueves, String viernes, String sabado, String Materia) {
        this.hora = hora;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
    }
    
    public Horario(){
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }

    public String getSabado() {
        return sabado;
    }

    public void setSabado(String sabado) {
        this.sabado = sabado;
    }

    public Integer getHorarioID() {
        return horarioID;
    }

    public void setHorarioID(Integer horarioID) {
        this.horarioID = horarioID;
    }

  
}

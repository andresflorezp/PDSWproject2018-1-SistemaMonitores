/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Materia;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Tatiana
 */

@ManagedBean(name = "RegistroAsistencia")
@SessionScoped
public class RegistrarAsistEstudianteBean {
    private String codigo;
    private String profesor;
    private String obseraciones;
    private Materia materia;
    private List<String> profesoresSelected;
    private List<String> temas;
    private List<String> profesores;
    
    public RegistrarAsistEstudianteBean(){
        temas = new ArrayList<>();
        temas.add("Tema1");
        temas.add("Tema2");
        temas.add("Tema3");
        profesores = new ArrayList<>();
        profesores.add("Francisco");
        profesores.add("Pedro");
        profesoresSelected = new ArrayList<>();
        
    }

    public List<String> getProfesoresSelected() {
        return profesoresSelected;
    }

    public void setProfesoresSelected(List<String> profesoresSelected) {
        this.profesoresSelected = profesoresSelected;
    }

    public List<String> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<String> profesores) {
        this.profesores = profesores;
    }
    
    public List<String> getTemas() {
        return temas;
    }

    public void setTemas(List<String> temas) {
        this.temas = temas;
    }

    public Materia getMtria() {
        return materia;
    }

    public void setMtria(Materia materia) {
        this.materia = materia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getObseraciones() {
        return obseraciones;
    }

    public void setObseraciones(String obseraciones) {
        this.obseraciones = obseraciones;
    }
    
    public List<String> getPlanEstudios(){
        return materia.getPlanEstudios();
    }
}

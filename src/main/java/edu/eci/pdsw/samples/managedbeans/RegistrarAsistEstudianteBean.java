/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Materia;
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
    private Materia mtria;
    private String opcionesTemas;
    private String temas;

    public String getTemas() {
        return temas;
    }

    public void setTemas(String temas) {
        this.temas = temas;
    }

    public Materia getMtria() {
        return mtria;
    }

    public void setMtria(Materia mtria) {
        this.mtria = mtria;
    }

    public String getOpcionesTemas() {
        return opcionesTemas;
    }

    public void setOpcionesTemas(String opcionesTemas) {
        this.opcionesTemas = opcionesTemas;
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
        return mtria.getPlanEstudios();
    }
}

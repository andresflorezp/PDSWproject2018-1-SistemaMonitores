/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Grupo;
import edu.eci.pdsw.samples.entities.Materia;
import edu.eci.pdsw.samples.entities.Tema;
import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitoresFactory;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Tatiana
 */
@ManagedBean(name = "RegistroAsistencia")
@SessionScoped
public class RegistrarAsistEstudianteBean implements Serializable {

    ServiciosSistemaMonitores sp = ServiciosSistemaMonitoresFactory.getInstance().getServiciosSistemaMonitores();

    private int codigo;
    private String profesor;
    private String obseraciones;
    private Materia materia;
    private List<String> profesoresSelected;
    private AbstractSet<String> profesores;
    private AbstractSet<String> temas;
    private List<String> temasSelected;
    private List<Grupo> gruposMateriaSemestre;
    private Estudiante asistente;

    public RegistrarAsistEstudianteBean() throws ExcepcionSistemaMonitores {
        profesoresSelected = new ArrayList<>();
        consultarGrupos();
    }
    
    public void agregarAsesoria() throws ExcepcionSistemaMonitores{
        asistente = sp.consultaEstudiante(codigo);
//        sp.addAsesoria();
    }

    public void consultarGrupos() throws ExcepcionSistemaMonitores {
        temas = new HashSet<>();
        profesores = new HashSet<>();
        gruposMateriaSemestre = sp.consultaGruposMateria(0, 1);
        for (Grupo g : gruposMateriaSemestre) {
            profesores.add(g.getProfesor().getNombre());
        }
        for (Tema t : gruposMateriaSemestre.get(0).getMateria().getTemas()) {
            temas.add(t.getTopic());
        }
    }
    
    public List<String> getTemasSelected() {
        return temasSelected;
    }

    public void setTemasSelected(List<String> temasSelected) {
        this.temasSelected = temasSelected;
    }

    public List<String> getProfesoresSelected() {
        return profesoresSelected;
    }

    public void setProfesoresSelected(List<String> profesoresSelected) {
        this.profesoresSelected = profesoresSelected;
    }

    public AbstractSet<String> getProfesores() {
        return profesores;
    }

    public void setProfesores(AbstractSet<String> profesores) {
        this.profesores = profesores;
    }

    public AbstractSet<String> getTemas() {
        return temas;
    }

    public void setTemas(AbstractSet<String> temas) {
        this.temas = temas;
    }

    public Materia getMtria() {
        return materia;
    }

    public void setMtria(Materia materia) {
        this.materia = materia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

}

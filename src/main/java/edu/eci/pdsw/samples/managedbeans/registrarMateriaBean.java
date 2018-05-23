/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Asesoria;
import edu.eci.pdsw.samples.entities.Materia;
import edu.eci.pdsw.samples.entities.Tema;
import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitores;
import static edu.eci.pdsw.samples.services.ServiciosSistemaMonitoresFactory.getInstance;
import java.io.Serializable;
import static java.lang.String.valueOf;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author rafaeljimenez
 */
@ManagedBean(name = "registrarMateria")
@SessionScoped

public class registrarMateriaBean implements Serializable {

    ServiciosSistemaMonitores sp = getInstance().getServiciosSistemaMonitores();

    private String nombre;
    private String nemotecnico;
    private String nemotecnicoTema;
    private String tema;
    private String descripcionTema;
    private Integer creditos;
    private Integer horas;
    private List<Materia> materias;
    private Materia materiaActual;

    public registrarMateriaBean() throws ExcepcionSistemaMonitores {
        consultar();
    }

    public void registrarMateria() throws ExcepcionSistemaMonitores {
        nemotecnicoTema = nemotecnico;
        sp.addMateria(nombre, nemotecnico, creditos, horas);
        save("Materia Registrada.");
    }

    public void registrarTema() throws ExcepcionSistemaMonitores {
        try {
            materiaActual = sp.consultaMateriaActualRegistro(nemotecnicoTema);
        } catch (ExcepcionSistemaMonitores ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No encontrado",ex.getMessage()));
        }
        sp.addTema(materiaActual.getMateriaID(), tema, descripcionTema);
        save("Tema Registrado.");
    }

    public void limpiar() {
        nombre = null;
        nemotecnico = null;
        creditos = null;
        horas = null;
    }
    
    public void limpiarTema() {
        nemotecnicoTema = null;
        tema = null;
        descripcionTema = null;
    }

    public void onCellEdit(CellEditEvent event) throws ExcepcionSistemaMonitores {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            Materia materiaUpdate = materias.get(event.getRowIndex());
            sp.actualizarMateria(materiaUpdate);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Celda Cambiada", "Antiguo: " + oldValue + ", Nueva:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Tema seleccionado", "Para: "+((Materia) event.getObject()).getMemoico());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEditTema(CellEditEvent event) throws ExcepcionSistemaMonitores {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            Tema temaUpdate = materiaActual.getTemas().get(event.getRowIndex());
            sp.actualizarTema(temaUpdate);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Celda Cambiada", "Antiguo: " + oldValue + ", Nueva:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void consultar() throws ExcepcionSistemaMonitores {
        materias = sp.consulatarMaterias();
    }

    public void consultarTemas() throws ExcepcionSistemaMonitores {
        materiaActual.setTemas(sp.consulatarTemas(materiaActual.getMateriaID()));
    }

    public void delete(String id) throws ExcepcionSistemaMonitores {
        sp.deleteMateria(id);
        FacesContext.getCurrentInstance().addMessage("messagesTable", new FacesMessage("Registro Eliminado de Materia " + id + "."));
        consultar();
    }
    
    public void deleteTema(Integer id) throws ExcepcionSistemaMonitores {
        sp.deleteTema(id);
        FacesContext.getCurrentInstance().addMessage("messagesTableTema", new FacesMessage("Registro Eliminado de Tema " + id + "."));
        consultar();
    }

    public void save(String text) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(text));
    }

    public Integer getCreditos() {
        return creditos;
    }

    public Integer getHoras() {
        return horas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNemotecnico() {
        return nemotecnico;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNemotecnico(String nemotecnico) {
        this.nemotecnico = nemotecnico;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public Materia getMateriaActual() {
        return materiaActual;
    }

    public void setMateriaActual(Materia materiaActual) {
        this.materiaActual = materiaActual;
    }

    public String getNemotecnicoTema() {
        nemotecnicoTema = (materiaActual == null)?nemotecnicoTema:materiaActual.getMemoico();
        return nemotecnicoTema;
    }

    public void setNemotecnicoTema(String nemotecnicoTema) {
        this.nemotecnicoTema = nemotecnicoTema;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescripcionTema() {
        return descripcionTema;
    }

    public void setDescripcionTema(String descripcionTema) {
        this.descripcionTema = descripcionTema;
    }

}

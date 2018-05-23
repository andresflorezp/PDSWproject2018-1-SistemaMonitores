/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Profesor;
import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitores;
import static edu.eci.pdsw.samples.services.ServiciosSistemaMonitoresFactory.getInstance;
import java.io.Serializable;
import java.util.List;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author rafaeljimenez
 */
@ManagedBean(name = "profesorBean")
@SessionScoped

public class registrarProfesorBean implements Serializable {

    ServiciosSistemaMonitores sp = getInstance().getServiciosSistemaMonitores();

    private Integer identificacion;
    private Long telefono;
    private String nombres;
    private String apellidos;
    private String mail;
    private List<Profesor> profesores;

    public registrarProfesorBean() throws ExcepcionSistemaMonitores {
        consultar();
    }

    public void registrarProfesor() throws ExcepcionSistemaMonitores {
        sp.addProfesor(identificacion, nombres, apellidos, mail, telefono);
        getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(SEVERE, "Entro");
        save("Profesor Registrado.");
    }

    public void limpiar() {
        identificacion = null;
        telefono = null;
        nombres = null;
        apellidos = null;
        mail = null;

    }

    public void onCellEdit(CellEditEvent event) throws ExcepcionSistemaMonitores {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            Profesor profesorUpdate = profesores.get(event.getRowIndex());
            sp.actualizarProfesor(profesorUpdate);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Celda Cambiada", "Antiguo: " + oldValue + ", Nueva:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void consultar() throws ExcepcionSistemaMonitores {
        profesores = sp.consulatarProfesores();
    }

    public void delete(Integer codigo) throws ExcepcionSistemaMonitores {
        sp.deleteProfesor(codigo);
        FacesContext.getCurrentInstance().addMessage("messagesTable", new FacesMessage("Registro Eliminado de Profesor con identificacion " + codigo + "."));
        consultar();
    }

    public void save(String text) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(text));
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNombres() {
        return nombres;

    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;

    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

}

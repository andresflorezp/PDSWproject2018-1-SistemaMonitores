/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Monitor;
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
@ManagedBean(name = "monitorBean")
@SessionScoped
public class registrarMonitorBean implements Serializable {

    ServiciosSistemaMonitores sp = getInstance().getServiciosSistemaMonitores();

    private Integer codigo;
    private Long telefono;
    private String nombres;
    private String apellidos;
    private String mail;
    private String semestreIngreso;
    private String facultad;
    private List<Monitor> monitores;

    public registrarMonitorBean() {
    }

    public void registrarMonitor() {

        getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(SEVERE, "Entro");
    }

    public void limpiar() {
        codigo = null;
        telefono = null;
        nombres = null;
        apellidos = null;
        mail = null;
        semestreIngreso = null;
        facultad = null;
        monitores = null;
    }

    public void onCellEdit(CellEditEvent event) throws ExcepcionSistemaMonitores {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            Monitor monitorUpdate = monitores.get(event.getRowIndex());
            sp.actualizarMonitor(monitorUpdate);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Celda Cambiada", "Antiguo: " + oldValue + ", Nueva:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public Integer getCodigo() {
        return codigo;
    }

    public List<Monitor> getMonitores() {
        return monitores;
    }

    public void setMonitores(List<Monitor> monitores) {
        this.monitores = monitores;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public void setSemestreIngreso(String semestreIngreso) {
        this.semestreIngreso = semestreIngreso;
    }

    public String getSemestreIngreso() {
        return semestreIngreso;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getFacultad() {
        return facultad;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import java.io.Serializable;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rafaeljimenez
 */
@ManagedBean(name = "profesorBean")
@SessionScoped

public class registrarProfesorBean implements Serializable {

    private Integer identificacion;
    private Integer telefono;
    private String nombres;
    private String apellidos;
    private String mail;

    public registrarProfesorBean() {
    }

    public void registrarProfesor() {

        getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(SEVERE, "Entro");
    }

    public void limpiar() {
        identificacion = null;
        telefono = null;
        nombres = null;
        apellidos = null;
        mail = null;

    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getTelefono() {
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

}

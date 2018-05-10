/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Asesoria;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Tema;
import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitoresFactory;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Sergio
 */
@ManagedBean(name = "InformacionAsistenciaProfesor")
@SessionScoped
public class ConsultaInformacionAsesoriaProfesor implements Serializable {

    ServiciosSistemaMonitores sp = ServiciosSistemaMonitoresFactory.getInstance().getServiciosSistemaMonitores();

    private final int profesorID = 5; //temporal se supone se sabe de el login.
    private final int semestreID = 1; //temporal se supone se sabe de el login.
    private List<Asesoria> asesorias;

    public ConsultaInformacionAsesoriaProfesor() throws ExcepcionSistemaMonitores {
        filtrar();
    }

    public void filtrar() throws ExcepcionSistemaMonitores {
        asesorias = sp.consultaAsesoriaProfesor(profesorID, semestreID);
        Logger.getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(Level.SEVERE, "\nAns: " + asesorias);
    }

    public boolean filtrarTema(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }
        if (value == null) {
            return false;
        }
        List<Tema> temas = (List<Tema>) value;
        boolean acepted = false;
        for (Tema tema : temas) {
            acepted |= tema.getTopic().startsWith(filterText);
            if (acepted) {
                break;
            }
        }
        Logger.getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(Level.SEVERE, "\nFiltra: ->" + filterText + "<- " + temas.toString() + " = " + acepted);
        return acepted;
    }
    public boolean filtrarCarnet(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }
        if (value == null) {
            return false;
        }
        List<Estudiante> estudiantes = (List<Estudiante>) value;
        boolean acepted = false;
        for (Estudiante estudiante : estudiantes) {
            acepted |= String.valueOf(estudiante.getCarnet()).startsWith(filterText);
            if (acepted) {
                break;
            }
        }
        Logger.getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(Level.SEVERE, "\nFiltra: ->" + filterText + "<- " + estudiantes.toString() + " = " + acepted);
        return acepted;
    }

    public List<Asesoria> getAsesorias() {
        return asesorias;
    }

    public void setAsesorias(List<Asesoria> asesorias) {
        this.asesorias = asesorias;
    }
    
    

}

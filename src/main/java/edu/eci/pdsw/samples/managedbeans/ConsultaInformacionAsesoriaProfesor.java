/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.dataModel.LazyAsesoriaDataModel;
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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

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
    private LazyDataModel<Asesoria> asesorias;
    private Asesoria selectedAsistencia;

    public ConsultaInformacionAsesoriaProfesor() throws ExcepcionSistemaMonitores {
        filtrar();
    }
    
    public void filtrar() throws ExcepcionSistemaMonitores {
        asesorias = new LazyAsesoriaDataModel(sp.consultaAsesoriaProfesor(profesorID, semestreID));
//        asesorias = sp.consultaAsesoriaProfesor(profesorID, semestreID);
        Logger.getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(Level.SEVERE, "\nAns: {0}", asesorias);
    }
    
    public boolean filtrar(Object value, Object filter, Locale locale) {
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
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Asesoria Selected", String.valueOf(( (Asesoria) event.getObject()).getAsesoriaID() ));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public LazyDataModel<Asesoria> getAsesorias() {
        return asesorias;
    }

    public void setAsesorias(LazyDataModel<Asesoria> asesorias) {
        this.asesorias = asesorias;
    }
    
    public Asesoria getSelectedAsistencia() {
        return selectedAsistencia;
    }

    public void setSelectedAsistencia(Asesoria selectedAsistencia) {
        this.selectedAsistencia = selectedAsistencia;
    }
    
    

}

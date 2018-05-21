/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.dataModel.LazyAsesoriaDataModel;
import edu.eci.pdsw.samples.entities.Asesoria;
import edu.eci.pdsw.samples.entities.Tema;
import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitores;
import static edu.eci.pdsw.samples.services.ServiciosSistemaMonitoresFactory.getInstance;
import java.io.Serializable;
import static java.lang.String.valueOf;
import java.util.List;
import java.util.Locale;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import static javax.faces.context.FacesContext.getCurrentInstance;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author sergiort
 */
@ManagedBean(name = "InformacionAsesorias")
@SessionScoped
public class ConsultaInformacionAsesoriasBean implements Serializable {

    ServiciosSistemaMonitores sp = getInstance().getServiciosSistemaMonitores();
    
    private final int monitorID = 2; //temporal se supone se sabe de el login.
    private final int semestreID = 1; //temporal se supone se sabe de el login.
    
    private LazyDataModel<Asesoria> asesorias;
    private Asesoria selectedAsistencia;

    public ConsultaInformacionAsesoriasBean() throws ExcepcionSistemaMonitores {
        filtrar();
    }
    
    public void filtrar() throws ExcepcionSistemaMonitores {
        asesorias = new LazyAsesoriaDataModel(sp.consultaAsesoriaMonitor(monitorID, semestreID));
        getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(SEVERE, "\nAns: " + asesorias);
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
        getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(SEVERE, "\nFiltra: ->" + filterText + "<- " + temas.toString() + " = " + acepted);
        return acepted;
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Asesoria seleccionada", valueOf(((Asesoria) event.getObject()).getAsesoriaID()));
        getCurrentInstance().addMessage(null, msg);
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

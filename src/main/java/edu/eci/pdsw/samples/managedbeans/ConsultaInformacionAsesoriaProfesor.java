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
import static edu.eci.pdsw.samples.services.ServiciosSistemaMonitoresFactory.getInstance;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

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
    private BarChartModel asistencia_Monitorias_Monitor;
    
    private BarChartModel asistencia_Monitorias_curso;
    
    private  Axis yAxis;
    private List<HashMap> queryAsistenciaMonitoria;
    private List<HashMap> queryCursoMonitoria;
    private ServiciosSistemaMonitores servicios;

    public ConsultaInformacionAsesoriaProfesor() throws ExcepcionSistemaMonitores {
        servicios = getInstance().getServiciosSistemaMonitores();
        queryAsistenciaMonitoria = servicios.consultaMonitorias();
        queryCursoMonitoria = servicios.consultaCurso();
        filtrar();
        init();
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
    public void init() {
        createAnimatedModels();
    }
   
    private void createAnimatedModels() {
       
    
        asistencia_Monitorias_Monitor = initBarModelAsistencia();
        asistencia_Monitorias_Monitor.setTitle("Asistencia Monitorias");
        asistencia_Monitorias_Monitor.setAnimate(true);
        asistencia_Monitorias_Monitor.setLegendPosition("ECI");
        yAxis = asistencia_Monitorias_Monitor.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
        
        
        asistencia_Monitorias_curso = initBarModelCurso();
        asistencia_Monitorias_curso.setTitle("Asistencia por Curso Monitorias");
        asistencia_Monitorias_curso.setAnimate(true);
        asistencia_Monitorias_curso.setLegendPosition("ECI");
        yAxis = asistencia_Monitorias_curso.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
        
    }
    private BarChartModel initBarModelAsistencia() {
        BarChartModel model = new BarChartModel();

        ArrayList<ChartSeries> charts = new ArrayList();
        for(int i=0;i<queryAsistenciaMonitoria.size();i++){
            charts.add(new ChartSeries());
        }
        for(int i=0;i<queryAsistenciaMonitoria.size();i++){
           long numeroMonitorias = (long) queryAsistenciaMonitoria.get(i).get("numero_monitorias");
           charts.get(i).setLabel((String) queryAsistenciaMonitoria.get(i).get("monitor"));
           charts.get(i).set("Monitores",numeroMonitorias);
           model.addSeries(charts.get(i));
        }
        return model;
    }
    private BarChartModel initBarModelCurso() {
        BarChartModel model = new BarChartModel();

        ArrayList<ChartSeries> charts = new ArrayList();
        for(int i=0;i<queryCursoMonitoria.size();i++){
            charts.add(new ChartSeries());
        }
        for(int i=0;i<queryCursoMonitoria.size();i++){
           long numeroMonitorias = (long) queryCursoMonitoria.get(i).get("numero_monitorias");
           charts.get(i).setLabel((String) queryCursoMonitoria.get(i).get("curso"));
           charts.get(i).set("Cursos",numeroMonitorias);
           model.addSeries(charts.get(i));
        }
        return model;
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

    public BarChartModel getAsistencia_Monitorias_Monitor() {
        return asistencia_Monitorias_Monitor;
    }

    public void setAsistencia_Monitorias_Monitor(BarChartModel asistencia_Monitorias_Monitor) {
        this.asistencia_Monitorias_Monitor = asistencia_Monitorias_Monitor;
    }

    public BarChartModel getAsistencia_Monitorias_curso() {
        return asistencia_Monitorias_curso;
    }

    public void setAsistencia_Monitorias_curso(BarChartModel asistencia_Monitorias_curso) {
        this.asistencia_Monitorias_curso = asistencia_Monitorias_curso;
    }
    
    

}

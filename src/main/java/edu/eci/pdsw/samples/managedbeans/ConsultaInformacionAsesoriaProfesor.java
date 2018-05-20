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
import java.util.ArrayList;
import java.util.HashMap;
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
import org.primefaces.model.chart.Axis;
import static org.primefaces.model.chart.AxisType.Y;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Sergio
 */
@ManagedBean(name = "InformacionAsistenciaProfesor")
@SessionScoped
public class ConsultaInformacionAsesoriaProfesor implements Serializable {

    ServiciosSistemaMonitores sp = getInstance().getServiciosSistemaMonitores();

    private final int profesorID = 5; //temporal se supone se sabe de el login.
    private final int semestreID = 1; //temporal se supone se sabe de el login.
    private LazyDataModel<Asesoria> asesorias;
    private Asesoria selectedAsistencia;
    private BarChartModel asistencia_Monitorias_Monitor;
    
    private BarChartModel asistencia_Monitorias_curso;
    private BarChartModel asistencia_Monitorias_grupo;
    private BarChartModel asistencia_Monitorias_Tema;
    
    private  Axis yAxis;
    private List<HashMap> queryAsistenciaMonitoria;
    private List<HashMap> queryCursoMonitoria;
    private List<HashMap> queryGrupoMonitoria;
    private List<HashMap> queryTemaMonitoria;
    private ServiciosSistemaMonitores servicios;

    public ConsultaInformacionAsesoriaProfesor() throws ExcepcionSistemaMonitores {
        servicios = getInstance().getServiciosSistemaMonitores();
        queryAsistenciaMonitoria = servicios.consultaMonitorias();
        queryCursoMonitoria = servicios.consultaCurso();
        queryGrupoMonitoria = servicios.consultaGrupo();
        queryTemaMonitoria = servicios.consultaTema();
        filtrar();
        init();
    }
    
    public void filtrar() throws ExcepcionSistemaMonitores {
        asesorias = new LazyAsesoriaDataModel(sp.consultaAsesoriaProfesor(profesorID, semestreID));
//        asesorias = sp.consultaAsesoriaProfesor(profesorID, semestreID);
        getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(SEVERE, "\nAns: {0}", asesorias);
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
    public void init() {
        createAnimatedModels();
    }
   
    private void createAnimatedModels() {
       
    
        asistencia_Monitorias_Monitor = initBarModelAsistencia();
        asistencia_Monitorias_Monitor.setTitle("Asistencia Monitorias");
        asistencia_Monitorias_Monitor.setAnimate(true);
        asistencia_Monitorias_Monitor.setLegendPosition("ECI");
        yAxis = asistencia_Monitorias_Monitor.getAxis(Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
        
        
        asistencia_Monitorias_curso = initBarModelCurso();
        asistencia_Monitorias_curso.setTitle("Asistencia por Curso Monitorias");
        asistencia_Monitorias_curso.setAnimate(true);
        asistencia_Monitorias_curso.setLegendPosition("ECI");
        yAxis = asistencia_Monitorias_curso.getAxis(Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
        
        asistencia_Monitorias_grupo = initBarModelGrupo();
        asistencia_Monitorias_grupo.setTitle("Asistencia por Grupo Monitorias");
        asistencia_Monitorias_grupo.setAnimate(true);
        asistencia_Monitorias_grupo.setLegendPosition("ECI");
        yAxis = asistencia_Monitorias_grupo.getAxis(Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
        
        
        asistencia_Monitorias_Tema = initBarModelTema();
        asistencia_Monitorias_Tema.setTitle("Asistencia por Tema Monitorias");
        asistencia_Monitorias_Tema.setAnimate(true);
        asistencia_Monitorias_Tema.setLegendPosition("ECI");
        yAxis = asistencia_Monitorias_Tema.getAxis(Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
        
    }
    private BarChartModel initBarModelAsistencia() {
        BarChartModel model = new BarChartModel();

        ArrayList<ChartSeries> charts = new ArrayList();
        for (HashMap queryAsistenciaMonitoria1 : queryAsistenciaMonitoria) {
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
        for (HashMap queryCursoMonitoria1 : queryCursoMonitoria) {
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
    
    private BarChartModel initBarModelGrupo() {
        BarChartModel model = new BarChartModel();

        ArrayList<ChartSeries> charts = new ArrayList();
        for (HashMap queryCursoMonitoria1 : queryCursoMonitoria) {
            charts.add(new ChartSeries());
        }
        for(int i=0;i<queryCursoMonitoria.size();i++){
           long numeroMonitorias = (long) queryCursoMonitoria.get(i).get("numero_monitorias");
           //long numeroGrupo = (long) queryCursoMonitoria.get(i).get("grupo");
           charts.get(i).setLabel("grupo"+(i+1));
           charts.get(i).set("grupos",numeroMonitorias);
           model.addSeries(charts.get(i));
        }
        return model;
    }
    private BarChartModel initBarModelTema() {
       BarChartModel model = new BarChartModel();

        ArrayList<ChartSeries> charts = new ArrayList();
        for (HashMap queryTemaMonitoria1 : queryTemaMonitoria) {
            charts.add(new ChartSeries());
        }
        for(int i=0;i<queryTemaMonitoria.size();i++){
           long numeroMonitorias = (long) queryTemaMonitoria.get(i).get("numero_monitorias");
           charts.get(i).setLabel((String) queryTemaMonitoria.get(i).get("tema"));
           charts.get(i).set("Temas",numeroMonitorias);
           model.addSeries(charts.get(i));
        }
        return model;
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Asesoria Selected", valueOf(( (Asesoria) event.getObject()).getAsesoriaID() ));
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

    public BarChartModel getAsistencia_Monitorias_grupo() {
        return asistencia_Monitorias_grupo;
    }

    public void setAsistencia_Monitorias_grupo(BarChartModel asistencia_Monitorias_grupo) {
        this.asistencia_Monitorias_grupo = asistencia_Monitorias_grupo;
    }

    public BarChartModel getAsistencia_Monitorias_Tema() {
        return asistencia_Monitorias_Tema;
    }

    public void setAsistencia_Monitorias_Tema(BarChartModel asistencia_Monitorias_Tema) {
        this.asistencia_Monitorias_Tema = asistencia_Monitorias_Tema;
    }
    
    
}

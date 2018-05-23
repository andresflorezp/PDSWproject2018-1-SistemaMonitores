/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

/**
 *
 * @author Andres
 */
import edu.eci.pdsw.samples.managedbeans.KeyValue;
import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitores;
import static edu.eci.pdsw.samples.services.ServiciosSistemaMonitoresFactory.getInstance;
import java.util.*;

public class PieChartData {
    public List<KeyValue> pieDataListDetallesXgrupo;
    public List<KeyValue> pieDataListDetallesXcurso;
    public ServiciosSistemaMonitores servicios;
    public PieChartData() throws ExcepcionSistemaMonitores{
        servicios = getInstance().getServiciosSistemaMonitores();
        init();
        
    
    }
    public void init() throws ExcepcionSistemaMonitores{
        initDetallesXgrupo();
        initDetallesXcurso();
        
        
    
    }
    public void initDetallesXgrupo() throws ExcepcionSistemaMonitores{
        pieDataListDetallesXgrupo = new ArrayList<>();
        List<HashMap> consultaXgrupo = servicios.consultaGrupo();
        for (int i = 0; i < consultaXgrupo.size(); i++) {
            long numeroMonitorias =  (long) consultaXgrupo.get(i).get("numero_monitorias");
            int numeroGrupo = (int) consultaXgrupo.get(i).get("grupo");
            
            pieDataListDetallesXgrupo.add(new KeyValue("Grupo"+numeroGrupo, Long.toString(numeroMonitorias)));
        }
    }
    public void initDetallesXcurso() throws ExcepcionSistemaMonitores{
        pieDataListDetallesXcurso = new ArrayList<>();
        List<HashMap> consultaXcurso = servicios.consultaCurso();
        for (int i = 0; i < consultaXcurso.size(); i++) {
            long numeroMonitorias =  (long) consultaXcurso.get(i).get("numero_monitorias");
            String curso =  (String) consultaXcurso.get(i).get("curso");
            
            pieDataListDetallesXcurso.add(new KeyValue(curso, Long.toString(numeroMonitorias)));
        }
    }
    
    public List<KeyValue> getPieDataListDetallesXgrupo() {
        return pieDataListDetallesXgrupo;
    }

    public void setPieDataListDetallesXgrupo(List<KeyValue> pieDataListDetallesXgrupo) {
        this.pieDataListDetallesXgrupo = pieDataListDetallesXgrupo;
    }

    public List<KeyValue> getPieDataListDetallesXcurso() {
        return pieDataListDetallesXcurso;
    }

    public void setPieDataListDetallesXcurso(List<KeyValue> pieDataListDetallesXcurso) {
        this.pieDataListDetallesXcurso = pieDataListDetallesXcurso;
    }

    public ServiciosSistemaMonitores getServicios() {
        return servicios;
    }

    public void setServicios(ServiciosSistemaMonitores servicios) {
        this.servicios = servicios;
    }
    
    
    

}

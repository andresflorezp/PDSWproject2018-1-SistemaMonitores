/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Monitor;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author sergiort
 */
public interface MonitorMapper {
    public Monitor consultarMonitor(@Param("carnet") Long carnet);
    
    default List<Monitor> consultarMonitores(){
        return consultarMonitorr(null);
    }
    
    public void agregarMonitor(@Param("carnet") long carnet,@Param("nombre") String nombre);
    
    public List<Monitor> consultarMonitorr(@Param("carnet") Long carnet);
    public List<HashMap> consultaMonitorias();
    public List<HashMap> consultaCurso();
    public List<HashMap> consultaGrupo();
    public List<HashMap> consultaTema();
    
}

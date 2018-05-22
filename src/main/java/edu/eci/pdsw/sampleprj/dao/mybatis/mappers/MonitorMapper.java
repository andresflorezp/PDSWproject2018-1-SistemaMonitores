/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Monitor;

import java.util.*;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author sergiort
 */
public interface MonitorMapper {

    default Monitor consultarMonitor(Long carnet){
        return consultaMonitoresGeneral(carnet).get(0);
    }

    default List<Monitor> consultarMonitores() {
        return consultaMonitoresGeneral(null);
    }

    public void agregarMonitor(@Param("codID") Integer codigoID,
                                @Param("nom") String nombre,
                                @Param("apell") String apellido,
                                @Param("mail") String correo,
                                @Param("tel") Long telefono,
                                @Param("semI") String semestreIngreso,
                                @Param("prog") Integer programaAcademico);

    public List<Monitor> consultaMonitoresGeneral(@Param("monID") Long carnet);

    public List<HashMap> consultaMonitorias();

    public List<HashMap> consultaCurso();

    public List<HashMap> consultaGrupo();

    public List<HashMap> consultaTema();
    
    public List<HashMap> consultaGrupoxTema();
    
    public List<HashMap> consultaCursoxMonitor();

    public void actualizarMonitor(@Param("carnet") int codigoID,
                                @Param("nom") String nombre,
                                @Param("apell") String apellido,
                                @Param("mail") String correo,
                                @Param("tel") long telefono,
                                @Param("semI") String semestreIngreso,
                                @Param("prog") int programaAcademico);

    public void deleteMonitor(@Param("carnet") Integer codigo);

}

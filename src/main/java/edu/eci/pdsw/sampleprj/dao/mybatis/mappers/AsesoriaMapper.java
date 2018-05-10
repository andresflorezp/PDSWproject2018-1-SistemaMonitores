/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Asesoria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author sergiort
 */
public interface AsesoriaMapper {
    
    public List<Asesoria> consultaAsesoriasMonitor(@Param("monID") Integer monitorID,
                                                   @Param("semID") Integer semestreID);
    
    public void registroAsesoriaMonitor(@Param("monID") Integer monitorID,@Param("Ip") String ip);

    public void registroAsesoriaEstudiante(@Param("aseID") Integer asesoriaID,
                                            @Param("carnet") Integer codigoInt, 
                                            @Param("obs") String observaciones, 
                                            @Param("proID") Integer profesorID);

    public List<Asesoria> consultaAsesoriasProfesor(@Param("proID") Integer profesorID,@Param("semID") Integer semestreID);
}

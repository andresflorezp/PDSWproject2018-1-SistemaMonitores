/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Asesoria;
import java.sql.Timestamp;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author sergiort
 */
public interface AsesoriaMapper {
    
    public void registroAsesoriaMonitor(@Param("monID") Integer monitorID, @Param("Ip") String ip, @Param("act") Timestamp fechaInicio);
    
    default List<Asesoria> consultaAsesoriasMonitor(Integer monitorID, Integer semestreID){
        return consultaAsesoriasGeneral(monitorID, semestreID, 0, null);
    }

    default List<Asesoria> consultaAsesoriasProfesor(Integer profesorID, Integer semestreID){
        return consultaAsesoriasGeneral(profesorID, semestreID, 1, null);
    }
    
    public List<Asesoria> consultaAsesoriasGeneral(@Param("perID") Integer personaID,
                                                    @Param("semID") Integer semestreID,
                                                    @Param("state") Integer isMonitor,
                                                    @Param("act") Timestamp fechaInicio);
    
    default List<Asesoria> consultaAsistentesProfesor(@Param("proID") Integer profesorID,@Param("semID") Integer semestreID){
        return consultaAsesoriasGeneral(profesorID, semestreID, 2, null);
    }

    default Asesoria consultaAsesoriaMonitor(@Param("monID") int monitorID, @Param("act") Timestamp fechaInicio, @Param("semID") int semestreID){
        return consultaAsesoriasGeneral(monitorID, semestreID, 0, fechaInicio).get(0);
    }

    public void finalizarMonitoria(@Param("asID")int asesoriaID,@Param("act") Timestamp fechaFin);
    
}

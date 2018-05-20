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
    
    public void registroAsesoriaMonitor(@Param("monID") Integer monitorID,@Param("Ip") String ip);
    
    default List<Asesoria> consultaAsesoriasMonitor(Integer monitorID, Integer semestreID){
        return consultaAsesoriasGeneral(monitorID, semestreID, true);
    }

    default List<Asesoria> consultaAsesoriasProfesor(Integer profesorID, Integer semestreID){
        return consultaAsesoriasGeneral(profesorID, semestreID, false);
    }
    
    public List<Asesoria> consultaAsesoriasGeneral(@Param("perID") Integer personaID,
                                                    @Param("semID") Integer semestreID,
                                                    @Param("isMon") boolean isMonitor);
    
    public List<Asesoria> consultaAsistentesProfesor(@Param("proID") Integer profesorID,@Param("semID") Integer semestreID);
    
}

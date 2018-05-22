/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Horario;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author rafaeljimenez
 */
public interface HorariosMapper {
    /**
     * Metodo para consultar un horario
     * @param codId es el codigo de la materia a consultar
     * @return 
     */
    default Horario consultarHorario(Integer codId){
        return consultarHorarioGeneral(codId).get(0);
    }
    /**
     * Metodo para consultar todos los horarios
     * @param codigo si codigo es null consulta todos, si no consulta la indicada
     * @return 
     */ 
    public List<Horario> consultarHorarioGeneral(@Param("codId") Integer codigo );
    
    default List<Horario> consultarMaterias(){
        return consultarHorarioGeneral(null);
        
    }
}

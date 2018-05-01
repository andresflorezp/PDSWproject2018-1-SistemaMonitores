/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Estudiante;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author sergiort
 */
public interface EstudianteMapper {
    
    default Estudiante consultarEstudiante(Long carnet){
        return consultarEstudianteGeneral(carnet).get(0);
    }
    
    default List<Estudiante> consultarEstudiantes(){
        return consultarEstudianteGeneral(null);
    }
      
    public List<Estudiante> consultarEstudianteGeneral(@Param("carnet") Long carnet);
    
    
    public void agregarEstudiante(@Param("carnet") long carnet,
                             @Param("nombre") String nombre,
                             @Param("grupo") int grupo);
}

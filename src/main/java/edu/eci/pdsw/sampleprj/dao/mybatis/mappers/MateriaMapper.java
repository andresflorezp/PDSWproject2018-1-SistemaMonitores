/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Materia;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Tatiana
 */
public interface MateriaMapper {
    /**
     * Metodo para consultar una materia
     * @param codigo es el codigo de la materia
     * @return 
     */
    default Materia consultarMateria(Integer codigo){
        return consultaMateriaGeneral(codigo).get(0);
    }
    /**
     * Metodo para consultar todas las materias
     * @param codigo si codigo es null consulta todas, si no consutla todas
     * @return 
     */
    public List<Materia> consultaMateriaGeneral(@Param("codId") Integer codigo);
    public void insertarMateria(@Param("materia")Materia materia);

    default List<Materia> consultarMaterias(){
        return consultaMateriaGeneral(null);
        
    }
}
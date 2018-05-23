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
        return consultaMateriaGeneral(codigo,null).get(0);
    }
    /**
     * Metodo para consultar todas las materias
     * @param codigo si codigo es null consulta todas, si no consutla todas
     * @param nemotecnico
     * @return 
     */
    public List<Materia> consultaMateriaGeneral(@Param("codId") Integer codigo, @Param("men") String nemotecnico);
    
    public void insertarMateria(@Param("materia")Materia materia);

    default List<Materia> consultarMaterias(){
        return consultaMateriaGeneral(null,null);
    }

    public void deleteMateria(@Param("memo") String id);

    public void actualizarMateria(@Param("codId") Integer id, @Param("nom") String nombre, @Param("men") String memoico, @Param("cre") int creditos, 
            @Param("hora") int horas);

    public void insertarMateria(@Param("nom") String nombre, @Param("men") String nemotecnico, @Param("cre") Integer creditos, @Param("hora") Integer horas);

    default Materia consultarActual(@Param("men") String nemotecnico){
        return consultaMateriaGeneral(null,nemotecnico).get(0);
    }
}
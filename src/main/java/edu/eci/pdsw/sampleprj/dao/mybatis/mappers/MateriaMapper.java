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
    public Materia consultarMateria(@Param("codId") int codigo);    
    public void insertarMateria(@Param("materia")Materia materia);
}
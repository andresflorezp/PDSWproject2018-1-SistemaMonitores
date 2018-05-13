/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author sergiort
 */
public interface AsesoriaEstudianteMapper {
    
    public void registroAsesoriaEstudiante(@Param("aseID") Integer asesoriaID,
                                        @Param("carnet") Integer codigoInt, 
                                        @Param("obs") String observaciones, 
                                        @Param("proID") Integer profesorID);
}

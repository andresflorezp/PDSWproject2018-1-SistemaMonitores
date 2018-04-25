/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Grupo;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author sergiort
 */
public interface GrupoMapper {
    public Grupo ConsultaAsesoriaMateria(@Param("MId") Integer materiaID,
                                           @Param("grdId") Integer grupoID,
                                           @Param("tmId") Integer tema);
}

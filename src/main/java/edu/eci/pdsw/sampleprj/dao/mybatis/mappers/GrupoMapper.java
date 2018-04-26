/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Grupo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author sergiort
 */
public interface GrupoMapper {
    public List<Grupo> ConsultaAsesoriaMateria(@Param("MId") Integer materiaID,
                                           @Param("grdId") Integer grupoID,
                                           @Param("tmId") Integer tema);
    
    public void agregarGrupo(@Param("GId") Integer grupoID,
                             @Param("gPrId") Integer profesorID,
                             @Param("gSeId") Integer semestreID,
                             @Param("gMaId") Integer materiaID,
                             @Param("gMoId")Integer monitorID,
                             @Param("gNom") Integer grupoNombre,
                             @Param("gNum") int numeroEstudiantes);
}

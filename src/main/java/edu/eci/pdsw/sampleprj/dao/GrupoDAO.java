/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Grupo;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author SergioRt
 */
public interface GrupoDAO {
    public Grupo load(Integer id);
    
    public void save(Grupo grupo);
    
    public Grupo consultarGruposAsesoriaMonitor(Integer materiaID,
                                           Integer grupoID,
                                           Integer tema);
}

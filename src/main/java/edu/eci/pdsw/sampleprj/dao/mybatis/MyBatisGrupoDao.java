/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.GrupoDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.GrupoMapper;
import edu.eci.pdsw.samples.entities.Grupo;

/**
 *
 * @author SergioRt
 */
public class MyBatisGrupoDao implements GrupoDAO{
    @Inject
    private GrupoMapper grupoMapper;
            
    @Override
    public Grupo load(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void save(Grupo grupo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Grupo consultarGruposAsesoriaMonitor(Integer materiaID, Integer grupoID, Integer tema) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}

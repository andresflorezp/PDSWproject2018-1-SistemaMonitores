/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.MonitorDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.MonitorMapper;
import edu.eci.pdsw.samples.entities.Monitor;
import java.util.List;

/**
 *
 * @author tatiana
 */
public class MyBatisMonitorDAO implements MonitorDAO{
    
    @Inject
    private MonitorMapper monitorMapper;
    
    @Override
    public Monitor load(long codigo) throws PersistenceException {
        try{
            return monitorMapper.consultarMonitor(codigo);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public void save(Monitor monitor) throws PersistenceException {
        try{
            monitorMapper.agregarMonitor(monitor.getCodigoID(), monitor.getNombre());
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public List<Monitor> consultarMonitores() throws PersistenceException {
        try{
            return monitorMapper.consultarMonitores();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}

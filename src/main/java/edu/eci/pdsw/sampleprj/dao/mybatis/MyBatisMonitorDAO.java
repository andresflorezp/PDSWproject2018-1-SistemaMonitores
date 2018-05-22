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
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author tatiana
 */
public class MyBatisMonitorDAO implements MonitorDAO, Serializable {
    
    @Inject
    private MonitorMapper monitorMapper;
    
    @Override
    public Monitor load(long codigo) throws PersistenceException {
        try{
            return monitorMapper.consultarMonitor(codigo);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consular al monitor con identificador: "+codigo);
        }catch(java.lang.IndexOutOfBoundsException e){
            throw new PersistenceException("Monitor con identificador : "+codigo+" no encontrado.");
        }
    }

    @Override
    public void save(Integer codigoID, String nombre, String apellido, String correo, Long telefono, String semestreIngreso, Integer programaAcademico) throws PersistenceException {
        try{
            monitorMapper.agregarMonitor(codigoID, nombre, apellido, correo, telefono, semestreIngreso, programaAcademico);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registar al monitor con identificador : "+codigoID+e.getMessage());
        }
    }

    @Override
    public List<Monitor> consultarMonitores() throws PersistenceException {
        try{
            return monitorMapper.consultarMonitores();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consular a los monitores.");
        }
    }
    @Override
    public List<HashMap> consultaMonitorias() throws PersistenceException{
         try{
            return monitorMapper.consultaMonitorias();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public List<HashMap> consultaCurso() throws PersistenceException {
        try{
            return monitorMapper.consultaCurso();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public List<HashMap> consultaGrupo() throws PersistenceException {
        try{
            return monitorMapper.consultaGrupo();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public List<HashMap> consultaTema() throws PersistenceException {
        try{
            return monitorMapper.consultaTema();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public void actualizarMonitor(Integer codigoID, String nombre, String apellido, String correo, Long telefono, String semestreIngreso, Integer programaAcademico) throws PersistenceException {
        try{
            monitorMapper.actualizarMonitor(codigoID, nombre, apellido, correo, telefono, semestreIngreso, programaAcademico);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}

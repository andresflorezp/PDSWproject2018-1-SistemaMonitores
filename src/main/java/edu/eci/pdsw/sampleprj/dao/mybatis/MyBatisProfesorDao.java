/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.ProfesorDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ProfesorMapper;
import edu.eci.pdsw.samples.entities.Profesor;
import java.util.List;

/**
 *
 * @author sergiort
 */
public class MyBatisProfesorDao implements ProfesorDAO{
    
    @Inject
    private ProfesorMapper profesorMapper;
    
    @Override
    public void save(Integer codigoID, String nombre, String apellido, String correo, Long telefono) throws PersistenceException {
        try{
            profesorMapper.agregarProfesor(codigoID, nombre, apellido, correo, telefono);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registar al profesor con identificador : "+codigoID+e.getMessage());
        }
    }

    @Override
    public void actualizarProfesor(Integer codigoID, String nombre, String apellido, String correo, Long telefono) throws PersistenceException {
        try{
            profesorMapper.actualizarProfesor(codigoID, nombre, apellido, correo, telefono);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al actualizar al profesor con identificador: "+codigoID+" "+nombre+e.getMessage());
        }
    }

    @Override
    public void delete(Integer codigo) throws PersistenceException {
        try{
            profesorMapper.deleteProfesor(codigo);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al Eliminar al profesor con identificador: "+codigo+" "+e.getMessage());
        }
    }

    @Override
    public Profesor load(long codigo) throws PersistenceException {
        try{
            return profesorMapper.consultarProfesor(codigo);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consular al monitor con carnet: "+codigo);
        }catch(java.lang.IndexOutOfBoundsException e){
            throw new PersistenceException("Monitor con carnet : "+codigo+" no encontrado.");
        }
    }

    @Override
    public List<Profesor> loadAll() throws PersistenceException {
        try{
            return profesorMapper.consultarProfesores();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consular a los monitores.");
        }
    }
    
}

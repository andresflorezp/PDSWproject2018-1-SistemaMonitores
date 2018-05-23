/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.TemaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TemaMapper;
import edu.eci.pdsw.samples.entities.Tema;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author tatiana
 */
public class MyBatisTemaDao implements TemaDAO, Serializable {

    @Inject
    private TemaMapper temaMapper;

    @Override
    public Tema load(int codigo) {
        try {
            return temaMapper.consultarTema(codigo);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public void registroTemaMonitoria(int asesoriaID, int codigoInt, Integer temaID) throws PersistenceException {
        try {
            temaMapper.registroTemaMonitoria(asesoriaID, codigoInt, temaID);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al realizar el registro del tema con ID: " + temaID + " para el estudiante con Carnet: " + codigoInt + "\n" + e.getMessage());
        }
    }

    @Override
    public void save(int materiaID, String tema, String descripcion) throws PersistenceException {
        try {
            temaMapper.insertarTema(materiaID, tema, descripcion);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al guardar al tema con para la materia con id: "+materiaID+"."+e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws PersistenceException {
        try{
            temaMapper.deleteTema(id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al Eliminar al tema con identificador: "+id+"."+e.getMessage());
        }
    }

    @Override
    public void actualizarTema(int temaId, String topic, String descripcion) throws PersistenceException {
        try{
            temaMapper.actualizarTema(temaId, topic, descripcion);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al actualizar al tema con identificador: "+temaId+" "+topic+e.getMessage());
        }
    }

    @Override
    public List<Tema> loadAllMateria(int materiaID) throws PersistenceException {
        try{
            return temaMapper.consultaTemasMateria(materiaID);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al actualizar los temas para la materia con identificador: "+materiaID+" "+e.getMessage());
        }
    }

}

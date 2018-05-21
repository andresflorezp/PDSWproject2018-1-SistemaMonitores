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
import javax.inject.Inject;

/**
 *
 * @author tatiana
 */
public class MyBatisTemaDao implements TemaDAO, Serializable{
    
    @Inject
    private TemaMapper temaMapper;
    
    @Override
    public void save(Tema tema) {
        try{
            temaMapper.insertarCliente(tema);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public Tema load(int codigo) {
        try{
            return temaMapper.consultarTema(codigo);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public void registroTemaMonitoria(int asesoriaID, int codigoInt, Integer temaID) throws PersistenceException {
        try{
            temaMapper.registroTemaMonitoria(asesoriaID, codigoInt, temaID);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al realizar el registro del tema con ID: "+temaID+" para el estudiante con Carnet: "+codigoInt +"\n"+e.getMessage());
        }
    }
    
}
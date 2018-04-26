/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import edu.eci.pdsw.sampleprj.dao.TemaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TemaMapper;
import edu.eci.pdsw.samples.entities.Tema;
import javax.inject.Inject;

/**
 *
 * @author tatiana
 */
public class MyBatisTemaDao implements TemaDAO{
    
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
    
}
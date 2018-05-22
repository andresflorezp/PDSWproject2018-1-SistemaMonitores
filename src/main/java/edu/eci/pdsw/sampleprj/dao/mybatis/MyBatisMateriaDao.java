/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import edu.eci.pdsw.sampleprj.dao.MateriaDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.MateriaMapper;
import edu.eci.pdsw.samples.entities.Materia;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
/**
 *
 * @author tatiana
 */
public class MyBatisMateriaDao implements MateriaDAO, Serializable {
    
    @Inject
    private MateriaMapper materiaMapper;
    
    @Override
    public void save(Materia materia) {
        try{
            materiaMapper.insertarMateria(materia);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public Materia load(int codigo) {
        try{
            return materiaMapper.consultarMateria(codigo);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Materia> loadAll() throws PersistenceException {
        try{
            return materiaMapper.consultarMaterias();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar las materias"+e.getMessage());
        }
        
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.EstudianteDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.EstudianteMapper;
import edu.eci.pdsw.samples.entities.Estudiante;
import java.util.List;

/**
 *
 * @author SergioRt
 */
public class MyBatisEstudianteDao implements EstudianteDAO {

    @Inject
    private EstudianteMapper estudianteMapper;

    @Override
    public void save(Estudiante estudiante) throws PersistenceException {
        estudianteMapper.agregarEstudiante(estudiante.getCarnet(),estudiante.getNombre(),estudiante.getGrupo());
    }

    @Override
    public Estudiante load(long carnet) throws PersistenceException {
        try{
            return estudianteMapper.consultarEstudiante(carnet);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el estudiante "+carnet,e);
        }catch(java.lang.IndexOutOfBoundsException ex){
            throw new PersistenceException("Un estudiante con carnet "+carnet+" no ha sido encontrado",ex);
        }
    }

    @Override
    public List<Estudiante> consultarEstudiantes() throws PersistenceException {
        try{
            return estudianteMapper.consultarEstudiantes();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar los estudiantes.",e);
        }
    }
}




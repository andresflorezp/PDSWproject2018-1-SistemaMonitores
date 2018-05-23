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
    public void save(String nombre, String nemotecnico, Integer creditos, Integer horas) throws PersistenceException {
        try {
            materiaMapper.insertarMateria(nombre, nemotecnico, creditos, horas);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al agregar la materia " + nemotecnico + e.getMessage());
        }
    }

    @Override
    public Materia load(int codigo) throws PersistenceException {
        try {
            return materiaMapper.consultarMateria(codigo);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar la materia con identificador " + codigo + e.getMessage());
        } catch (java.lang.IndexOutOfBoundsException e) {
            throw new PersistenceException("La materia con identificador " + codigo + " no ha sido encontrada." + e.getMessage());
        }
    }

    @Override
    public List<Materia> loadAll() throws PersistenceException {
        try {
            return materiaMapper.consultarMaterias();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar las materias " + e.getMessage());
        }

    }

    @Override
    public void delete(String id) throws PersistenceException {
        try {
            materiaMapper.deleteMateria(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al Eliminar la materia con identificador: " + id + " " + e.getMessage());
        }
    }

    @Override
    public void actualizarMateria(Integer id, String nombre, String memoico, int creditos, int horas) throws PersistenceException {
        try {
            materiaMapper.actualizarMateria(id, nombre, memoico, creditos, horas);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al actualizar al monitor con carnet: " + id + " " + nombre + e.getMessage());
        }
    }

    @Override
    public Materia consultaActual(String nemotecnico) throws PersistenceException {
        try {
            return materiaMapper.consultarActual(nemotecnico);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar la materia " + nemotecnico + e.getMessage());
        } catch (java.lang.IndexOutOfBoundsException e) {
            throw new PersistenceException("La materia " + nemotecnico + " no ha sido encontrada." + e.getMessage());
        }
    }
}

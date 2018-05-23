/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Materia;
import java.util.List;

/**
 *
 * @author tatiana
 */
public interface MateriaDAO {

    public void save(String nombre, String nemotecnico, Integer creditos, Integer horas) throws PersistenceException;

    public Materia load(int codigo) throws PersistenceException;

    public List<Materia> loadAll() throws PersistenceException;

    public void delete(String id) throws PersistenceException;

    public void actualizarMateria(Integer id, String nombre, String memoico, int creditos, int horas) throws PersistenceException;

    public Materia consultaActual(String nemotecnico) throws PersistenceException;

}

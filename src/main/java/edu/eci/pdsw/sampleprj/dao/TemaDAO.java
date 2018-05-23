/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Tema;
import java.util.List;

/**
 *
 * @author tatiana
 */
public interface TemaDAO {

    public void save(int materiaID, String tema, String descripcion) throws PersistenceException;

    public Tema load(int codigo) throws PersistenceException;

    public void registroTemaMonitoria(int asesoriaID, int codigoInt, Integer temaID) throws PersistenceException;

    public void delete(Integer id) throws PersistenceException;

    public void actualizarTema(int temaId, String topic, String descripcion) throws PersistenceException;

    public List<Tema> loadAllMateria(int materiaID) throws PersistenceException;


}

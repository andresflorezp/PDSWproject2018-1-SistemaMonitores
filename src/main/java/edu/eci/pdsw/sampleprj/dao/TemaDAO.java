/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Tema;

/**
 *
 * @author tatiana
 */
public interface TemaDAO {


    public void save(Tema tema) throws PersistenceException;

    public Tema load(int codigo) throws PersistenceException;

    public void registroTemaMonitoria(int monitorID, int codigoInt, Integer temaID) throws PersistenceException;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Materia;

/**
 *
 * @author tatiana
 */
public interface MateriaDAO {

    public void save(Materia materia) throws PersistenceException;

    public Materia load(int codigo) throws PersistenceException;

}


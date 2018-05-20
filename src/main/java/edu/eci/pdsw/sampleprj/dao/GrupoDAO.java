/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Grupo;
import java.util.List;

/**
 *
 * @author SergioRt
 */
public interface GrupoDAO {

    public Grupo load(Integer id) throws PersistenceException;

    public void save(Grupo grupo) throws PersistenceException;
    
    public List<Grupo> loadGruposMateria(int materiaId, int semestreID) throws PersistenceException;

}

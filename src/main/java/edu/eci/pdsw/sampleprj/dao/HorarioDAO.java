/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Horario;
import java.util.List;

/**
 *
 * @author rafaeljimenez
 */
public interface HorarioDAO {
    public void save(Horario horaio) throws PersistenceException;

    public Horario load(int codigo) throws PersistenceException;

    public List<Horario> loadAll() throws PersistenceException;
    
}

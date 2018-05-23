/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Profesor;
import java.util.List;

/**
 *
 * @author sergiort
 */
public interface ProfesorDAO {
    
    public Profesor load(long codigo) throws PersistenceException;
    
    public void save(Integer codigoID, String nombre, String apellido, String correo, Long telefono) throws PersistenceException;
    
    public List<Profesor> loadAll() throws PersistenceException;
    
    public void actualizarProfesor(Integer codigoID, String nombre, String apellido, String correo, Long telefono) throws PersistenceException;

    public void delete(Integer codigo) throws PersistenceException;
}

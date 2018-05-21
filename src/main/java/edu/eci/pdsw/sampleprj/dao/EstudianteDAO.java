/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Estudiante;
import java.util.List;

/**
 *
 * @author andres_vaz
 */
public interface EstudianteDAO {

    public Estudiante load(Long id) throws PersistenceException;

    public void save(long carnet, String nombre, int profesorID) throws PersistenceException;

    public List<Estudiante> consultarEstudiantes() throws PersistenceException;

}

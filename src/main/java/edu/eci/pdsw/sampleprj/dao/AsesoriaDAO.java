/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Asesoria;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author sergiort
 */
public interface AsesoriaDAO {

    public List<Asesoria> consultaAsesoriasMonitor(Integer monitorID, Integer semestreID) throws PersistenceException;

    public List<Asesoria> consultaAsesoriasProfesor(Integer profesorID, Integer semestreID) throws PersistenceException;

    public Asesoria load(long id) throws PersistenceException;

    public void save(Asesoria Asesoria) throws PersistenceException;

    public List<Asesoria> loadAll() throws PersistenceException;

    public void registroAsesoriaMonitor(int monitorID, String ip, Timestamp fechaInicio) throws PersistenceException;

    public List<Asesoria> consultarAsistentesProfesor(Integer profesorID, Integer semestreID) throws PersistenceException;

    public Asesoria consultaAsesoriaMonitor(int monitorID, Timestamp fechaInicio, int semestreID) throws PersistenceException;

    public void finalizarMonitoria(int asesoriaID, Timestamp fechaFin) throws PersistenceException;

}

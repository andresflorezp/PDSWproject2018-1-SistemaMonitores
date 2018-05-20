/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.samples.entities.Asesoria;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Grupo;
import edu.eci.pdsw.samples.entities.Materia;
import edu.eci.pdsw.samples.entities.Monitor;
import edu.eci.pdsw.samples.entities.Profesor;
import edu.eci.pdsw.samples.entities.Tema;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author SergioRt
 */
public interface ServiciosSistemaMonitores {
    /**
     * 
     * @param monitorID identificador del monitor.
     * @param semestreID identificador del semestre.
     * @return Consulta las asesorias dadas por in monitor en un semestre.
     * @throws ExcepcionSistemaMonitores 
     */
    public abstract List<Asesoria> consultaAsesoriaMonitor(Integer monitorID, Integer semestreID) throws ExcepcionSistemaMonitores;
    
    /**
     * 
     * @param profesorID
     * @param semestreID
     * @return 
     */
    public List<Asesoria> consultaAsesoriaProfesor(Integer profesorID, Integer semestreID) throws ExcepcionSistemaMonitores;

    /**
     * Metodo con el cual se agrega una materia al semestre
     */
    //El ID de la materia se puede automatizar
    public void addMateria(int materiaID, String nombre, String nemonico, int horas, int creditos) throws ExcepcionSistemaMonitores;

    /**
     * Metodo con el cual se agrega un estudiante
     */
    public void addEstudiante(long carnet, String nombre) throws ExcepcionSistemaMonitores;

    /**
     * Metodo con el cual se crea un grupo
     */
    //El ID del Grupo se puede automatizar
    public void addGrupo(int grupoID, int grupoNombre, int numeroEstudiantes, String Profesor) throws ExcepcionSistemaMonitores;

    /**
     * Metodo con el cual se agrega un monitor a un grupo
     */
    public void addMonitor(int grupoID, int monitorID) throws ExcepcionSistemaMonitores;

    /**
     * Metodo con el cual se inicializa el semestre
     */
    //El  ID se puede automatizar
    public void addSemetre(int ID, int anno, int periodo) throws ExcepcionSistemaMonitores;

    /**
     * Metodo con el cual se le asigna a un grupo la materia a la que pertenece
     * @param grupoID
     * @param nemonicoMatria
     * @throws ExcepcionSistemaMonitores 
     */
    public void addGrupoMateria(int grupoID, String nemonicoMatria) throws ExcepcionSistemaMonitores;
    
    /**
     * Agrega una nueva asesoria a un monitor.
     * @param monitorID
     * @throws ExcepcionSistemaMonitores 
     */
    public void addAsesoria(int monitorID, String ip) throws ExcepcionSistemaMonitores;
    
    /**
     * Agrega un registro de que un estudiante asistio a una monitoria.
     * @param asesoriaID
     * @param estudianteCarnet
     * @throws ExcepcionSistemaMonitores 
     */
    public void addAsesoriaEstudiante(int asesoriaID, int codigoInt, String observaciones, Integer profesorID) throws ExcepcionSistemaMonitores;
    
   /**
    * @param materiaId identificador de la materia.
    * @param semestreID identificador del semestre.
    * @return consulta de todos los grupos de una materia en un semestre especifico.
    */
    public List<Grupo> consultaGruposMateria(int materiaId, int semestreID) throws ExcepcionSistemaMonitores;
    
    /**
     * 
     * @param carnet carnet del estudiante.
     * @return estudiante con el carnet dado.
     * @throws ExcepcionSistemaMonitores si no existe el estudiante.
     */
    public Estudiante consultaEstudiante(long carnet) throws ExcepcionSistemaMonitores;
    
    /**
     * Agrega un tema a una asesoria.
     * @param monitorID identificador del monitor.
     * @param codigoInt carnet del estudiante.
     * @param temaID identificador del tema.
     */
    public void addTemaMonitoria(int monitorID, int codigoInt, Integer temaID) throws ExcepcionSistemaMonitores;
    
    /**
     * Metodo con el cual se cargan todas las materias       
     */
    public List<Materia> loadMaterias() throws ExcepcionSistemaMonitores;
    
    public List<HashMap> consultaMonitorias() throws ExcepcionSistemaMonitores;
    public List<HashMap> consultaCurso() throws ExcepcionSistemaMonitores;
    public List<HashMap> consultaGrupo() throws ExcepcionSistemaMonitores;
    public List<HashMap> consultaTema() throws ExcepcionSistemaMonitores; 

}

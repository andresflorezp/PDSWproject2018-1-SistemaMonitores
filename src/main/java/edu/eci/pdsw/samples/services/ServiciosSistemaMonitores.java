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
import edu.eci.pdsw.samples.entities.Horario;;
import java.sql.Timestamp;
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
     * @param carnet
     * @param nombre
     * @param profesorID
     * @throws ExcepcionSistemaMonitores
     */
    public void addEstudiante(long carnet, String nombre, int profesorID) throws ExcepcionSistemaMonitores;

    /**
     * Metodo con el cual se crea un grupo
     * @param grupoID
     * @param grupoNombre
     * @param numeroEstudiantes
     * @param Profesor
     */
    //El ID del Grupo se puede automatizar
    public void addGrupo(int grupoID, int grupoNombre, int numeroEstudiantes, String Profesor) throws ExcepcionSistemaMonitores;

    /**
     * Metodo con el cual se agrega un monitor a un grupo
     * @param codigoID
     * @param nombre
     * @param apellido
     * @param correo
     * @param telefono
     * @param semestreIngreso
     * @param programaAcademico
     * @throws ExcepcionSistemaMonitores
     */
    public void addMonitor(Integer codigoID ,String nombre, String apellido, String correo, Long telefono, String semestreIngreso, Integer programaAcademico) throws ExcepcionSistemaMonitores;

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
     * @param ip
     * @param fechaInicio
     * @throws ExcepcionSistemaMonitores 
     */
    public void addAsesoria(int monitorID, String ip, Timestamp fechaInicio) throws ExcepcionSistemaMonitores;
    
    /**
     * Agrega un registro de que un estudiante asistio a una monitoria.
     * @param asesoriaID
     * @param codigoInt
     * @param observaciones
     * @throws ExcepcionSistemaMonitores 
     */
    public void addAsesoriaEstudiante(int asesoriaID, int codigoInt, String observaciones) throws ExcepcionSistemaMonitores;
    
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
     * @param asesoriaID identificador del monitor.
     * @param codigoInt carnet del estudiante.
     * @param temaID identificador del tema.
     */
    public void addTemaMonitoria(int asesoriaID, int codigoInt, Integer temaID) throws ExcepcionSistemaMonitores;
    
    /**
     * Metodo con el cual se cargan todas las materias       
     * @throws ExcepcionSistemaMonitores
     * @return 
     */
    public List<Materia> loadMaterias() throws ExcepcionSistemaMonitores;
    
    /**
     * 
     * @return
     * @throws ExcepcionSistemaMonitores 
     */
    public List<HashMap> consultaMonitorias() throws ExcepcionSistemaMonitores;
    
    /**
     * 
     * @return
     * @throws ExcepcionSistemaMonitores 
     */
    public List<HashMap> consultaCurso() throws ExcepcionSistemaMonitores;
    
    /**
     * 
     * @return
     * @throws ExcepcionSistemaMonitores 
     */
    public List<HashMap> consultaGrupo() throws ExcepcionSistemaMonitores;
    
    /**
     * 
     * @return
     * @throws ExcepcionSistemaMonitores 
     */
    public List<HashMap> consultaTema() throws ExcepcionSistemaMonitores; 
    
    /**
     * 
     * @param profesorID
     * @param semestreID
     * @return
     * @throws ExcepcionSistemaMonitores 
     */
    public List<Asesoria> consultaAsistentesProfesor(int profesorID, int semestreID) throws ExcepcionSistemaMonitores;
    
    /**
     * 
     * @param monitorID
     * @param fechaInicio
     * @return 
     */
    public Asesoria consultaAsesoriaActualMonitor(int monitorID, Timestamp fechaInicio, int semestreID) throws ExcepcionSistemaMonitores;
    
    /**
     * 
     * @param asesoriaID
     * @param fechaFin
     * @throws ExcepcionSistemaMonitores 
     */
    public void finalizarMonitoria(int asesoriaID, Timestamp fechaFin) throws ExcepcionSistemaMonitores;
    
    /**
     * 
     * @param monitorUpdate
     * @throws ExcepcionSistemaMonitores 
     */
    public void actualizarMonitor(Monitor monitorUpdate) throws ExcepcionSistemaMonitores;
    
    /**
     * 
     * @return 
     * @throws ExcepcionSistemaMonitores 
     */
    public List<Monitor> consulatarMonitores() throws ExcepcionSistemaMonitores;
    
    /**
     * 
     * @param codigo
     * @return 
     * @throws ExcepcionSistemaMonitores 
     */
    public Monitor consulatarMonitor(Long codigo) throws ExcepcionSistemaMonitores;
    
    /**
     * 
     * @return
     * @throws ExcepcionSistemaMonitores 
     */
    public List<HashMap> consultaGrupoxTema() throws ExcepcionSistemaMonitores;
    
    /**
     * 
     * @return
     * @throws ExcepcionSistemaMonitores 
     */
    public List<HashMap> consultaCursoxMonitor() throws ExcepcionSistemaMonitores;

    /**
     * 
     * @param codigo 
     */
    public void deleteMonitor(Integer codigo) throws ExcepcionSistemaMonitores;

    public Horario loadHorarios(int codigoMateria) throws ExcepcionSistemaMonitores;

}

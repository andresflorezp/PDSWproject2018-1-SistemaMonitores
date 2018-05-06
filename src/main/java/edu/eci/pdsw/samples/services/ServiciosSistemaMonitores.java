/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Asesoria;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Grupo;
import edu.eci.pdsw.samples.entities.Profesor;
import edu.eci.pdsw.samples.entities.Tema;
import java.util.Date;
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
    public abstract List<Asesoria> consultaAsesoriaMateria(Integer monitorID, Integer semestreID) throws ExcepcionSistemaMonitores;

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
     * @param fechaInicio
     * @param fechaFin
     * @param observaciones
     * @param monitorID
     * @throws ExcepcionSistemaMonitores 
     */
    public void addAsesoria(Date fechaInicio, Date fechaFin, String observaciones, int monitorID) throws ExcepcionSistemaMonitores;
    
    /**
     * Agrega un registro de que un estudiante asistio a una monitoria.
     * @param asesoriaID
     * @param estudianteCarnet
     * @throws ExcepcionSistemaMonitores 
     */
    public void addAsesoriaEstudiante(int asesoriaID, int estudianteCarnet) throws ExcepcionSistemaMonitores;
    
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
}

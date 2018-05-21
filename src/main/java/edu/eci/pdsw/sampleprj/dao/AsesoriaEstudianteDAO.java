/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

/**
 *
 * @author sergiort
 */
public interface AsesoriaEstudianteDAO {

    public void registroAsesoriaEstudiante(int asesoriaID, int codigoInt, String observaciones, Integer profesorID) throws PersistenceException;

    public void actualizarObservacionesAsesoria(int asesoriaID, int codigoInt, String observaciones) throws PersistenceException;
}

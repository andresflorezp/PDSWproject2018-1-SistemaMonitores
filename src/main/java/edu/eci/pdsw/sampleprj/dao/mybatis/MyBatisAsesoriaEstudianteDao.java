/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.AsesoriaEstudianteDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.AsesoriaEstudianteMapper;

/**
 *
 * @author sergiort
 */
public class MyBatisAsesoriaEstudianteDao implements AsesoriaEstudianteDAO{
    
    @Inject
    private AsesoriaEstudianteMapper asesoriaEstudianteMapper;
    
    @Override
    public void registroAsesoriaEstudiante(int asesoriaID, int codigoInt, String observaciones, Integer profesorID) throws PersistenceException {
        try {
            asesoriaEstudianteMapper.registroAsesoriaEstudiante(asesoriaID, codigoInt, observaciones, profesorID);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al realizar el registro de la Asesoria para el estudiante con Carnet: "+codigoInt +"\n"+e.getMessage());
        }
    }
}

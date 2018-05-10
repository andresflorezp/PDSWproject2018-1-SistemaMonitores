/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.AsesoriaDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.AsesoriaMapper;
import edu.eci.pdsw.samples.entities.Asesoria;
import java.util.List;

/**
 *
 * @author sergiort
 */
public class MyBatisAsesoriaDao implements AsesoriaDAO {

    @Inject
    private AsesoriaMapper asesoriaMapper;

    @Override
    public List<Asesoria> consultaAsesoriasMonitor(Integer monitorID, Integer semestreID) throws PersistenceException {
        try {
            return asesoriaMapper.consultaAsesoriasMonitor(monitorID, semestreID);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al realizar la consulta de la Asesoria para el monitor con Carnet: "+monitorID+" en el semestre: "+ semestreID +"\n"+e.getMessage() );
        }

    }

    @Override
    public Asesoria load(long id) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Asesoria Asesoria) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Asesoria> loadAll() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registroAsesoriaMonitor(Integer monitorID, String ip) throws PersistenceException {
        try {
            asesoriaMapper.registroAsesoriaMonitor(monitorID, ip);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al realizar el registro de la Asesoria para el monitor con Carnet: "+monitorID +"\n"+e.getMessage());
        }
    }

    @Override
    public void registroAsesoriaEstudiante(int asesoriaID, int codigoInt, String observaciones, Integer profesorID) throws PersistenceException {
        try {
            asesoriaMapper.registroAsesoriaEstudiante(asesoriaID, codigoInt, observaciones, profesorID);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al realizar el registro de la Asesoria para el estudiante con Carnet: "+codigoInt +"\n"+e.getMessage());
        }
    }
    
}

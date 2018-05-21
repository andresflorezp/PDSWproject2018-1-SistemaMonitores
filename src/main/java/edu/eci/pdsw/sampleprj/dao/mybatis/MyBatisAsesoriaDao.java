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
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author sergiort
 */
public class MyBatisAsesoriaDao implements AsesoriaDAO, Serializable {

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
    public void registroAsesoriaMonitor(int monitorID, String ip, Timestamp fechaInicio) throws PersistenceException {
        try {
            asesoriaMapper.registroAsesoriaMonitor(monitorID, ip,fechaInicio);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al realizar el registro de la Asesoria para el monitor con Carnet: "+monitorID +"\n"+e.getMessage());
        }
    }

    @Override
    public List<Asesoria> consultaAsesoriasProfesor(Integer profesorID, Integer semestreID) throws PersistenceException {
        try {
            return asesoriaMapper.consultaAsesoriasProfesor(profesorID, semestreID);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al realizar la consulta de la Asesoria para el profesor con ID: "+profesorID+" en el semestre: "+ semestreID +"\n"+e.getMessage() );
        }
    }

    @Override
    public List<Asesoria> consultarAsistentesProfesor(Integer profesorID, Integer semestreID) throws PersistenceException {
        try {
            return asesoriaMapper.consultaAsistentesProfesor(profesorID, semestreID);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al realizar la consulta de la Asesoria para el profesor con ID: "+profesorID+" en el semestre: "+ semestreID +"\n"+e.getMessage() );
        }
    }

    @Override
    public Asesoria consultaAsesoriaMonitor(int monitorID, Timestamp fechaInicio, int semestreID) throws PersistenceException {
        try {
            return asesoriaMapper.consultaAsesoriaMonitor(monitorID, fechaInicio, semestreID);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al realizar la consulta de la Asesoria para el monitor con ID: "+monitorID+" en la fecha : "+ fechaInicio +"\n"+e.getMessage() );
        } catch (java.lang.IndexOutOfBoundsException ex) {
            throw new PersistenceException("Error al no se encontro una Asesoria para el monitor con ID: "+monitorID+" en la fecha : "+ fechaInicio +"\n"+ex.getMessage() );
        }
    }

    @Override
    public void finalizarMonitoria(int asesoriaID, Timestamp fechaFin) throws PersistenceException {
        try {
            asesoriaMapper.finalizarMonitoria(asesoriaID, fechaFin);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al finalizar la Asesoria actual con ID: "+asesoriaID+" en la fecha : "+ fechaFin +"\n"+e.getMessage() );
        }
    }
    
}

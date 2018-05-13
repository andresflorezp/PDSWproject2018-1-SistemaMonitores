/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.AsesoriaDAO;
import edu.eci.pdsw.sampleprj.dao.AsesoriaEstudianteDAO;
import edu.eci.pdsw.sampleprj.dao.EstudianteDAO;
import edu.eci.pdsw.sampleprj.dao.GrupoDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.TemaDAO;
import edu.eci.pdsw.samples.entities.Asesoria;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Grupo;
import edu.eci.pdsw.samples.entities.Profesor;
import edu.eci.pdsw.samples.entities.Tema;
import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitores;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergiort
 */
public class ServiciosSistemaMonitoresImpl implements ServiciosSistemaMonitores,Serializable {

    @Inject
    private AsesoriaDAO daoAsesoria;

    @Inject
    private GrupoDAO daoGrupo;
//    
//    @Inject
//    private MateriaDAO daoMateria;
//
    @Inject
    private TemaDAO daoTema;

    @Inject
    private EstudianteDAO daoEstudiante;

    @Inject
    private AsesoriaEstudianteDAO daoAsesoriaEstudiante;
    
    @Override
    public List<Asesoria> consultaAsesoriaMateria(Integer monitorID, Integer semestreID) throws ExcepcionSistemaMonitores {
        try {
            return daoAsesoria.consultaAsesoriasMonitor(monitorID, semestreID);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void addMateria(int materiaID, String nombre, String nemonico, int horas, int creditos) throws ExcepcionSistemaMonitores {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addEstudiante(long carnet, String nombre) throws ExcepcionSistemaMonitores {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addGrupo(int grupoID, int grupoNombre, int numeroEstudiantes, String Profesor) throws ExcepcionSistemaMonitores {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addMonitor(int grupoID, int monitorID) throws ExcepcionSistemaMonitores {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSemetre(int ID, int anno, int periodo) throws ExcepcionSistemaMonitores {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addGrupoMateria(int grupoID, String nemonicoMatria) throws ExcepcionSistemaMonitores {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Grupo> consultaGruposMateria(int materiaId, int semestreID) throws ExcepcionSistemaMonitores {
        try {
            List<Grupo> grupos = daoGrupo.loadGruposMateria(materiaId, semestreID);
            if (grupos.isEmpty()) {
                throw new ExcepcionSistemaMonitores("Error: materia con ID " + materiaId + " sin grupos en el semestre con ID " + semestreID + ".");
            }
            return grupos;
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public Estudiante consultaEstudiante(long carnet) throws ExcepcionSistemaMonitores {
        try {
            return daoEstudiante.load(carnet);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void addAsesoria(int monitorID, String ip) throws ExcepcionSistemaMonitores {
        try {
            daoAsesoria.registroAsesoriaMonitor(monitorID, ip);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void addAsesoriaEstudiante(int asesoriaID, int codigoInt, String observaciones, Integer profesorID) throws ExcepcionSistemaMonitores {
        try {
            daoAsesoriaEstudiante.registroAsesoriaEstudiante(asesoriaID, codigoInt, observaciones, profesorID);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void addTemaMonitoria(int monitorID, int codigoInt, Integer temaID) throws ExcepcionSistemaMonitores {
        try {
            daoTema.registroTemaMonitoria(monitorID, codigoInt, temaID);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public List<Asesoria> consultaAsesoriaProfesor(Integer profesorID, Integer semestreID) throws ExcepcionSistemaMonitores {
        try {
            return daoAsesoria.consultaAsesoriasProfesor(profesorID, semestreID);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.AsesoriaDAO;
import edu.eci.pdsw.sampleprj.dao.GrupoDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.samples.entities.Asesoria;
import edu.eci.pdsw.samples.entities.Grupo;
import edu.eci.pdsw.samples.entities.Profesor;
import edu.eci.pdsw.samples.entities.Tema;
import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitores;
import java.util.List;

/**
 *
 * @author sergiort
 */
public class ServiciosSistemaMonitoresImpl implements ServiciosSistemaMonitores {

    @Inject
    private AsesoriaDAO daoAsesoria;

    @Inject
    private GrupoDAO daoGrupo;
//    
//    @Inject
//    private MateriaDAO daoMateria;
//
//    @Inject
//    private TemaDAO daoTema;
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
        try{
            return daoGrupo.loadGruposMateria(materiaId, semestreID);
        }catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }
    
}

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
import edu.eci.pdsw.sampleprj.dao.MateriaDAO;
import edu.eci.pdsw.sampleprj.dao.MonitorDAO;
import edu.eci.pdsw.sampleprj.dao.HorarioDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.ProfesorDAO;
import edu.eci.pdsw.sampleprj.dao.TemaDAO;
import edu.eci.pdsw.samples.entities.Asesoria;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Grupo;
import edu.eci.pdsw.samples.entities.Horario;
import edu.eci.pdsw.samples.entities.Materia;
import edu.eci.pdsw.samples.entities.Monitor;
import edu.eci.pdsw.samples.entities.Profesor;
import edu.eci.pdsw.samples.entities.Tema;
import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitores;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author sergiort
 */
public class ServiciosSistemaMonitoresImpl implements ServiciosSistemaMonitores, Serializable {

    @Inject
    private AsesoriaDAO daoAsesoria;

    @Inject
    private GrupoDAO daoGrupo;

    @Inject
    private MateriaDAO daoMateria;

    @Inject
    private TemaDAO daoTema;

    @Inject
    private EstudianteDAO daoEstudiante;

    @Inject
    private AsesoriaEstudianteDAO daoAsesoriaEstudiante;

    @Inject
    private MonitorDAO daoMonitor;

    @Inject
    private HorarioDAO daoHorario;

    @Inject
    private ProfesorDAO daoProfesor;

    @Override
    public List<Asesoria> consultaAsesoriaMonitor(Integer monitorID, Integer semestreID) throws ExcepcionSistemaMonitores {
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
    public void addEstudiante(long carnet, String nombre, int profesorID) throws ExcepcionSistemaMonitores {
        try {
            daoEstudiante.save(carnet, nombre, profesorID);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void addGrupo(int grupoID, int grupoNombre, int numeroEstudiantes, String Profesor) throws ExcepcionSistemaMonitores {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addMonitor(Integer codigoID, String nombre, String apellido, String correo, Long telefono, String semestreIngreso, Integer programaAcademico) throws ExcepcionSistemaMonitores {
        try {
            daoMonitor.save(codigoID, nombre, apellido, correo, telefono, semestreIngreso, programaAcademico);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
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
    public void addAsesoriaEstudiante(int asesoriaID, int codigoInt, String observaciones) throws ExcepcionSistemaMonitores {
        try {
            daoAsesoriaEstudiante.registroAsesoriaEstudiante(asesoriaID, codigoInt, observaciones);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void addTemaMonitoria(int asesoriaID, int codigoInt, Integer temaID) throws ExcepcionSistemaMonitores {
        try {
            daoTema.registroTemaMonitoria(asesoriaID, codigoInt, temaID);
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

    @Override
    public List<Materia> loadMaterias() throws ExcepcionSistemaMonitores {
        try {
            return daoMateria.loadAll();
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public Horario loadHorarios(int codigoMateria) throws ExcepcionSistemaMonitores {
        try {
            return daoHorario.load(codigoMateria);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public List<HashMap> consultaMonitorias() throws ExcepcionSistemaMonitores {
        try {
            return daoMonitor.consultaMonitorias();
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public List<HashMap> consultaCurso() throws ExcepcionSistemaMonitores {
        try {
            return daoMonitor.consultaCurso();
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public List<HashMap> consultaGrupo() throws ExcepcionSistemaMonitores {
        try {
            return daoMonitor.consultaGrupo();
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public List<HashMap> consultaTema() throws ExcepcionSistemaMonitores {
        try {
            return daoMonitor.consultaTema();
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public List<Asesoria> consultaAsistentesProfesor(int profesorID, int semestreID) throws ExcepcionSistemaMonitores {
        try {
            return daoAsesoria.consultarAsistentesProfesor(profesorID, semestreID);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void addAsesoria(int monitorID, String ip, Timestamp fechaInicio) throws ExcepcionSistemaMonitores {
        try {
            daoAsesoria.registroAsesoriaMonitor(monitorID, ip, fechaInicio);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public Asesoria consultaAsesoriaActualMonitor(int monitorID, Timestamp fechaInicio, int semestreID) throws ExcepcionSistemaMonitores {
        try {
            return daoAsesoria.consultaAsesoriaMonitor(monitorID, fechaInicio, semestreID);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void finalizarMonitoria(int asesoriaID, Timestamp fechaFin) throws ExcepcionSistemaMonitores {
        try {
            daoAsesoria.finalizarMonitoria(asesoriaID, fechaFin);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void actualizarMonitor(Monitor monitorUpdate) throws ExcepcionSistemaMonitores {
        try {
            daoMonitor.actualizarMonitor(monitorUpdate.getCodigoID(), monitorUpdate.getNombre(), monitorUpdate.getApellido(),
                    monitorUpdate.getCorreo(), monitorUpdate.getTelefono(), monitorUpdate.getSemestreIngreso(), monitorUpdate.getProgramaAcademico());
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public List<Monitor> consulatarMonitores() throws ExcepcionSistemaMonitores {
        try {
            return daoMonitor.consultarMonitores();
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public Monitor consulatarMonitor(Long codigo) throws ExcepcionSistemaMonitores {
        try {
            return daoMonitor.load(codigo);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public List<HashMap> consultaGrupoxTema() throws ExcepcionSistemaMonitores {
        try {
            return daoMonitor.consultaGrupoxTema();
        }catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }
    
    @Override
    public void deleteMonitor(Integer codigo) throws ExcepcionSistemaMonitores {
        try {
            daoMonitor.delete(codigo);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }


    @Override
    public List<HashMap> consultaCursoxMonitor() throws ExcepcionSistemaMonitores {
        try {
            return daoMonitor.consultaCursoxMonitor();
        }catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }
            
    @Override
    public void addProfesor(Integer identificacion, String nombre, String apellidos, String mail, Long telefono) throws ExcepcionSistemaMonitores {
        try {
            daoProfesor.save(identificacion, nombre, apellidos, mail, telefono);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void actualizarProfesor(Profesor profesorUpdate) throws ExcepcionSistemaMonitores {
        try {
            daoProfesor.actualizarProfesor(profesorUpdate.getCodigoID(), profesorUpdate.getNombre(), profesorUpdate.getApellido(),
                    profesorUpdate.getCorreo(), profesorUpdate.getTelefono());
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public List<Profesor> consulatarProfesores() throws ExcepcionSistemaMonitores {
        try {
            return daoProfesor.loadAll();
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void deleteProfesor(Integer codigo) throws ExcepcionSistemaMonitores {
        try {
            daoProfesor.delete(codigo);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void addMateria(String nombre, String nemotecnico, Integer creditos, Integer horas) throws ExcepcionSistemaMonitores {
        try {
            daoMateria.save(nombre, nemotecnico, creditos, horas);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public Materia consultaMateriaActualRegistro(String nemotecnico) throws ExcepcionSistemaMonitores {
        try {
            return daoMateria.consultaActual(nemotecnico);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void actualizarMateria(Materia materiaUpdate) throws ExcepcionSistemaMonitores {
        try {
            daoMateria.actualizarMateria(materiaUpdate.getMateriaID(), materiaUpdate.getNombre(), materiaUpdate.getMemoico(), materiaUpdate.getCreditos(),
                    materiaUpdate.getHoras());
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public List<Materia> consulatarMaterias() throws ExcepcionSistemaMonitores {
        try {
            return daoMateria.loadAll();
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void deleteMateria(String id) throws ExcepcionSistemaMonitores {
        try {
            daoMateria.delete(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void addTema(int materiaID, String tema, String descripcion) throws ExcepcionSistemaMonitores {
        try {
            daoTema.save(materiaID, tema, descripcion);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void deleteTema(Integer id) throws ExcepcionSistemaMonitores {
        try {
            daoTema.delete(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public void actualizarTema(Tema temaUpdate) throws ExcepcionSistemaMonitores {
        try {
            daoTema.actualizarTema(temaUpdate.getTemaId(), temaUpdate.getTopic(),temaUpdate.getDescripcion());
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

    @Override
    public List<Tema> consulatarTemas(int materiaID) throws ExcepcionSistemaMonitores {
        try {
            return daoTema.loadAllMateria(materiaID);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

}

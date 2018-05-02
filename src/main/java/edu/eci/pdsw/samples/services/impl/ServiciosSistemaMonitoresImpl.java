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

//    @Inject
//    private GrupoDAO daoGrupo;
//    
//    @Inject
//    private MateriaDAO daoMateria;
//
//    @Inject
//    private TemaDAO daoTema;
    
    @Override
    public List<Asesoria> consultaAsesoriaMateria(String materiaNombre, String grupoNombre, String franjaHoraria, String tema, String numeroDeAsistentes) throws ExcepcionSistemaMonitores {
        try {
            return daoAsesoria.consultaAsesoriasMonitor(materiaNombre, grupoNombre, franjaHoraria, tema, numeroDeAsistentes==null? null: Integer.valueOf(numeroDeAsistentes));
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }
    /**
    *Metodo con el cual se agrega una materia al semestre
    */
    //El ID de la materia se puede automatizar
    public void addMateria(int materiaID,String nombre, String nemonico, int horas, int creditos)throws Exception{
        throw new UnsupportedOperationException("Not supported yet.");
    };
    
    /**
    *Metodo con el cual se agrega un estudiante
    */
    public void addEstudiante(long carnet, String nombre)throws Exception{
        throw new UnsupportedOperationException("Not supported yet.");
    };
    /**
    *Metodo con el cual se crea un grupo
    */
    //El ID del Grupo se puede automatizar
    public void addGrupo(int grupoID, int grupoNombre, int numeroEstudiantes, String Profesor)throws Exception{};
    /**
    *Metodo con el cual se agrega un monitor a un grupo
    */
    public void addMonitor(int grupoID, int monitorID)throws Exception{
        throw new UnsupportedOperationException("Not supported yet.");
    };
    /**
    *Metodo con el cual se inicializa el semestre
    */
    //El  ID se puede automatizar
    public void addSemetre(int ID,int anno, int periodo)throws Exception{
        throw new UnsupportedOperationException("Not supported yet.");
    };
    /**
    *Metodo con el cual se le asigna a un  grupo la materia a la que pertenece
    */
    public void addGrupoMateria(int grupoID, String nemonicoMatria) throws Exception{
    
    };

    
    

}

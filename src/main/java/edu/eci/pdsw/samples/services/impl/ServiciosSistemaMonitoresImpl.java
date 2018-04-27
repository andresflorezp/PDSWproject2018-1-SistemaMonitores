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
    public List<Asesoria> consultaAsesoriaMateria(String materiaNombre, String grupoNombre, String franjaHoraria, String tema) throws ExcepcionSistemaMonitores {
        try {
            return daoAsesoria.consultaAsesoriasMonitor(materiaNombre, grupoNombre, franjaHoraria, tema);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

}

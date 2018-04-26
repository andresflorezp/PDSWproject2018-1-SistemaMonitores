/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.GrupoDAO;
import edu.eci.pdsw.sampleprj.dao.MateriaDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.TemaDAO;
import edu.eci.pdsw.samples.entities.Grupo;
import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitores;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergiort
 */
public class ServiciosSistemaMonitoresImpl implements ServiciosSistemaMonitores {

    @Inject
    private GrupoDAO daoGrupo;

    @Inject
    private MateriaDAO daoMateria;

    @Inject
    private TemaDAO daoTema;

    @Override
    public List<Grupo> consultaAsesoriaMateria(Integer materiaID, Integer grupoID, Integer tema) throws ExcepcionSistemaMonitores {
        try {
            return daoGrupo.consultarGruposAsesoriaMonitor(materiaID, grupoID, tema);
        } catch (PersistenceException ex) {
            throw new ExcepcionSistemaMonitores(ex.getMessage(), ex);
        }
    }

}

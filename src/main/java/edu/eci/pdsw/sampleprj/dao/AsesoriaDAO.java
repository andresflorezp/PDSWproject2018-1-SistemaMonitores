/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Asesoria;
import java.util.List;

/**
 *
 * @author sergiort
 */
public interface AsesoriaDAO {
    public List<Asesoria> consultaAsesoriasMonitor(String materiaNombre, String grupoNombre, String franjaHoraria, String tema) throws PersistenceException;
}

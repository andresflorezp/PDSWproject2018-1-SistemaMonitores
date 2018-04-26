/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Grupo;
import java.util.List;

/**
 *
 * @author SergioRt
 */
public interface ServiciosSistemaMonitores {

    public abstract List<Grupo> consultaAsesoriaMateria(Integer materiaID, Integer grupoID, Integer tema) throws ExcepcionSistemaMonitores;

}

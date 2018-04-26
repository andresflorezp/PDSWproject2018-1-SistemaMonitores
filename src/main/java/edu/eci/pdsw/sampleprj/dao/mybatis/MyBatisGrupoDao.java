/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.GrupoDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.GrupoMapper;
import edu.eci.pdsw.samples.entities.Grupo;
import java.util.List;

/**
 *
 * @author SergioRt
 */
public class MyBatisGrupoDao implements GrupoDAO {

    @Inject
    private GrupoMapper grupoMapper;

    @Override
    public Grupo load(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Grupo grupo) throws PersistenceException {
        try {
            grupoMapper.agregarGrupo(grupo.getGrupoID(), grupo.getProfesor().getCodigoID(), grupo.getSemestre().getSemestreID(), grupo.getMateria().getCodigo(), grupo.getMonitor().getCodigoID(), grupo.getGrupoNombre(), grupo.getNumeroDeEstudiantes());
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al agregar un grupo con id: " + grupo.getGrupoID(), e);
        }
    }

    @Override
    public List<Grupo> consultarGruposAsesoriaMonitor(Integer materiaID, Integer grupoID, Integer tema) throws PersistenceException {
        try {
            return grupoMapper.ConsultaAsesoriaMateria(materiaID, grupoID, tema);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al realizar la consulta de la Asesoria para el monitor para grupoID: " + grupoID + " materiaID: " + materiaID + " temaID: " + tema, e);
        }

    }

}

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
import java.util.List;

/**
 *
 * @author sergiort
 */
public class MyBatisAsesoriaDao implements AsesoriaDAO {

    @Inject
    private AsesoriaMapper asesoriaMapper;

    @Override
    public List<Asesoria> consultaAsesoriasMonitor(String materiaNombre, String grupoNombre, String franjaHoraria, String tema, Integer numeroDeAsistentes) throws PersistenceException {
        try {
            return asesoriaMapper.consultaAsesoriasMonitor(materiaNombre, grupoNombre, franjaHoraria, tema, numeroDeAsistentes);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al realizar la consulta de la Asesoria para el monitor para grupo: " + grupoNombre + " materia: " + materiaNombre
                    + " Franja Horaria: " + franjaHoraria + " tema: " + tema, e);
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
    
}

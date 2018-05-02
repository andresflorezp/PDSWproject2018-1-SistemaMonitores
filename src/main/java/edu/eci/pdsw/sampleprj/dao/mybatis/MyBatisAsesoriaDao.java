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
    public List<Asesoria> consultaAsesoriasMonitor(Integer monitorID, Integer semestreID) throws PersistenceException {
        try {
            return asesoriaMapper.consultaAsesoriasMonitor(monitorID, semestreID);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
<<<<<<< 79e0bf62bd51b31b9dec6bc6173b062105e982db
            throw new PersistenceException("Error al realizar la consulta de la Asesoria para el monitor con Carnet: "+monitorID+" en el semestre: "+ semestreID +e.getMessage() );
=======
            throw new PersistenceException("Error al realizar la consulta de la Asesoria para el monitor con Carnet: "+monitorID+" en el semestre: "+ semestreID );
>>>>>>> Filtro por monitor y semestre
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

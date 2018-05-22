/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import edu.eci.pdsw.sampleprj.dao.HorarioDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.HorariosMapper;
import edu.eci.pdsw.samples.entities.Horario;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author rafaeljimenez
 */
public class MyBatisHorario  implements HorarioDAO{
    
    @Inject
    private HorariosMapper horarioMapper;

    @Override
    public void save(Horario horaio) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Horario load(int codigo) throws PersistenceException {
        try {
            return horarioMapper.consultarHorario(codigo);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al realizar la consulta del horario para la materia con identificador: "+codigo+e.getMessage() );
        } catch (java.lang.IndexOutOfBoundsException ex){
            throw new PersistenceException("Horario para la materia con identificador: "+codigo+" no encontrado."+ex.getMessage() );
        }
    }

    @Override
    public List<Horario> loadAll() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

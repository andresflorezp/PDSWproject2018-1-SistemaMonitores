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

/**
 *
 * @author rafaeljimenez
 */
public class MyBatisHorario  implements HorarioDAO{
    private HorariosMapper horarioMapper;

    @Override
    public void save(Horario horaio) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Horario load(int codigo) throws PersistenceException {
        return horarioMapper.consultarHorario(codigo); //To change body of generated methods, choose Tools | Templates. 
    }

    @Override
    public List<Horario> loadAll() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

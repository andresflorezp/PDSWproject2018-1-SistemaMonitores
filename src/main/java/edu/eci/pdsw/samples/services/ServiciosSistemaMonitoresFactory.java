/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import edu.eci.pdsw.sampleprj.dao.AsesoriaDAO;
import edu.eci.pdsw.sampleprj.dao.EstudianteDAO;
import edu.eci.pdsw.sampleprj.dao.GrupoDAO;
import edu.eci.pdsw.sampleprj.dao.MateriaDAO;
import edu.eci.pdsw.sampleprj.dao.TemaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisAsesoriaDao;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisEstudianteDao;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisGrupoDao;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisMateriaDao;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisTemaDao;
import edu.eci.pdsw.samples.services.impl.ServiciosSistemaMonitoresImpl;
import org.mybatis.guice.XMLMyBatisModule;

/**
 *
 * @author sergiort
 */
public class ServiciosSistemaMonitoresFactory {

    private static ServiciosSistemaMonitoresFactory instance = new ServiciosSistemaMonitoresFactory();
    private static Injector injector;

    private static Injector testInjector;

    private Injector myBatisInjector(String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setClassPathResource(pathResource);
                bind(ServiciosSistemaMonitores.class).to(ServiciosSistemaMonitoresImpl.class);
                bind(MateriaDAO.class).to(MyBatisMateriaDao.class);
                bind(EstudianteDAO.class).to(MyBatisEstudianteDao.class);
                bind(AsesoriaDAO.class).to(MyBatisAsesoriaDao.class);
                bind(TemaDAO.class).to(MyBatisTemaDao.class);
                bind(GrupoDAO.class).to(MyBatisGrupoDao.class);
            }
        });
    }

    private ServiciosSistemaMonitoresFactory() {
        injector = myBatisInjector("mybatis-config.xml");
        testInjector = myBatisInjector("h2-mybatis-config.xml");
    }

    public ServiciosSistemaMonitores getServiciosSistemaMonitores() {
        return injector.getInstance(ServiciosSistemaMonitores.class);
    }

    public ServiciosSistemaMonitores getServiciosSistemaMonitoresTesting() {
        return testInjector.getInstance(ServiciosSistemaMonitores.class);
    }

    public static ServiciosSistemaMonitoresFactory getInstance() {
        return instance;
    }
}

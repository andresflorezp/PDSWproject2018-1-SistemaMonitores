/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import edu.eci.pdsw.sampleprj.dao.AsesoriaDAO;
import edu.eci.pdsw.sampleprj.dao.AsesoriaEstudianteDAO;
import edu.eci.pdsw.sampleprj.dao.EstudianteDAO;
import edu.eci.pdsw.sampleprj.dao.GrupoDAO;
import edu.eci.pdsw.sampleprj.dao.HorarioDAO;
import edu.eci.pdsw.sampleprj.dao.MateriaDAO;
import edu.eci.pdsw.sampleprj.dao.MonitorDAO;
import edu.eci.pdsw.sampleprj.dao.ProfesorDAO;
import edu.eci.pdsw.sampleprj.dao.TemaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisAsesoriaDao;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisAsesoriaEstudianteDao;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisEstudianteDao;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisHorario;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisGrupoDao;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisMateriaDao;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisMonitorDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisProfesorDao;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisTemaDao;
import edu.eci.pdsw.samples.entities.PieChartData;
import edu.eci.pdsw.samples.managedbeans.ComboChartBean;
import edu.eci.pdsw.samples.managedbeans.KeyValue;
import edu.eci.pdsw.samples.services.impl.ServiciosSistemaMonitoresImpl;
import static java.lang.System.out;
import java.util.Arrays;
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
                bind(AsesoriaEstudianteDAO.class).to(MyBatisAsesoriaEstudianteDao.class);
                bind(HorarioDAO.class).to(MyBatisHorario.class);
                bind(MonitorDAO.class).to(MyBatisMonitorDAO.class);
                bind(ProfesorDAO.class).to(MyBatisProfesorDao.class);
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
    
    public static void main(String[] args) throws ExcepcionSistemaMonitores{
        ServiciosSistemaMonitores servicios = getInstance().getServiciosSistemaMonitores();
        //System.out.println("Entra a valor");
        out.println(servicios.consultaMonitorias());
        //out.println(servicios.consultaCurso());
        //out.println(servicios.consultaGrupo());
        //System.out.println(servicios.consultaGrupoxTema());
        ComboChartBean table = new ComboChartBean();
        //System.out.println(table.grupos);
        //System.out.println(table.temas);
        //long[][] re = table.respuestas;
        //for(long[] b:re)System.out.println(Arrays.toString(b));
        long[][] re = table.respuestas2;
        for(long[] b:re)System.out.println(Arrays.toString(b));
        
        
    }
}

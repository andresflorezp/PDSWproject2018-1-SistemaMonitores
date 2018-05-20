///**
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
//*/
//import edu.eci.pdsw.samples.entities.Estudiante;
//import edu.eci.pdsw.samples.entities.Grupo;
//import edu.eci.pdsw.samples.entities.Materia;
//import edu.eci.pdsw.samples.entities.Monitor;
//import edu.eci.pdsw.samples.entities.Tema;
//import edu.eci.pdsw.samples.services.impl.ServiciosSistemaMonitoresImpl;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.quicktheories.core.Gen;
//import static org.quicktheories.QuickTheory.qt;
//import static org.quicktheories.generators.Generate.*;
//import static org.quicktheories.generators.SourceDSL.*;
///**
// *
// * @author rafaeljimenez
//*/
//public class sistemaMonitoresTest {
//
//    public sistemaMonitoresTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @Test
//    /*
//     * no se debe permitir generar materias con el mismo ID
//    */
//    public void noDebeExistirDosMateriasConElMismoID() {
//      ServiciosSistemaMonitoresImpl services =  new  ServiciosSistemaMonitoresImpl();
//        String aux = "";
//        try {
//          services.addMateria(1,"Programacion Orientada a Objetos", "POOB", 5, 4);
//          services.addMateria(1,"Programacion Orientada a Objetos", "POOB", 5, 4);
//        } catch (Exception e) {
//            aux = e.getMessage();
//        }
//        assertTrue(aux.equals("Ya existe una materia con ese ID"));
//    }

//    @Test
//    /*
//     * no se debe permitir que dos estudiantes tengan el mismo carnet
//    */
//    public void noDebePermitirDosEstudiantesMismoCarnet() {
//      ServiciosSistemaMonitoresImpl services =  new  ServiciosSistemaMonitoresImpl();
//        String aux = "";
//        try {
//          services.addEstudiante(2087476L,"Andres");
//          services.addEstudiante(2087476L,"Karen");
//        } catch (Exception e) {
//            aux = e.getMessage();
//        }
//        assertTrue(aux.equals("Ya existe un estudiante con ese ID"));
//    }
//    @Test
//    /*
//     * Un monitor puede tener maximo dos grupos asignados al mismo tiempo.
//    */
//    public void NoDebedeTenerMasDeDosMonitorias() {
//      ServiciosSistemaMonitoresImpl services =  new  ServiciosSistemaMonitoresImpl();
//        String aux = "";
//        try {
//            services.addGrupo(1, 1, 25, "profesor");
//            services.addGrupo(2, 2, 25, "profesor");
//            services.addGrupo(3, 3, 25, "profesor");
//           
//            services.addEstudiante(2087476,"Andres");
//            services.addMonitor(1,2087476);
//            services.addMonitor(2,2087476);
//            services.addMonitor(3,2087476);
//        } catch (Exception e) {
//            aux = e.getMessage();
//        }
//        assertTrue(aux.equals("La carga de monitoria solo permite maximo dos grupos"));
//    }
//    @Test
//    /*
//     * Un grupo solo puede pertencer a una materia
//    */
//    public void unGrupoSoloPerteneceAUnaMateria() {
//      ServiciosSistemaMonitoresImpl services =  new  ServiciosSistemaMonitoresImpl();
//        String aux = "";
//        try {
//          services.addMateria(1,"Programacion Orientada a Objetos", "POOB", 5, 4);
//          services.addMateria(2,"Proceso de Desarrollo de Software", "PDSW", 5, 4);
//          services.addGrupo(1, 1, 25, "profesor");
//          services.addGrupoMateria(1,"POOB");
//          services.addGrupoMateria(1,"PDSW");
//        } catch (Exception e) {
//            aux = e.getMessage();
//        }
//        assertTrue(aux.equals("Ese grupo ya tiene una materia vinculada"));
//
//    }
//    @Test
//    /*
//    *No se puede adicionar dos semestres con el mismo periodo periodoAcademico
//    */
//    public void noDosSemetresAlmismoTiempo(){
//      ServiciosSistemaMonitoresImpl services =  new  ServiciosSistemaMonitoresImpl();
//      String aux = "";
//      try {
//        services.addSemetre(1,2018,1);
//        services.addSemetre(1,2018,1);
//
//      } catch(Exception e) {
//          aux = e.getMessage();
//      }
//        assertTrue(aux.equals("Ese grupo ya tiene una materia vinculada"));
//    }
//    @After
//    public void tearDown() {
//    }
//}

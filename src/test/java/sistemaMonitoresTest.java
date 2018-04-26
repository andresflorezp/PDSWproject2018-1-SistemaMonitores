///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//import edu.eci.pdsw.samples.entities.Estudiante;
//import edu.eci.pdsw.samples.entities.Grupo;
//import edu.eci.pdsw.samples.entities.Materia;
//import edu.eci.pdsw.samples.entities.Monitor;
//import edu.eci.pdsw.samples.entities.Tema;
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
//
///**
// *
// * @author rafaeljimenez
// */
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
//    /**
//     * no se debe permitir generar materias con el mismo ID
//     */
//    public void noDebeExistirDosMateriasConElMismoID() {
//        String aux = null;
//        try {
//            Materia m = poblar();
//            Materia m2 = poblar();
//        } catch (Exception e) {
//            aux = e.getMessage();
//        }
//        aux.equals("Ya existe una materia con ese ID");
//    }
//
//    @Test
//    /**
//     * no se debe permitir que dos estudiantes tengan el mismo carnet
//     */
//    public void noDebePermitirDosEstudiantesMismoCarnet() {
//        String aux = null;
//        try {
//            Estudiante a = new Estudiante(2087476, "Andres");
//            Estudiante k = new Estudiante(2087476, "Karen");
//
//        } catch (Exception e) {
//            aux = e.getMessage();
//        }
//        aux.equals("Ya existe un estudiante con ese ID");
//
//    }
//
//    @Test
//    /**
//     * Un monitor puede tener maximo dos grupos asignados al mismo tiempo.
//     */
//    public void NoDebedeTenerMasDeDosMonitorias() {
//        String aux = null;
//        Monitor mo = new Monitor(2087476, "Andres", "Duran", "andres@mail.com", 1232344, 20161, 14);
//        Grupo g = new Grupo(1, "PIMO2", 0, mo);
//        Grupo g1 = new Grupo(2, "PIMO2", 0, mo);
//        Grupo g2 = new Grupo(3, "PIMO2", 0, mo);
//        try {
//            mo.addGrupo(g);
//            mo.addGrupo(g1);
//            mo.addGrupo(g2);
//        } catch (Exception e) {
//            aux = e.getMessage();
//        }
//        aux.equals("no se puede adicionar mas de dos grupos a un monitor");
//
//    }
//
//    @Test
//    /**
//     * Todo Grupo debe apuntar a la una materia y debe ser la misma que lo tiene
//     * asignado
//     */
//    public void elGrupoDebeApuntarAlaMateria() {
//        Materia m = poblar();
//        List<Grupo> g = m.getGrupos();
//        assertTrue(g.get(0).getMateria() == m);
//    }
//
//    @Test
//    /**
//     * Un grupo no debe estar en dos materas diferentes
//     */
//    public void unGrupoSoloPerteneceAUnaMateria() {
//        String aux = null;
//        try {
//            Materia m = poblar();
//            List<Grupo> g = m.getGrupos();
//            Materia m1 = new Materia(1, "Programacion Orientada a Objetos", "PIMO", 4, g, m.getTemas());
//        } catch (Exception e) {
//            aux = e.getMessage();
//        }
//        aux.equals("Ese grupo ya tiene una materia vinculada");
//
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    private Materia poblar() {
//        ArrayList<String> topics = new ArrayList<>();
//        ArrayList<Tema> temas = new ArrayList<>();
//        ArrayList<Grupo> grupos = new ArrayList<>();
//
//        /**
//         * Tema
//         */
//        topics.add("Pilas");
//        topics.add("Colas");
//        topics.add("Listas encadenadas");
//        Tema t1 = new Tema(1, "Estructuras de Datos", topics, "Estructuras para el manejo de datos");
//        temas.add(t1);
//        /**
//         * Monitor
//         */
//        Monitor mo = new Monitor(2087476, "Andres", "Duran", "andres@mail.com", 1232344, 20161, 14);
//        /**
//         * Grupos
//         */
//        Grupo g = new Grupo(1, "PIMO2", 0, mo);
//        grupos.add(g);
//
//        Materia m1 = new Materia(1, "Programacion Orientada a Objetos", "PIMO", 4, grupos, temas);
//        g.setMateria(m1);
//        return m1;
//    }
//}


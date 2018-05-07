
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Asesoria;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Grupo;
import edu.eci.pdsw.samples.entities.Materia;
import edu.eci.pdsw.samples.entities.Tema;
import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitoresFactory;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Tatiana
 */
@ManagedBean(name = "RegistroAsistencia")
@SessionScoped
public class RegistrarAsistEstudianteBean implements Serializable {

    ServiciosSistemaMonitores sp = ServiciosSistemaMonitoresFactory.getInstance().getServiciosSistemaMonitores();
    
    private final int monitorID = 2; //temporal se supone se sabe de el login.

    private List<String> codigos;
    private String profesor;
    private String obseraciones;
    private List<String> profesoresSelected;
    private AbstractSet<String> profesores;
    private AbstractSet<String> temas;
    private List<String> temasSelected;
    private List<Grupo> gruposMateriaSemestre;
    private Asesoria asesoriaActual;

    public RegistrarAsistEstudianteBean() throws ExcepcionSistemaMonitores {
        profesoresSelected = new ArrayList<>();
        consultarGrupos();
        agregarAsesoria();
        Logger.getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(Level.SEVERE, "\n\n\n\n\n------------Creo un nuevoRegistoBean------------\n\n\n\n");

    }

    public void agregarAsesoria() throws ExcepcionSistemaMonitores {
//        sp.addAsesoria(obseraciones, monitorID);
//        asesoriaActual =;
    }

    public void agregarAsesoriaEstudiante() throws ExcepcionSistemaMonitores {
        Logger.getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(Level.SEVERE, (codigos==null)+"");
        for (String codigo : codigos) {
            int codigoInt = Integer.parseInt(codigo);
            sp.consultaEstudiante(codigoInt);
//            sp.addAsesoriaEstudiante(asesoriaActual.getAsesoriaID(), codigoInt);
        }
    }

    public void consultarGrupos() throws ExcepcionSistemaMonitores {
        temas = new HashSet<>();
        profesores = new HashSet<>();
        gruposMateriaSemestre = sp.consultaGruposMateria(0, 1);
        for (Grupo g : gruposMateriaSemestre) {
            profesores.add(g.getProfesor().getNombre());
        }
        for (Tema t : gruposMateriaSemestre.get(0).getMateria().getTemas()) {
            temas.add(t.getTopic());
        }
    }

    public List<String> getTemasSelected() {
        return temasSelected;
    }

    public void setTemasSelected(List<String> temasSelected) {
        this.temasSelected = temasSelected;
    }

    public List<String> getProfesoresSelected() {
        return profesoresSelected;
    }

    public void setProfesoresSelected(List<String> profesoresSelected) {
        this.profesoresSelected = profesoresSelected;
    }

    public AbstractSet<String> getProfesores() {
        return profesores;
    }

    public void setProfesores(AbstractSet<String> profesores) {
        this.profesores = profesores;
    }

    public AbstractSet<String> getTemas() {
        return temas;
    }

    public void setTemas(AbstractSet<String> temas) {
        this.temas = temas;
    }

    public List<String> getCodigos() {
        Logger.getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(Level.SEVERE, "--->\n\n\n\n\n get codigos: "+codigos+"\n\n\n\n\n");
        return codigos;
    }

    public void setCodigos(List<String> codigos) {
        Logger.getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(Level.SEVERE, "--->\n\n\n\n\n Pido codigos: "+codigos+"\n\n\n\n\n");
        this.codigos = codigos;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getObseraciones() {
        return obseraciones;
    }

    public void setObseraciones(String obseraciones) {
        this.obseraciones = obseraciones;
    }

}

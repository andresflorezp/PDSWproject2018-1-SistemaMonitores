package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Asesoria;
import edu.eci.pdsw.samples.entities.Grupo;
import edu.eci.pdsw.samples.entities.Tema;
import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitoresFactory;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
    private int asesoriaID = 2; //temporal se supone se sabe de el login.

    private List<String> codigos;
    private String profesor;
    private String observaciones;
    private String profesorSelected;
    private Map<String, Integer> profesores;
    private Map<String, Integer> temas;
    private List<String> temasSelected;
    private List<Grupo> gruposMateriaSemestre;

    public RegistrarAsistEstudianteBean() throws ExcepcionSistemaMonitores {
        consultarGrupos();
        agregarAsesoria();
        Logger.getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(Level.SEVERE, "\n\n\n\n\n------------Creo un nuevoRegistoBean------------\n\n\n\n");

    }

    public String getIp() throws ExcepcionSistemaMonitores {
        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                NetworkInterface n = (NetworkInterface) e.nextElement();
                Enumeration ee = n.getInetAddresses();
                while (ee.hasMoreElements()) {
                    InetAddress i = (InetAddress) ee.nextElement();
                    if (i.getHostAddress().startsWith("10.") || i.getHostAddress().startsWith("192.") || i.getHostAddress().startsWith("172.")) {
                        return i.getHostAddress();
                    }
                }
            }
        } catch (SocketException ex) {
            throw new ExcepcionSistemaMonitores("Error encontrando la direccion ip.");
        }
        throw new ExcepcionSistemaMonitores("Ip no encontrada.");
    }

    public void agregarAsesoria() throws ExcepcionSistemaMonitores {

        System.out.println();
//        sp.addAsesoria(monitorID,getIp());
//        asesoriaActual =;
    }

    public void agregarAsesoriaEstudiante() throws ExcepcionSistemaMonitores {
        Logger.getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(Level.SEVERE, (codigos == null) + "");
        for (String codigo : codigos) {
            int codigoInt = Integer.parseInt(codigo);
            sp.consultaEstudiante(codigoInt);
            sp.addAsesoriaEstudiante(asesoriaID, codigoInt, observaciones, profesores.get(profesorSelected));
            for (String tem : temasSelected) {
                sp.addTemaMonitoria(monitorID, codigoInt, temas.get(tem));
            }
        }
    }

    public void consultarGrupos() throws ExcepcionSistemaMonitores {
        temas = new HashMap<>();
        profesores = new HashMap<>();
        gruposMateriaSemestre = sp.consultaGruposMateria(0, 1);
        for (Grupo g : gruposMateriaSemestre) {
            profesores.put(g.getProfesor().getNombre(), g.getProfesor().getCodigoID());
        }
        for (Tema t : gruposMateriaSemestre.get(0).getMateria().getTemas()) {
            temas.put(t.getTopic(), t.getTemaId());
        }
    }

    public List<String> getTemasSelected() {
        return temasSelected;
    }

    public void setTemasSelected(List<String> temasSelected) {
        this.temasSelected = temasSelected;
    }

    public String getProfesorSelected() {
        return profesorSelected;
    }

    public void setProfesorSelected(String profesorSelected) {
        this.profesorSelected = profesorSelected;
    }

    public Set<String> getProfesores() {
        return profesores.keySet();
    }

    public void setProfesores(Map<String, Integer> profesores) {
        this.profesores = profesores;
    }

    public Set<String> getTemas() {
        return temas.keySet();
    }

    public void setTemas(Map<String, Integer> temas) {
        this.temas = temas;
    }

    public List<String> getCodigos() {
        return codigos;
    }

    public void setCodigos(List<String> codigos) {
        this.codigos = codigos;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}

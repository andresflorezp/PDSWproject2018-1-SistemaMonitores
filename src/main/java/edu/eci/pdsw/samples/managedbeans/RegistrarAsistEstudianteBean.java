package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Asesoria;
import edu.eci.pdsw.samples.entities.Grupo;
import edu.eci.pdsw.samples.entities.Tema;
import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitores;
import static edu.eci.pdsw.samples.services.ServiciosSistemaMonitoresFactory.getInstance;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import static java.lang.Integer.parseInt;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author Sergio
 */
@ManagedBean(name = "RegistroAsistencia")
@SessionScoped
public class RegistrarAsistEstudianteBean implements Serializable {

    ServiciosSistemaMonitores sp = getInstance().getServiciosSistemaMonitores();

    private final int monitorID = 2; //temporal se supone se sabe de el login.
    private final int semestreID = 1; //temporal se supone se sabe de el login.

    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private List<String> codigos;
    private String profesor;
    private String observaciones;
    private Integer carnetActual;
    private String profesorSelected;
    private Map<String, Integer> profesores;
    private Map<String, Integer> temas;
    private List<String> temasSelected;
    private List<Grupo> gruposMateriaSemestre;
    private Asesoria asesoriaActual;
    private String nombreRegisro;

    public RegistrarAsistEstudianteBean() throws ExcepcionSistemaMonitores {
        if (MonitorBean.getShowDoS()) {
            agregarAsesoria();
            getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(SEVERE, "\n\n\n\n\n------------Registro nuevo------------\n\n\n\n");
        }
        consultarGrupos();
        getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(SEVERE, "\n\n\n\n\n------------Creo un nuevoRegistoBean------------\n\n\n\n");

    }

    public String getIp() throws ExcepcionSistemaMonitores {
        try {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(
                        whatismyip.openStream()));
                String ip = in.readLine();
                return ip;
            } catch (IOException ex) {
                Logger.getLogger(RegistrarAsistEstudianteBean.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }   catch (MalformedURLException ex) {
            throw new ExcepcionSistemaMonitores("Error encontrando la direccion ip.");
        }
        throw new ExcepcionSistemaMonitores("Ip no encontrada.");
    }
    
    public void finMonitoria() throws ExcepcionSistemaMonitores{
        fechaFin = new Timestamp(new java.util.Date().getTime());
        sp.finalizarMonitoria(asesoriaActual.getAsesoriaID(), fechaFin);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Monitoria Finalizada",fechaFin.toString()));
    }
    
    public void agregarEstudiante() throws ExcepcionSistemaMonitores{
        sp.addEstudiante(carnetActual, nombreRegisro, profesores.get(profesorSelected));
        save("Estudiante registrado.");
    }
    
    public void agregarAsesoria() throws ExcepcionSistemaMonitores {
        fechaInicio = new Timestamp(new java.util.Date().getTime());
        sp.addAsesoria(monitorID, getIp(), fechaInicio);
        asesoriaActual = sp.consultaAsesoriaActualMonitor(monitorID, fechaInicio, semestreID);
        getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(SEVERE, "Ip: " + getIp() + " Hora ls " + (new java.util.Date().getTime()) + " date " + fechaInicio + "\n" + asesoriaActual.toString());
    }

    public void agregarAsesoriaEstudiante() throws ExcepcionSistemaMonitores {
        for (String codigo : codigos) {
            carnetActual = parseInt(codigo);
            sp.consultaEstudiante(carnetActual);
            sp.addAsesoriaEstudiante(asesoriaActual.getAsesoriaID(), carnetActual, observaciones);
            for (String tem : temasSelected) {
                sp.addTemaMonitoria(asesoriaActual.getAsesoriaID(), carnetActual, temas.get(tem));
            }
        }
        asesoriaActual = sp.consultaAsesoriaActualMonitor(monitorID, fechaInicio, semestreID);
        save("Registro realizado.");
    }

    public void consultarGrupos() throws ExcepcionSistemaMonitores {
        temas = new HashMap<>();
        profesores = new HashMap<>();
        gruposMateriaSemestre = sp.consultaGruposMateria(asesoriaActual.getGrupo().getMateria().getMateriaID(), semestreID);
        for (Grupo g : gruposMateriaSemestre) {
            profesores.put(g.getProfesor().getNombre(), g.getProfesor().getCodigoID());
        }
        for (Tema t : gruposMateriaSemestre.get(0).getMateria().getTemas()) {
            temas.put(t.getTopic(), t.getTemaId());
        }
    }

    public void onCellEdit(CellEditEvent event) throws ExcepcionSistemaMonitores {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            int row = event.getRowIndex();
            int carnet = asesoriaActual.getAsesoriasEstudiante().get(row).getEstudianteID();
            sp.addAsesoriaEstudiante(asesoriaActual.getAsesoriaID(), carnet,(String) newValue);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Celda Actualizada", "Antigua: " + oldValue + ", Nueva:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void save(String text) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(text));
    }
    
    public void limpiar(){
        codigos = null;
        observaciones = null;
        temasSelected = null;
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

    public Asesoria getAsesoriaActual() {
        return asesoriaActual;
    }

    public void setAsesoriaActual(Asesoria asesoriaActual) {
        this.asesoriaActual = asesoriaActual;
    }

    public String getNombreRegisro() {
        return nombreRegisro;
    }

    public void setNombreRegisro(String nombreRegisro) {
        this.nombreRegisro = nombreRegisro;
    }
   
}

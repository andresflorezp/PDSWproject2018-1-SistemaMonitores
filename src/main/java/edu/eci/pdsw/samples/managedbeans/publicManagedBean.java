/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Horario;
import edu.eci.pdsw.samples.entities.Materia;
import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitoresFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rafaeljimenez
 */
@ManagedBean(name = "publicBean")
@SessionScoped
public class publicManagedBean implements Serializable {

    ServiciosSistemaMonitores sp = ServiciosSistemaMonitoresFactory.getInstance().getServiciosSistemaMonitores();
    private String materia;

    private List<Horario> horarios;
    private List<String> lunes;
    private List<String> martes;
    private List<String> miercoles;
    private List<String> jueves;
    private List<String> viernes;
    private List<String> sabado;
    private List<Materia> materias;
    private List<String> nombresMaterias;
    private String NombreMateriaSelected;

    public publicManagedBean() throws ExcepcionSistemaMonitores {
        nombresMaterias = new ArrayList<>();
        loadMateria();
        horarios = new ArrayList<>();
        ArrayList<String> aux = new ArrayList<>();
        aux.add("700-830");
        aux.add("830-1000");
        aux.add("1000-1130");
        aux.add("1130-1300");
        aux.add("1300-1430");
        aux.add("1430-1600");
        aux.add("1600-1730");
        aux.add("1730-1900");
        for (int i = 0; i < 8; i++) {
            if (i == 1) {
                horarios.add(new Horario(aux.get(i), "C1-205", "", "", "", "", "", "PDSW"));
            } else if (i == 4) {
                horarios.add(new Horario(aux.get(i), "", "", "C1-205", "", "", "", "PDSW"));
            } else {
                horarios.add(new Horario(aux.get(i), "", "", "", "", "", "", ""));

            }

        }
    }

    public void consultar() {
        Logger.getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(Level.SEVERE, "Entro");
    }

    public String getNombreMateriaSelected() {
        return NombreMateriaSelected;
    }

    public void setNombreMateriaSelected(String NombreMateriaSelected) {
        this.NombreMateriaSelected = NombreMateriaSelected;
    }

    public List<String> getNombresMaterias() {
        for (Materia val : materias) {
            nombresMaterias.add(val.getNombre());
        }
        return nombresMaterias;
    }

    public void setNombresMaterias(List<String> nombresMaterias) {
        this.nombresMaterias = nombresMaterias;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    private void loadMateria() throws ExcepcionSistemaMonitores {
        materias = sp.loadMaterias();
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public List<String> getLunes() {
        return lunes;
    }

    public void setLunes(List<String> lunes) {
        this.lunes = lunes;
    }

    public List<String> getMartes() {
        return martes;
    }

    public void setMartes(List<String> martes) {
        this.martes = martes;
    }

    public List<String> getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(List<String> miercoles) {
        this.miercoles = miercoles;
    }

    public List<String> getJueves() {
        return jueves;
    }

    public void setJueves(List<String> jueves) {
        this.jueves = jueves;
    }

    public List<String> getViernes() {
        return viernes;
    }

    public void setViernes(List<String> viernes) {
        this.viernes = viernes;
    }

    public List<String> getSabado() {
        return sabado;
    }

    public void setSabado(List<String> sabado) {
        this.sabado = sabado;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

}

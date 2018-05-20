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
import static edu.eci.pdsw.samples.services.ServiciosSistemaMonitoresFactory.getInstance;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rafaeljimenez
 */
@ManagedBean(name = "publicBean")
@SessionScoped
public class publicManagedBean implements Serializable {

    ServiciosSistemaMonitores sp = getInstance().getServiciosSistemaMonitores();  
    private Map<String, Materia> mapMaterias;
    private List<Horario> horarios;
    private List<Materia> materias;
    private List<String> nombresMaterias;
    private String nombreMateriaSelected;

    public publicManagedBean() throws ExcepcionSistemaMonitores {
        mapMaterias = new HashMap<>();
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
            horarios.add(new Horario(aux.get(i), "", "", "", "", "", "", ""));
        }
    }
    public void consultar() {
        horarios.clear();
        ArrayList<String> aux = new ArrayList<>();
        aux.add("700-830");
        aux.add("830-1000");
        aux.add("1000-1130");
        aux.add("1130-1300");
        aux.add("1300-1430");
        aux.add("1430-1600");
        aux.add("1600-1730");
        aux.add("1730-1900");
        String a = "1lunes,martes,miercoles,jueves,viernes,sabado]2lunes,martes,miercoles,jueves,viernes,sabado]3lunes,martes,miercoles,jueves,viernes,sabado]4lunes,martes,miercoles,jueves,viernes,sabado]5lunes,martes,miercoles,jueves,viernes,sabado]6lunes,martes,miercoles,jueves,viernes,sabado]7lunes,martes,miercoles,jueves,viernes,sabado]8lunes,martes,miercoles,jueves,viernes,sabado]";
        String[] b = a.split("]");
        for (int i = 0; i < 8; i++) {
            String[] horario = b[i].split(",");
            if(i<4){
                horarios.add(new Horario(aux.get(i), horario[0], horario[1],horario[2],horario[3],horario[4],horario[5],mapMaterias.get(nombreMateriaSelected).getMemoico()));
            }else{
                horarios.add(new Horario(aux.get(i), horario[0], horario[1],horario[2],horario[3],horario[4],"",mapMaterias.get(nombreMateriaSelected).getMemoico()));  
            }
            
            }
        }

    public String getNombreMateriaSelected() {
        return nombreMateriaSelected;
    }

    public void setNombreMateriaSelected(String NombreMateriaSelected) {
        this.nombreMateriaSelected = NombreMateriaSelected;
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
    private void loadMateria() throws ExcepcionSistemaMonitores {
        materias = sp.loadMaterias();
        for (int i =0; i<materias.size();i++){
            mapMaterias.put(materias.get(i).getNombre(), materias.get(i));
        }
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

}

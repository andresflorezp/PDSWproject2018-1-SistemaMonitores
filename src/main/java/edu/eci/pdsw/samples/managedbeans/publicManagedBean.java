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
import java.util.List;
import java.util.Map;
import java.util.HashMap;
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
    private Map<String, Materia> mapMaterias;
    private List<Horario> horarios;

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
    private List<Materia> materias;
    private List<String> nombresMaterias;
    private String nombreMateriaSelected;
    private int codigoMateria;
    private Horario horario;
    

    public publicManagedBean() throws ExcepcionSistemaMonitores {
        nombreMateriaSelected =" ";
        materias = new  ArrayList<>();
        nombresMaterias = new ArrayList<>();
        mapMaterias = new HashMap<>();
        horarios = new ArrayList<>();
        loadMateria();
        loadHorario();
    }
    public void consultar() throws ExcepcionSistemaMonitores {
        if(!horarios.isEmpty()){
            horarios.clear();
        }
        loadHorario();
        ArrayList<String> aux = new ArrayList<>();
        aux.add("700-830");
        aux.add("830-1000");
        aux.add("1000-1130");
        aux.add("1130-1300");
        aux.add("1300-1430");
        aux.add("1430-1600");
        aux.add("1600-1730");
        aux.add("1730-1900");
        String a = horario.getDescripcion();
        String[] b = a.split("]");
        for (int i = 0; i < 8; i++) {
            String[] aux2 = b[i].split(",");
            if(i<4){
                horarios.add(new Horario(aux.get(i), aux2[0], aux2[1],aux2[2],aux2[3],aux2[4],aux2[5],mapMaterias.get(nombreMateriaSelected).getMemoico()));
            }else{
                horarios.add(new Horario(aux.get(i), aux2[0], aux2[1],aux2[2],aux2[3],aux2[4],"",mapMaterias.get(nombreMateriaSelected).getMemoico()));  
            }
            
        }
        
    }

    public Map<String, Materia> getMapMaterias() {
        return mapMaterias;
    }

    public void setMapMaterias(Map<String, Materia> mapMaterias) {
        this.mapMaterias = mapMaterias;
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
        nombreMateriaSelected = materias.get(0).getNombre();
        nombreMateriaSelected=materias.get(0).getNombre();
        for (int i =0; i<materias.size();i++){
            mapMaterias.put(materias.get(i).getNombre(), materias.get(i));
        }
    }
    
    private void loadHorario() throws ExcepcionSistemaMonitores {
        horario = sp.loadHorarios(mapMaterias.get(nombreMateriaSelected).getMateriaID());
    }
    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    

}

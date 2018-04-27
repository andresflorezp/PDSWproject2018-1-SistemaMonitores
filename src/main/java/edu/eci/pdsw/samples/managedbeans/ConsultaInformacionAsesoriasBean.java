/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Asesoria;
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
 * @author sergiort
 */
@ManagedBean(name = "InformacionAsesorias")
@SessionScoped
public class ConsultaInformacionAsesoriasBean implements Serializable{

    ServiciosSistemaMonitores sp = ServiciosSistemaMonitoresFactory.getInstance().getServiciosSistemaMonitores();

    private List<String> selectedFiltro;
    private List<String> optionsFiltro;
    private List<String> selectedOptions;
    private List<Asesoria> asesorias;
    private String[] selectedFiltroNoNull;

    public ConsultaInformacionAsesoriasBean() throws ExcepcionSistemaMonitores {
        optionsFiltro = new ArrayList<>();
        selectedFiltroNoNull = new String[5];
        optionsFiltro.add("Materia");
        optionsFiltro.add("Grupo");
        optionsFiltro.add("Franja horaria");
        optionsFiltro.add("Tema");
        optionsFiltro.add("Número de asitentes");
        filtrar();
    }

    private void nullable() throws ExcepcionSistemaMonitores {
        int act = 0;
        if (selectedOptions == null && (selectedFiltro == null || (selectedFiltro != null && selectedFiltro.size()==0)))return; 
        if (selectedOptions == null || selectedFiltro == null) throw new ExcepcionSistemaMonitores("La lista de argumentos está vacia.");
        for (int i = 0; i < 5; i++) {
            if (act == selectedOptions.size()) throw new ExcepcionSistemaMonitores("El numero de argumentos ingresados es menor a las opciones de filtro.");
            selectedFiltroNoNull[i] = (optionsFiltro.get(i).equals(selectedFiltro.get(act)) ? selectedOptions.get(act++) : null);
            if (act == selectedFiltro.size())
                act--;
        }
    }

    public void filtrar() throws ExcepcionSistemaMonitores {
        try{
            nullable();
        }catch(java.lang.IndexOutOfBoundsException e){
            throw new ExcepcionSistemaMonitores("El numero de argumentos ingresados no es valido o no coincide con las opciones de filtro.");
        }
        Logger.getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(Level.SEVERE,"\nNull: " + Arrays.toString(selectedFiltroNoNull));
        asesorias = sp.consultaAsesoriaMateria(selectedFiltroNoNull[0], selectedFiltroNoNull[1], selectedFiltroNoNull[2], selectedFiltroNoNull[3], selectedFiltroNoNull[4]);
        Logger.getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(Level.SEVERE,"\nAns: " + asesorias);

    }

    public List<String> getSelectedFiltro() {
        return selectedFiltro;
    }

    public void setSelectedFiltro(List<String> selectedFiltro) {
        this.selectedFiltro = selectedFiltro;
    }

    public List<String> getOptionsFiltro() {
        return optionsFiltro;
    }

    public void setOptionsFiltro(List<String> optionsFiltro) {
        this.optionsFiltro = optionsFiltro;
    }

    public List<String> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(List<String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public List<Asesoria> getAsesorias() {
        return asesorias;
    }

    public void setAsesorias(List<Asesoria> asesorias) {
        this.asesorias = asesorias;
    }

}

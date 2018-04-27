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
public class ConsultaInformacionAsesoriasBean {

    ServiciosSistemaMonitores sp = ServiciosSistemaMonitoresFactory.getInstance().getServiciosSistemaMonitores();

    private List<String> selectedFiltro;
    private List<String> optionsFiltro;
    private List<String> selectedOptions;
    private List<Asesoria> asesorias;
    private String[] selectedFiltroNoNull;

    public ConsultaInformacionAsesoriasBean() {
        optionsFiltro = new ArrayList<>();
        selectedFiltroNoNull = new String[5];
        optionsFiltro.add("Materia");
        optionsFiltro.add("Grupo");
        optionsFiltro.add("Franja horaria");
        optionsFiltro.add("Tema");
        optionsFiltro.add("Número de asitentes");
    }

    private void nullable() {
        int act = 0;
        for (int i = 0; i < 5; i++) {
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
        Logger.getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(Level.SEVERE, "Filtro:" + selectedFiltro.toString() + "\nArgumentos:" + selectedOptions.toString() + "\nAns: " + Arrays.toString(selectedFiltroNoNull));
//           sp.consultaAsesoriaMateria(selectedFiltro[0], selectedFiltro[1], selectedFiltro[2], selectedFiltro[3], selectedFiltro[4]);
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

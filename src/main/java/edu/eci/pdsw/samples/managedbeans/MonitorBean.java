/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Registro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2135494
 */
@ManagedBean(name = "MonitorMonitoria")
@SessionScoped
public class MonitorBean implements Serializable{
    private String Franja;
    private String Fecha;
    private List<Registro> registros;
    private String codigoEstudiante;
    private String profesor;
    private String Observaciones;
    private String horaActual;
    private String horaTerminacion;
    private Calendar hora = Calendar.getInstance(Locale.ENGLISH);
    private String horas,minutos,segundos;
    public MonitorBean(){
        registros = new ArrayList();
    }

   
    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        this.Fecha = fecha;
    }
     public void guardarRegistro(){
        registros.add(new Registro(Fecha,Franja));

    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getFranja() {
        return Franja;
    }

    public void setFranja(String Franja) {
        this.Franja = Franja;
    }

    public String getHoraActual() {
        return getHoras()+":"+getMinutos()+":"+getSegundos();
    }

    public void setHoraActual(String horaActual) {
        this.horaActual = horaActual;
    }

    public String getHoraTerminacion() {
        return String.valueOf((Integer.parseInt(getHoras())+1)%24)+":"+String.valueOf((Integer.parseInt(getMinutos())+30)%60)+":"+getSegundos();
    }

    public void setHoraTerminacion(String horaTerminacion) {
        this.horaTerminacion = horaTerminacion;
    }

    public String getHoras() {
        return String.valueOf(hora.get(Calendar.HOUR_OF_DAY)-5);
        
                
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getMinutos() {
        return String.valueOf(hora.get(Calendar.MINUTE));
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public String getSegundos() {
        return String.valueOf(hora.get(Calendar.SECOND));
    }

    public void setSegundos(String segundos) {
        this.segundos = segundos;
    }
    
    
    
}

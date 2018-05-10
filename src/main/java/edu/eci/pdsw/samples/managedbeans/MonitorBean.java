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
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
    private TimeZone timeZone1 = TimeZone.getTimeZone("America/Mexico_City");
    private Calendar hora = new GregorianCalendar();
    private int numberHour;
    private int numberMinute;
    private int numberSecond;
    
    private String horas,minutos,segundos;
    private boolean showDo;
    private boolean showDoT;
    public MonitorBean(){
        registros = new ArrayList();
        hora.setTimeZone(timeZone1);
        numberHour = 1;
        numberMinute = 30;
        numberSecond= 59;
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


    public String getHoras() {
        return String.valueOf(hora.get(Calendar.HOUR_OF_DAY));
        
                
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
    
 

    public void doAction(){
      showDo=true;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public boolean getShowDo() {
        return showDo;
    }

    public void setShowDo(boolean showDo) {
        this.showDo = showDo;
    }
    
    public void messageLogOut() {
        addMessage("Saliendo de la Monitoria", "Gracias por usar la Plataforma");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public TimeZone getTimeZone1() {
        return timeZone1;
    }

    public void setTimeZone1(TimeZone timeZone1) {
        this.timeZone1 = timeZone1;
    }

    public int getNumberHour() {
        return numberHour;
    }

    public void setNumberHour(int numberHour) {
        this.numberHour = numberHour;
    }

    public int getNumberMinute() {
        return numberMinute;
    }

    public void setNumberMinute(int numberMinute) {
        this.numberMinute = numberMinute;
    }

    public int getNumberSecond() {
        return numberSecond;
    }

    public void setNumberSecond(int numberSecond) {
        this.numberSecond = numberSecond;
    }
    
    public void decrement(){
        if(numberSecond==0 && numberMinute==0 && numberHour==0 && !showDoT){
            doActionT();
 
        }
        else if(numberSecond==0 && numberMinute==0 && !showDoT){
            numberHour-=1;
            numberSecond=59;
            
        }
        else if(numberSecond==0 && !showDoT){
            numberSecond=59;
            numberMinute-=1;
        }
        else if(!showDoT){
            numberSecond-=1;
        }
            
        
    }

    public boolean getShowDoT() {
        return showDoT;
    }

    public void setShowDoT(boolean showDoT) {
        this.showDoT = showDoT;
    }
    public void doActionT(){
      showDoT=true;
    }
    
    
}

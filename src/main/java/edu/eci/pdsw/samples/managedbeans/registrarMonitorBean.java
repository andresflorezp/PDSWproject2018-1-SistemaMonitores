/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;


import java.io.Serializable;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rafaeljimenez
 */
@ManagedBean(name = "monitorBean")
@SessionScoped
public class registrarMonitorBean implements Serializable{
	private int codigo;
	private int telefono;
	private String nombres;
	private String apellidos;
	private String mail;
	private String semestreIngreso;
	private String facultad;

public void setCodigo(int codigo){
		this.codigo = codigo;
	}

	public registrarMonitorBean(){
		codigo = 0;
		telefono=0;
		nombres="";
		apellidos="";
		mail="";
		semestreIngreso="";
		facultad="";

	}

	public void registrarMonitor(){

		getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(SEVERE, "Entro");
	}

	public int getCodigo(){
		return codigo;
	}
	public void setTelefono(int telefono){
		this.telefono = telefono;
	}

	public int getTelefono(){
		return telefono;
	}

	public void setNombres(String nombres){
		this.nombres = nombres;
	}

	public String getNombres(){
		return nombres;

	}

	public void setApellidos(String apellidos){
		this.apellidos=apellidos;
	}

	public String getApellidos(){
		return apellidos;
		
	}
	public void setMail(String mail){
		this.mail= mail;
	}
	public String getMail(){
		return mail;
	}
	public void setSemestreIngreso(String semestreIngreso){
		this.semestreIngreso = semestreIngreso;
	}
	public String getSemestreIngreso(){
		return semestreIngreso;
	}

	public void setFacultad(String facultad){
		this.facultad = facultad;
	}
	public String getFacultad(){
		return facultad;
	}

}
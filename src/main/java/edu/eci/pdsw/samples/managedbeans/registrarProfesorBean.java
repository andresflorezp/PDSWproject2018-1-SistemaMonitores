/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;


import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitoresFactory;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rafaeljimenez
 */
@ManagedBean(name = "profesorBean")
@SessionScoped

public class registrarProfesorBean implements Serializable {
	private int identificacion;
	private int telefono;
	private String nombres;
	private String apellidos;
	private String mail;

	public registrarProfesorBean(){
		identificacion = 0;
		telefono = 0;
		nombres = "";
		apellidos = "";
		mail= "";
	}
	public void registrarProfesor(){

		Logger.getLogger(ConsultaInformacionAsistentesBean.class.getName()).log(Level.SEVERE, "Entro");
	}

	public void setIdentificacion(int identificacion){
		this.identificacion = identificacion;
	}

	public int getIdentificacion(){
		return identificacion;
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

}
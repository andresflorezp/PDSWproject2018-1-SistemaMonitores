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
@ManagedBean(name = "registrarMateria")
@SessionScoped

public class registrarMateriaBean implements Serializable {
	private int id;
	private String nombre;
	private String nemotecnico;
	private int creditos;
	private int horas;

	public registrarMateriaBean(){
		id =0;
		creditos = 0;
		horas = 0;
	}

	public int getId(){
		return id;
	}

	public int getCreditos(){
		return creditos;
	}

	public int getHoras(){
		return horas;
	}

	public String getNombre(){
		return nombre;
	}

	public String getNemotecnico(){
		return nemotecnico;
	}

	public void setId(int id){
		this.id = id;
	}

	public void setCreditos(int creditos){
		this.creditos = creditos;
	}

	public void setHoras(int horas){
		this.horas = horas;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public void setNemotecnico(String nemotecnico){
		this.nemotecnico= nemotecnico;
	}


}
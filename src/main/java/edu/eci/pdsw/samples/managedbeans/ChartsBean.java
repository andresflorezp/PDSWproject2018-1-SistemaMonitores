/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Andres
 */
@ManagedBean(name="charts")
@ViewScoped

public class ChartsBean {
    private String[][] lista;

    public ChartsBean() {
        this.lista = new String[][]{{"item1","2"}, {"item1","2"}, {"item1","2"}, {"item1","2"}};
    }

    public String[][] getLista() {
        return lista;
    }

    public void setLista(String[][] lista) {
        this.lista = lista;
    }
    
    
    
    
    
  
    
    
}

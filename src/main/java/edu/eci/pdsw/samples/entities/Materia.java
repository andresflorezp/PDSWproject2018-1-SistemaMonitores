/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.util.List;

/**
 *
 * @author Tatiana
 */
public class Materia {
    private List<String> planEstudios;
    private int codigo;
    private String materia;
    private String memoico;
    private int horas;
    private List<String> grupos;

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getMemoico() {
        return memoico;
    }

    public void setMemoico(String memoico) {
        this.memoico = memoico;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public List<String> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<String> grupos) {
        this.grupos = grupos;
    }
    
    
    public List<String> getPlanEstudios(){
        return planEstudios;
    }
    
    public void adicionarGrupos(String grp){
        grupos.add(grp);
    }
    
    public void adicionarTema(String tm){
        planEstudios.add(tm);
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
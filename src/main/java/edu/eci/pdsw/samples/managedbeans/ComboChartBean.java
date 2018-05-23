/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.PieChartData;
import edu.eci.pdsw.samples.services.ExcepcionSistemaMonitores;
import edu.eci.pdsw.samples.services.ServiciosSistemaMonitores;
import static edu.eci.pdsw.samples.services.ServiciosSistemaMonitoresFactory.getInstance;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Andres
 */
@ManagedBean(name="comboChart")
@ViewScoped
public class ComboChartBean {
    private String comboChartXtema;
    public ServiciosSistemaMonitores servicios;
    public List<HashMap> consultaXTema;
    public List<String> grupos;
    public List<String> temas;
    public long [][] respuestas;
    public ArrayList<ArrayList<String>> gen;
    
    private String comboChartXmonitor;
    public List<HashMap> consultaXmonitor;
    public List<String> monitores;
    public List<String> cursos;
    public long [][] respuestas2;
    public ArrayList<ArrayList<String>> gen2;
    
    public ComboChartBean() throws ExcepcionSistemaMonitores{
        servicios = getInstance().getServiciosSistemaMonitores();
        consultaXTema = servicios.consultaGrupoxTema();
        consultaXmonitor = servicios.consultaCursoxMonitor();
        initTema();
        initCurso();
        
    }
    public void initTema(){
        grupos = new ArrayList<>();
        temas = new ArrayList<>();
        
        for (int i = 0; i < consultaXTema.size(); i++) {
            String grupo = "grupo "+consultaXTema.get(i).get("grupo");
            if (!grupos.contains(grupo)){
                grupos.add(grupo);
            }
            String tema = (String) consultaXTema.get(i).get("tema");
            if (!temas.contains(tema)){
                temas.add(tema);
            }
 
        }
        respuestas = new long[temas.size()][grupos.size()];
        for (int i = 0; i < temas.size(); i++) {
            for (int j = 0; j < grupos.size(); j++) {
                String grupo = "grupo "+consultaXTema.get(i).get("grupo");
                String tema = (String) consultaXTema.get(i).get("tema");
                if (temas.get(i).equals(tema) && grupos.get(j).equals(grupo)){
                    respuestas[i][j]= (long) consultaXTema.get(i).get("numero_asesorias");

                }

            }
        }
        long [] asistenciasTotales = new long[temas.size()];
        for (int i = 0; i < temas.size(); i++) {
            long resp = 0;
            for (int j = 0; j < grupos.size(); j++) {
                resp+=respuestas[i][j];
  
            }
            asistenciasTotales[i]=resp;
            
        }
        
        gen = new ArrayList();
        for(int i=0;i<temas.size()+1;i++){
            gen.add(new ArrayList());
        
        }
        gen.get(0).add("'Tema'");
        gen.get(0).add("'Asistencia'");
        for(String k:grupos){
            gen.get(0).add("'"+k+"'");
        }
        for(int k=0;k<temas.size();k++){
            gen.get(k+1).add("'"+temas.get(k)+"'");
        }
        for (int i = 1; i < temas.size()+1; i++) {
            gen.get(i).add(asistenciasTotales[i-1]+"");
            for (int j = 0; j < grupos.size(); j++) {
                    
                   gen.get(i).add(respuestas[i-1][j]+"");

                }
                
                
         }
        
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < gen.size(); i++) {
            stringBuilder.append("[");
            for (int j = 0; j < gen.get(0).size(); j++) {
                
                stringBuilder.append(gen.get(i).get(j));
                stringBuilder.append(","); 
            }
            stringBuilder.append("]");
            stringBuilder.append(",");
         }
  
        comboChartXtema = stringBuilder.toString().substring(0,
        stringBuilder.toString().length() - 1);
    

    
    }
    
    public void initCurso(){
        monitores = new ArrayList<>();
        cursos = new ArrayList<>();
        
        for (int i = 0; i < consultaXmonitor.size(); i++) {
            String monitor = ""+consultaXmonitor.get(i).get("monitor");
            if (!monitores.contains(monitor)){
                monitores.add(monitor);
            }
            String curso = (String) consultaXmonitor.get(i).get("materia");
            if (!cursos.contains(curso)){
                cursos.add(curso);
            }
 
        }
        respuestas2 = new long[cursos.size()][monitores.size()];
        for (int i = 0; i < cursos.size(); i++) {
            for (int j = 0; j < monitores.size(); j++) {
                String monitor = ""+consultaXmonitor.get(i).get("monitor");
                String curso = (String) consultaXmonitor.get(i).get("materia");
                if (cursos.get(i).equals(curso) && monitores.get(j).equals(monitor)){
                    respuestas2[i][j]= (long) consultaXmonitor.get(i).get("numero_asesorias");

                }

            }
        }
        long [] asistenciasTotales2 = new long[cursos.size()];
        for (int i = 0; i < cursos.size(); i++) {
            long resp = 0;
            for (int j = 0; j < monitores.size(); j++) {
                resp+=respuestas2[i][j];
  
            }
            asistenciasTotales2[i]=resp;
            
        }
        
        gen2 = new ArrayList();
        for(int i=0;i<cursos.size()+1;i++){
            gen2.add(new ArrayList());
        
        }
        gen2.get(0).add("'Materia'");
        gen2.get(0).add("'Asistencia'");
        for(String k:monitores){
            gen2.get(0).add("'"+k+"'");
        }
        for(int k=0;k<cursos.size();k++){
            gen2.get(k+1).add("'"+cursos.get(k)+"'");
        }
        for (int i = 1; i < cursos.size()+1; i++) {
            gen2.get(i).add(asistenciasTotales2[i-1]+"");
            for (int j = 0; j < monitores.size(); j++) {
                    
                   gen2.get(i).add(respuestas2[i-1][j]+"");

                }
                
                
         }
        
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < gen2.size(); i++) {
            stringBuilder.append("[");
            for (int j = 0; j < gen2.get(0).size(); j++) {
                
                stringBuilder.append(gen2.get(i).get(j));
                stringBuilder.append(","); 
            }
            stringBuilder.append("]");
            stringBuilder.append(",");
         }
  
        comboChartXmonitor = stringBuilder.toString().substring(0,
        stringBuilder.toString().length() - 1);
    

    
    }

    public String getComboChartXtema() {
        return comboChartXtema;
    }

    public void setComboChartXtema(String comboChartXtema) {
        this.comboChartXtema = comboChartXtema;
    }

    public ServiciosSistemaMonitores getServicios() {
        return servicios;
    }

    public void setServicios(ServiciosSistemaMonitores servicios) {
        this.servicios = servicios;
    }

    public List<HashMap> getConsultaXTema() {
        return consultaXTema;
    }

    public void setConsultaXTema(List<HashMap> consultaXTema) {
        this.consultaXTema = consultaXTema;
    }

    public List<String> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<String> grupos) {
        this.grupos = grupos;
    }

    public List<String> getTemas() {
        return temas;
    }

    public void setTemas(List<String> temas) {
        this.temas = temas;
    }

    public long[][] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(long[][] respuestas) {
        this.respuestas = respuestas;
    }

    public ArrayList<ArrayList<String>> getGen() {
        return gen;
    }

    public void setGen(ArrayList<ArrayList<String>> gen) {
        this.gen = gen;
    }

    public String getComboChartXmonitor() {
        return comboChartXmonitor;
    }

    public void setComboChartXmonitor(String comboChartXmonitor) {
        this.comboChartXmonitor = comboChartXmonitor;
    }

    public List<HashMap> getConsultaXmonitor() {
        return consultaXmonitor;
    }

    public void setConsultaXmonitor(List<HashMap> consultaXmonitor) {
        this.consultaXmonitor = consultaXmonitor;
    }

    public List<String> getMonitores() {
        return monitores;
    }

    public void setMonitores(List<String> monitores) {
        this.monitores = monitores;
    }

    public List<String> getCursos() {
        return cursos;
    }

    public void setCursos(List<String> cursos) {
        this.cursos = cursos;
    }

    public long[][] getRespuestas2() {
        return respuestas2;
    }

    public void setRespuestas2(long[][] respuestas2) {
        this.respuestas2 = respuestas2;
    }

    public ArrayList<ArrayList<String>> getGen2() {
        return gen2;
    }

    public void setGen2(ArrayList<ArrayList<String>> gen2) {
        this.gen2 = gen2;
    }
    
    
}

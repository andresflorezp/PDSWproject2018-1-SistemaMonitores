/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.util.List;

/**||
 *
 * @author Tatiana
 */
public class Tema {
    private int temaId;
    private String topic;
    private List<String> topics;
    private String Descripcion;
    
    public Tema(int temID, String tpic,String desc){
        
    }

    public int getTemId() {
        return temaId;
    }

    public void setTemId(int temId) {
        this.temaId = temId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }
    public void adicionarTopic(String tpc){
        topics.add(tpc);
    }
    
}
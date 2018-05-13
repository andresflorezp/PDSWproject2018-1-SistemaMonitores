/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * ||
 *
 * @author Tatiana
 */
public class Tema implements Serializable {

    private int temaId;
    private String topic;
    private List<String> topics;
    private String descripcion;

    public Tema() {
    }

    public Tema(int temaId, String topic, List<String> topics, String descripcion) {
        this.temaId = temaId;
        this.topic = topic;
        this.topics = topics;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return topic;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tema) {
            return this.getTemaId() == ((Tema) obj).getTemaId();
        } else {
            return super.equals(obj);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.temaId;
        return hash;
    }

    public int getTemaId() {
        return temaId;
    }

    public void setTemaId(int temaId) {
        this.temaId = temaId;

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
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void adicionarTopic(String tpc) {
        topics.add(tpc);
    }

}

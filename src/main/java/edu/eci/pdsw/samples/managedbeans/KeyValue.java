/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

/**
 *
 * @author Andres
 */
public class KeyValue {
        String key;
        String value;

    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }
    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "[Grupo"+key+","+"numeroMonitorias"+value+"]";
    }
    

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

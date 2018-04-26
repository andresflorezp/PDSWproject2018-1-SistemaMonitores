/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

/**
 *
 * @author sergiort
 */
public class ExcepcionSistemaMonitores extends Exception {

    public ExcepcionSistemaMonitores() {
    }

    public ExcepcionSistemaMonitores(String message) {
        super(message);
    }

    public ExcepcionSistemaMonitores(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcepcionSistemaMonitores(Throwable cause) {
        super(cause);
    }

}

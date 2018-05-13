/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.dataModel;

import edu.eci.pdsw.samples.entities.Asesoria;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.SortOrder;

/**
 *
 * @author sergiort
 */
public class LazySorter implements Comparator<Asesoria> {

    private String sortField;

    private SortOrder sortOrder;

    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(Asesoria asesoria1, Asesoria asesoria2) {
        try {
            
            Object value1 = LazyAsesoriaDataModel.runGetter(sortField, asesoria1);
            Object value2 = LazyAsesoriaDataModel.runGetter(sortField, asesoria2);     
            
            int value = ((Comparable) value1).compareTo(value2);
            
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        } catch (SecurityException ex) {
            Logger.getLogger(LazySorter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(LazySorter.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return 0;
    }
}

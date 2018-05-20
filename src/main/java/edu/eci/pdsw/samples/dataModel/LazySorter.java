/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.dataModel;

import static edu.eci.pdsw.samples.dataModel.LazyAsesoriaDataModel.runGetter;
import edu.eci.pdsw.samples.entities.Asesoria;
import java.util.Comparator;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import org.primefaces.model.SortOrder;
import static org.primefaces.model.SortOrder.ASCENDING;

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
            
            Object value1 = runGetter(sortField, asesoria1);
            Object value2 = runGetter(sortField, asesoria2);     
            
            int value = ((Comparable) value1).compareTo(value2);
            
            return ASCENDING.equals(sortOrder) ? value : -1 * value;
        } catch (SecurityException | IllegalArgumentException ex) {
            getLogger(LazySorter.class.getName()).log(SEVERE, null, ex);
        } 
        return 0;
    }
}

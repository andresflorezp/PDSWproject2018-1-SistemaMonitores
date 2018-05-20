/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.dataModel;

import edu.eci.pdsw.samples.entities.Asesoria;
import edu.eci.pdsw.samples.managedbeans.ConsultaInformacionAsistentesBean;
import static java.lang.String.valueOf;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import java.lang.reflect.Method;
import java.util.AbstractCollection;
import static java.util.Collections.sort;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author sergiort
 */
public class LazyAsesoriaDataModel extends LazyDataModel<Asesoria> {

    private List<Asesoria> datasource;

    public LazyAsesoriaDataModel(List<Asesoria> datasource) {
        this.datasource = datasource;
    }

    public static Object runGetter(String fullField, Object o) {
        String field = "";
        String[] classpath = fullField.split("\\.");
        if (classpath.length <= 1) {
            try {
                Field campo = o.getClass().getDeclaredField(fullField);
                campo.setAccessible(true);
                return campo.get(o);
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException ex) {
                getLogger(LazyAsesoriaDataModel.class.getName()).log(SEVERE, null, ex);
            }
        } else {
            field = classpath[0];
        }
        fullField = fullField.substring(field.length() + 1);
        for (Method method : o.getClass().getMethods()) {
            if ((method.getName().startsWith("get")) && (method.getName().length() == (field.length() + 3))) {
                if (method.getName().toLowerCase().endsWith(field.toLowerCase())) {
                    try {
                        return runGetter(fullField, method.invoke(o));
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                        getLogger(LazyAsesoriaDataModel.class.getName()).log(SEVERE, null, ex);
                    }

                }
            }
        }

        return null;
    }

    @Override
    public Asesoria getRowData(String rowKey) {
        for (Asesoria asesoria : datasource) {
            if (valueOf(asesoria.getAsesoriaID()).equals(rowKey)) {
                return asesoria;
            }
        }
        return null;
    }

    @Override
    public Object getRowKey(Asesoria asesoria) {
        return asesoria.getAsesoriaID();
    }

    @Override
    public List<Asesoria> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        List<Asesoria> data = new ArrayList<>();

        //filter
        for (Asesoria asesoria : datasource) {
            boolean match = true;

            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        Object value = runGetter(filterProperty, asesoria);
                        String fieldValue;
                        if (value != null && (value instanceof AbstractCollection)) {
                            if (filterValue == null) {
                                match = true;
                            } else {
                                match = false;
                                AbstractCollection ArrayVale = (AbstractCollection)value;
                                for (Object element: ArrayVale) {
                                    fieldValue = element.toString();
                                    match |= fieldValue.startsWith(filterValue.toString());
                                    if (match) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            fieldValue = valueOf(value);
                            if (filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                                match = true;
                            } else {
                                match = false;
                                break;
                            }
                        }
                    } catch (Exception e) {
                        match = false;
                    }
                }
            }

            if (match) {
                data.add(asesoria);
            }
        }
        //sort
        if (sortField != null) {
            sort(data, new LazySorter(sortField, sortOrder));
        }

        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate
        if (dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            } catch (IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        } else {
            return data;
        }
    }

    @Override
    public String toString() {
        String ans = "DataModel:\n";
        for (Asesoria asesoria : datasource) {
            ans += asesoria.toString() + "\n";
        }
        return ans + "END\n";

    }

}

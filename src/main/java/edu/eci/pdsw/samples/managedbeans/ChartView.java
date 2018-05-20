/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;


 
import org.primefaces.model.chart.DonutChartModel;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import static org.primefaces.model.chart.AxisType.X;
import static org.primefaces.model.chart.AxisType.Y;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean(name="chartView")

public class ChartView implements Serializable {
 
    private DonutChartModel donutModel1;
    private DonutChartModel donutModel2;
    private LineChartModel lineModel1;
    private LineChartModel lineModel2;
 
    @PostConstruct
    public void init() {
        createDonutModels();
        createLineModels();
    }
 
    public DonutChartModel getDonutModel1() {
        return donutModel1;
    }
     
    public DonutChartModel getDonutModel2() {
        return donutModel2;
    }
     
    private void createDonutModels() {
        donutModel1 = initDonutModel();
        donutModel1.setTitle("Informe");
        donutModel1.setLegendPosition("w");
         
        donutModel2 = initDonutModel();
        donutModel2.setTitle("Custom Options");
        donutModel2.setLegendPosition("e");
        donutModel2.setSliceMargin(5);
        donutModel2.setShowDataLabels(true);
        donutModel2.setDataFormat("value");
        donutModel2.setShadow(false);
    }
 
    private DonutChartModel initDonutModel() {
        DonutChartModel model = new DonutChartModel();
         
        Map<String, Number> circle1 = new LinkedHashMap<>();
        circle1.put("Inacistencia", 150);
        circle1.put("Monitor 1", 400);
        circle1.put("Monitor 2", 200);
        circle1.put("Monitor 3", 10);
        model.addCircle(circle1);
         
        Map<String, Number> circle2 = new LinkedHashMap<>();
        circle2.put("Inacistencia", 150);
        circle2.put("Monitor 1", 400);
        circle2.put("Monitor 2", 200);
        circle2.put("Monitor 3", 10);
        model.addCircle(circle2);
         
        Map<String, Number> circle3 = new LinkedHashMap<>();
        circle3.put("Inacistencia", 150);
        circle3.put("Monitor 1", 400);
        circle3.put("Monitor 2", 200);
        circle3.put("Monitor 3", 10);
        model.addCircle(circle3);
         
        return model;
   }
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
 
    public LineChartModel getLineModel2() {
        return lineModel2;
    }
     
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Linear Chart");
        lineModel1.setLegendPosition("e");
        lineModel1.setAnimate(true);
        Axis yAxis = lineModel1.getAxis(Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
         
        lineModel2 = initCategoryModel();
        lineModel2.setTitle("Category Chart");
        lineModel2.setLegendPosition("e");
        lineModel2.setAnimate(true);
        lineModel2.setShowPointLabels(true);
        lineModel2.getAxes().put(X, new CategoryAxis("Years"));
        yAxis = lineModel2.getAxis(Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
 
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
 
        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);
 
        model.addSeries(series1);
        model.addSeries(series2);
         
        return model;
    }
     
    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 90);
        girls.set("2008", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
         
        return model;
    }
    
}
    
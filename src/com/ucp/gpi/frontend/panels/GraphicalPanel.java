package com.ucp.gpi.frontend.panels;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphicalPanel extends JPanel {

    public GraphicalPanel() {
        final XYSeries series = new XYSeries("Satisfaction");
        final XYSeriesCollection dataset = new XYSeriesCollection(series);
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        //a retirer 
        series.add(1, 4);
        series.add(3, 9);
        series.add(4, 4);
        series.add(2, 2);
        
        
        //doit prendre en paramettre la station pour laquelle il faut afficher les stats
        /*
         ArrayList<Integer> dataArray = station.getStatistiques().getTrain_occupation();
         for(int i; i<dataArray.size(); i++){
         	series.add(i, dataArray.get(i));
         }
         * */

        renderer.setSeriesPaint(0, Color.decode("#F44336"));
        renderer.setSeriesShapesVisible(0, true);

        JFreeChart statsChart = ChartFactory.createXYLineChart("Stats", "Abscisses", "Ordonnees", dataset, PlotOrientation.VERTICAL, true, false, false);

        ((XYPlot) statsChart.getPlot()).setRenderer(renderer);
        statsChart.getPlot().setBackgroundPaint(Color.decode("#3C3F41"));
        statsChart.setBackgroundPaint(Color.decode("#3C3F41"));
        statsChart.getTitle().setPaint(Color.WHITE);

        ((XYPlot) statsChart.getPlot()).getDomainAxis().setLabelPaint(Color.WHITE);
        ((XYPlot) statsChart.getPlot()).getRangeAxis().setLabelPaint(Color.WHITE);
        ((XYPlot) statsChart.getPlot()).getRangeAxis().setTickLabelPaint(Color.WHITE);
        ((XYPlot) statsChart.getPlot()).getDomainAxis().setTickLabelPaint(Color.WHITE);

        ChartPanel gPanel = new ChartPanel(statsChart);

        this.add(gPanel);
    }
}

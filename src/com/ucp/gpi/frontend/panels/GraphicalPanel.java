package com.ucp.gpi.frontend.panels;

import com.ucp.gpi.backend.model.RailwayNetwork;
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
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GraphicalPanel extends JPanel {

    public static Lock lock = new ReentrantLock();
    private static int counter = 0;
    final XYSeries series = new XYSeries("Satisfaction");
    final XYSeriesCollection dataset = new XYSeriesCollection(series);
    final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
    private ArrayList<ArrayList<Integer>> arrayList, arrayList2;

    public GraphicalPanel() {

        renderer.setSeriesPaint(0, Color.decode("#F44336"));
        renderer.setSeriesShapesVisible(0, false);

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

    public void setData(RailwayNetwork railwayNetwork) {
        if (counter++ % 1000 != 0)
            return;
        arrayList = railwayNetwork.getLines().get(0).getStatistique().getPopEvolution();
        dataset.removeAllSeries();

        for (int i = 0; i < arrayList.size(); i++) {
            XYSeries series = new XYSeries(railwayNetwork.getLines().get(0).getStations().get(i).getStationName());
            for (int j = 0; j < arrayList.get(i).size(); j++)
                series.add(j, arrayList.get(i).get(j));
            renderer.setSeriesShapesVisible(i, false);
            dataset.addSeries(series);
        }
    }
}

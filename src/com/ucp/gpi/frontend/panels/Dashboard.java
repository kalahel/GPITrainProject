package com.ucp.gpi.frontend.panels;

import com.ucp.gpi.frontend.data.Canton;
import com.ucp.gpi.frontend.data.Station;
import com.ucp.gpi.frontend.data.TrainLine;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Dashboard extends JPanel {

    private final Color LINE_COLOR = Color.decode("#29B6F6");
    private final Color STATION_COLOR = Color.decode("#FFA726");
    public static final int DB_SIZE_X = 1000;
    public static final int DB_SIZE_Y = 400;

    private boolean[][] adjacencyMatrix;
    private ArrayList<Station> stationsArray;
    private ArrayList<Canton> cantonArray;
    private ArrayList<TrainLine> trainLineArray;
    private static final int STATION_SIZE = 15;

    public Dashboard() {
        this.adjacencyMatrix = matrixGeneration();
        this.stationsArray = positionGeneration();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        printLine(g2);
        paintStations(g2);
    }

    /**
     * Draw lines between station according to the adjacency matrix
     *
     * @param g2 2d Graphics
     */
    private void printLine(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(LINE_COLOR);
        g2.setStroke(new BasicStroke(2));

        for (int primaryIndex = 0; primaryIndex <= adjacencyMatrix.length; primaryIndex++)
            for (int secondaryIndex = primaryIndex; secondaryIndex < adjacencyMatrix.length; secondaryIndex++)
                if (adjacencyMatrix[primaryIndex][secondaryIndex])
                    g2.drawLine(stationsArray.get(primaryIndex).getPosX(), stationsArray.get(primaryIndex).getPosY(), stationsArray.get(secondaryIndex).getPosX(), stationsArray.get(secondaryIndex).getPosY());
    }

    /**
     * Draw a line representing each canton
     * TODO add an arrow to specify the direction of the canton
     *
     * @param g2 2d Graphics
     */
    private void paintCanton(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(193, 186, 35));
        for (Canton canton : this.cantonArray)
            g2.drawLine(canton.getInternalStation().getPosX(), canton.getInternalStation().getPosY(), canton.getExternalStation().getPosX(), canton.getExternalStation().getPosY());

    }

    /**
     * Draw a circle for each station according to its position, add on top its number
     *
     * @param g2 2d Graphics
     */
    private void paintStations(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(4));
        for (int index = 0; index < this.stationsArray.size(); index++) {
            g2.setColor(STATION_COLOR);
            g2.drawOval(stationsArray.get(index).getPosX() - (STATION_SIZE / 2), stationsArray.get(index).getPosY() - (STATION_SIZE / 2), STATION_SIZE, STATION_SIZE);
            g2.setColor(Color.WHITE);
            g2.drawString("" + (index + 1), stationsArray.get(index).getPosX(), stationsArray.get(index).getPosY() - STATION_SIZE);
        }

    }


    /**
     * Generate an array of random positions for each station
     *
     * @return Array of position of every station
     */
    private ArrayList<Station> positionGeneration() {
        ArrayList<Station> positionsToReturn = new ArrayList<>();
        int randomPosX, randomPosY;

        for (boolean b[] : this.adjacencyMatrix) {
            randomPosX = ThreadLocalRandom.current().nextInt(30, DB_SIZE_X + 1 - 30);
            randomPosY = ThreadLocalRandom.current().nextInt(30, DB_SIZE_Y + 1 - 30);
            positionsToReturn.add(new Station(randomPosX, randomPosY));
        }

        return positionsToReturn;
    }

    /**
     * Used to generate a predefined matrix
     *
     * @return 2d boolean Adjacency matrix
     */
    private boolean[][] matrixGeneration() {
        return new boolean[][]{
                {true, true, false, false, false},
                {false, true, true, false, false},
                {false, false, true, true, false},
                {false, false, false, true, true},
                {true, false, false, false, true}
        };
    }

}

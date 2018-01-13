package frontend;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Dashboard extends JPanel {

    private boolean[][] adjacencyMatrix;
    private ArrayList<StationPosition> stationsPositions;
    private static final int START_X = 20;
    private static final int START_Y = 150;
    private static final int STATION_SIZE = 20;

    public Dashboard() {
        this.adjacencyMatrix = matrixGeneration();
        this.stationsPositions = postionGeneration();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //printLine(g2);
        paintStations(g2);
        printLine(g2);
    }

    private void printLine(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(2));
        for (int primaryIndex = 0; primaryIndex <= adjacencyMatrix.length; primaryIndex++) {
            for (int secondaryIndex = primaryIndex; secondaryIndex < adjacencyMatrix.length; secondaryIndex++) {
                if (adjacencyMatrix[primaryIndex][secondaryIndex]) {
                    g2.drawLine(stationsPositions.get(primaryIndex).getPosX(), stationsPositions.get(primaryIndex).getPosY(), stationsPositions.get(secondaryIndex).getPosX(), stationsPositions.get(secondaryIndex).getPosY());
                }
            }
        }
    }

    /**
     * Draw a circle for each station according to its position, add on top its number
     *
     * @param g2
     */
    private void paintStations(Graphics2D g2) {

        g2.setStroke(new BasicStroke(8));
        for (int index = 0; index < this.stationsPositions.size(); index++) {
            g2.setColor(new Color(25, 115, 25));
            g2.drawOval(stationsPositions.get(index).getPosX() - (STATION_SIZE / 2), stationsPositions.get(index).getPosY() - (STATION_SIZE / 2), STATION_SIZE, STATION_SIZE);
            g2.setColor(Color.black);
            g2.drawString("" + (index + 1), stationsPositions.get(index).getPosX(), stationsPositions.get(index).getPosY() - STATION_SIZE);
        }

    }

    /**
     * Generate an array of random positions for each station
     *
     * @return Array of position of every station
     */
    private ArrayList<StationPosition> postionGeneration() {
        ArrayList<StationPosition> positionsToReturn = new ArrayList<StationPosition>();
        int randomPosX, randomPosY;

        for (int index = 0; index < this.adjacencyMatrix.length; index++) {
            randomPosX = ThreadLocalRandom.current().nextInt(30, MainFrame.FRAME_SIZE_X + 1 - 30);
            randomPosY = ThreadLocalRandom.current().nextInt(30, MainFrame.FRAME_SIZE_Y + 1 - 30);
            positionsToReturn.add(new StationPosition(randomPosX, randomPosY));
        }
        return positionsToReturn;
    }

    /**
     * Used to generate a predefined matrix
     *
     * @return 2d boolean Adjacency matrix
     */
    private boolean[][] matrixGeneration() {
        boolean[][] matrixToReturn = {
                {false, true, false, true, false},
                {true, false, true, true, false},
                {false, true, false, true, true},
                {true, true, true, false, true},
                {false, false, true, true, false}
        };

        return matrixToReturn;
    }
}

package com.ucp.gpi.frontend.panels;

import com.ucp.gpi.frontend.TrainFrame;
import com.ucp.gpi.frontend.data.VisualCanton;
import com.ucp.gpi.frontend.data.VisualStation;
import com.ucp.gpi.frontend.data.VisualTrain;
import com.ucp.gpi.frontend.data.TrainLine;
import com.ucp.gpi.backend.model.Canton;
import com.ucp.gpi.backend.model.RailwayNetwork;
import com.ucp.gpi.backend.model.Station;
import com.ucp.gpi.backend.model.Train;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Dashboard extends JPanel {

    private final Color CANTON_COLOR = Color.decode("#29B6F6");
    private final Color STATION_COLOR = new Color(255, 167, 38);
    private final Color SELECTED_STATION_COLOR = Color.WHITE;
    private final Color TRAIN_COLOR = Color.decode("#F67280");
    public static final int DB_SIZE_X = 1000;
    public static final int DB_SIZE_Y = 400;
    private static final int STATION_SIZE = 15;
    private static final int TRAIN_SIZE = 10;

    private boolean[][] adjacencyMatrix;
    private int selectedStationIndex = -1;
    private VisualStation selectedStation;
    private ArrayList<VisualStation> stationsArray;
    private ArrayList<VisualCanton> visualCantonArray;
    private ArrayList<TrainLine> trainLineArray;
    private ArrayList<VisualTrain> trainsArray;
    private RailwayNetwork railwayNetwork;
    private boolean isSet, selectedOnce, isLocked;

    public Dashboard() {
        this.stationsArray = stationsGenerationFromNumber(0);
        this.visualCantonArray = cantonGeneration();
        this.trainsArray = new ArrayList<VisualTrain>();
        isSet = false;
        selectedOnce = false;
        isLocked = false;
    }


    public int getSelectedStationIndex() {
        return selectedStationIndex;
    }

    /**
     * Gives
     *
     * @param e MouseEvent
     */
    public void getStationFromClick(MouseEvent e) {
        for (VisualStation s : stationsArray)
            if (Math.abs(s.getPosX() - e.getX()) < STATION_SIZE && Math.abs(s.getPosY() - e.getY()) < STATION_SIZE) {
                selectedStationIndex = stationsArray.indexOf(s);
                selectedStation = stationsArray.get(selectedStationIndex);
                selectedOnce = true;
                return;
            }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (TrainFrame.DEBUG_MODE)
            System.out.println("**** REPAINTING COMPONENTS *****");
        Graphics2D g2 = (Graphics2D) g;
        paintCantonFromArray(g2);
        paintStations(g2);
        paintTrains(g2);
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    /**
     * Draw lines between station according to the adjacency matrix
     *
     * @param g2 2d Graphics
     */
    @Deprecated
    private void printCantonFromMatrix(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(CANTON_COLOR);
        g2.setStroke(new BasicStroke(2));

        for (int primaryIndex = 0; primaryIndex <= adjacencyMatrix.length; primaryIndex++)
            for (int secondaryIndex = primaryIndex; secondaryIndex < adjacencyMatrix.length; secondaryIndex++)
                if (adjacencyMatrix[primaryIndex][secondaryIndex])
                    g2.drawLine(stationsArray.get(primaryIndex).getPosX(), stationsArray.get(primaryIndex).getPosY(), stationsArray.get(secondaryIndex).getPosX(), stationsArray.get(secondaryIndex).getPosY());
    }

    /**
     * Draw lines between station according to the list of canton
     *
     * @param g2 2d Graphics
     */
    private void paintCantonFromArray(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(CANTON_COLOR);
        g2.setStroke(new BasicStroke(2));
        for (VisualCanton visualCanton : visualCantonArray) {
            g2.drawLine(visualCanton.getInternalVisualStation().getPosX(), visualCanton.getInternalVisualStation().getPosY(), visualCanton.getExternalVisualStation().getPosX(), visualCanton.getExternalVisualStation().getPosY());
        }
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
            if (index == selectedStationIndex)
                g2.setColor(SELECTED_STATION_COLOR);
            else
                g2.setColor(STATION_COLOR);
            g2.drawOval(stationsArray.get(index).getPosX() - (STATION_SIZE / 2), stationsArray.get(index).getPosY() - (STATION_SIZE / 2), STATION_SIZE, STATION_SIZE);
            g2.setColor(Color.WHITE);


            if (isSet && stationsArray.size() < 20)
                g2.drawString("" + stationsArray.get(index).getStation().getName(), stationsArray.get(index).getPosX(), stationsArray.get(index).getPosY() - STATION_SIZE);
            else
                g2.drawString("" + (index + 1), stationsArray.get(index).getPosX(), stationsArray.get(index).getPosY() - STATION_SIZE);

        }

    }

    /**
     * Draw a rectangle for each station according to its position
     * Lock the updating process preventing concurring access
     *
     * @param g2 2d Graphics
     */
    private void paintTrains(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(4));
        if (TrainFrame.DEBUG_MODE)
            System.out.println("***** PRINT TRAINS *****");
        isLocked = true;
        for (int index = 0; index < this.trainsArray.size(); index++) {
            g2.setColor(TRAIN_COLOR);
            g2.drawRect(trainsArray.get(index).getPosX() - (TRAIN_SIZE / 2), trainsArray.get(index).getPosY() - (TRAIN_SIZE / 2), TRAIN_SIZE, TRAIN_SIZE);
            if (TrainFrame.DEBUG_MODE)
                System.out.println("***** PRINTED TRAIN X : " + trainsArray.get(index).getPosX() + " Y : " + trainsArray.get(index).getPosY() + " *****");
        }
        isLocked = false;
    }


    /**
     * Generate an array of random positions for each station
     *
     * @return Array of position of every station
     */
    @Deprecated
    private ArrayList<VisualStation> positionGenerationFromMatrix() {
        ArrayList<VisualStation> positionsToReturn = new ArrayList<>();
        int randomPosX, randomPosY;

        for (boolean b[] : this.adjacencyMatrix) {
            randomPosX = ThreadLocalRandom.current().nextInt(30, DB_SIZE_X + 1 - 30);
            randomPosY = ThreadLocalRandom.current().nextInt(30, DB_SIZE_Y + 1 - 30);
            positionsToReturn.add(new VisualStation(randomPosX, randomPosY));
        }

        return positionsToReturn;
    }

    /**
     * Generate an array of random positions in Y for each station
     * And a fixed position in X
     *
     * @param stationNumber Number of station to generate, will be obtain by the number of station generated by the engine
     * @return Array of position of every station
     */
    private ArrayList<VisualStation> stationsGenerationFromNumber(int stationNumber) {
        ArrayList<VisualStation> positionsToReturn = new ArrayList<>();
        int posX, randomPosY, distance;
        distance = DB_SIZE_X / (stationNumber + 2);

        for (int index = 0; index < stationNumber; index++) {
            posX = (index + 1) * distance;
            randomPosY = ThreadLocalRandom.current().nextInt(30, DB_SIZE_Y + 1 - 30);
            positionsToReturn.add(new VisualStation(posX, randomPosY));
        }

        return positionsToReturn;
    }


    /**
     * Generate an array of random positions in Y for each station
     * And a fixed position in X
     *
     * @param stations The list of the stations contained in the RailwayNetwork
     * @return the list of visual station generated
     */
    private ArrayList<VisualStation> stationsGenerationFromList(ArrayList<Station> stations) {
        ArrayList<VisualStation> positionsToReturn = new ArrayList<>();
        int posX, randomPosY, distance;
        distance = DB_SIZE_X / (stations.size() + 2);

        for (int index = 0; index < (stations.size()); index++) {
            posX = (index + 1) * distance;
            randomPosY = ThreadLocalRandom.current().nextInt(30, DB_SIZE_Y + 1 - 30);
            positionsToReturn.add(new VisualStation(posX, randomPosY, stations.get(index)));
        }

        return positionsToReturn;
    }


    /**
     * Generate a train object and put in the corresponding canton with the corresponding progression
     *
     * @param visualCanton          Canton where the train is located
     * @param progressionPercentage Progression between the two station of the canton
     * @return The train created
     */
    private VisualTrain singleTrainGeneration(VisualCanton visualCanton, double progressionPercentage) {
        int posX, posY, dX, dY;
        dX = visualCanton.getExternalVisualStation().getPosX() - visualCanton.getInternalVisualStation().getPosX();
        dY = visualCanton.getExternalVisualStation().getPosY() - visualCanton.getInternalVisualStation().getPosY();
        posX = (int) (visualCanton.getInternalVisualStation().getPosX() + (dX * (progressionPercentage)));
        posY = (int) (visualCanton.getInternalVisualStation().getPosY() + (dY * (progressionPercentage)));
        return new VisualTrain(posX, posY);
    }

    /**
     * Generate an array of canton based on the array of stations
     *
     * @return The array of cantons
     */
    private ArrayList<VisualCanton> cantonGeneration() {
        ArrayList<VisualCanton> listToReturn = new ArrayList<>();
        for (int index = 0; index < (stationsArray.size() - 1); index++) {
            listToReturn.add(new VisualCanton(stationsArray.get(index), stationsArray.get(index + 1)));
        }
        return listToReturn;
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

    /**
     * Responsible for updating information on elements to draw
     * Some will be done only once : Station and Canton
     * Other will be repeated : Trains
     * @param railwayNetwork Backend engine
     */
    public void setRailwayNetwork(RailwayNetwork railwayNetwork) {
        this.railwayNetwork = railwayNetwork;
        if (!isSet) {
            //TODO add check for multiple lines
            stationsArray = stationsGenerationFromList(railwayNetwork.getLines().get(0).getStations());
            visualCantonArray = cantonGeneration();
            for (int index = 0; index < visualCantonArray.size(); index++) {
                visualCantonArray.get(index).setCanton(railwayNetwork.getLines().get(0).getCantons().get(index));
            }
            isSet = true;
            testCantonValidity();
            testCantonNumber(railwayNetwork.getLines().get(0).getCantons());
        }
        if (TrainFrame.DEBUG_MODE)
            printTrainsInfos(railwayNetwork.getLines().get(0).getTrains());

        // the train list can not be modified while it is rendered
        if (!isLocked) {
            this.trainsArray = new ArrayList<>();
            for (VisualCanton visualCanton : visualCantonArray) {
                if (!visualCanton.getCanton().isFree()) {
                    trainsArray.add(singleTrainGeneration(visualCanton, (visualCanton.getCanton().getCurrentTrain().getProgression())));
                    if (TrainFrame.DEBUG_MODE)
                        System.out.println("++++ ADDED TRAIN TO THE LIST ++++");
                }
            }
        }

    }

    /**
     * Test if the visual canton information matches with the backend corresponding canton information
     *
     * @return result of the test
     */
    private boolean testCantonValidity() {
        for (int index = 0; index < visualCantonArray.size(); index++) {
            if (!visualCantonArray.get(index).getCanton().getBeginStation().equals(visualCantonArray.get(index).getInternalVisualStation().getStation())) {
                System.out.println("##### INCORRECT INTERNAL STATION #####\nCANTON : " + index + "#####\t#####\n");
                return false;
            }
            if (!visualCantonArray.get(index).getCanton().getEndStation().equals(visualCantonArray.get(index).getExternalVisualStation().getStation())) {
                System.out.println("##### INCORRECT EXTERNAL STATION #####\nCANTON : " + index + "#####\t#####\n");
                return false;
            }
        }
        System.out.println("##### CANTON MATCHES SUCCESSFULLY #####\n");

        return true;
    }

    /**
     * Test if the number of backend and frontend cantons match
     *
     * @param cantons list of backend canton currently in use
     * @return result of the test
     */
    private boolean testCantonNumber(ArrayList<Canton> cantons) {
        if (visualCantonArray.size() == cantons.size()) {
            System.out.println("##### CANTON NUMBER MATCHES SUCCESSFULLY #####\n");
            return true;
        }
        System.out.println("##### CANTON NUMBER DOES NOT MATCHES#####\n##### VISUAL SIZE : " + visualCantonArray.size() + " ,BACKEND SIZE : " + cantons.size() + " ######\n");
        return false;
    }

    /**
     * Print the data of all available trains
     *
     * @param trains list of train in reach of the dashboard
     */
    private void printTrainsInfos(ArrayList<Train> trains) {
        System.out.println("\n&&&&& TRAINS INFO UPDATE &&&&&");

        for (int index = 0; index < trains.size(); index++) {
            System.out.println("Train : " + index + " ");
            if (!(trains.get(index).getCurrentCanton() == null)) {
                System.out.println("Canton : " + trains.get(index).getCurrentCanton().getID() + " Between : " + trains.get(index).getCurrentCanton().getBeginStation().getName() + " and " + trains.get(index).getCurrentCanton().getEndStation().getName());
            }
            if (!(trains.get(index).getCurrentStation() == null)) {
                System.out.println("Station : " + trains.get(index).getCurrentStation().getName());
            }
        }
        System.out.println("&&&& END INFO &&&&&\n");
    }

    public boolean isSet() {
        return isSet;
    }

    public boolean isSelectedOnce() {
        return selectedOnce;
    }

    public VisualStation getSelectedStation() {
        return selectedStation;
    }
}

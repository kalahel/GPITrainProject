package com.ucp.gpi.run;

import com.ucp.gpi.builders.NetworkBuilder;
import com.ucp.gpi.builders.TrainBuilder;
import com.ucp.gpi.clock.Clock;
import com.ucp.gpi.frontend.panels.Displayable;
import com.ucp.gpi.model.Line;
import com.ucp.gpi.model.RailwayNetwork;
import com.ucp.gpi.model.Train;

public class Run implements Runnable {

    private static final int TRAIN_FREQ = 1000;
    private static final int DURATION = 1000;

    private RailwayNetwork network;
    private Clock clock;
    private Displayable displayable;
    private boolean isDisplayed;

    public Run() {
        isDisplayed = false;
    }

    public Run(Displayable displayable) {
        this.displayable = displayable;
        isDisplayed = true;
    }

    @Override
    public void run() {
        NetworkBuilder netBuilder = new NetworkBuilder();
        RailwayNetwork network = netBuilder.creat(1);
        TrainBuilder tBuilder = new TrainBuilder();
        Line firstLine = network.getLines().get(0);
        if(this.isDisplayed)
            this.displayable.setNetwork(network);

        int nbTrain = 0;
        while (nbTrain < 3) {
            if (firstLine.getCantons().get(0).isFree()) {
                Train newTrain = tBuilder.creat(firstLine);
                int lastStation = firstLine.getStations().size();
                firstLine.getTrains().add(newTrain);
                newTrain.start();
                nbTrain++;
                try {
                    Thread.sleep(this.TRAIN_FREQ);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.isDisplayed) {
                    this.displayable.refreshAll(network);
                }
            }
        }
    }

    public static void main(String[] args) {
        Run run = new Run();
        Thread thread = new Thread(run);
        thread.start();
    }

}

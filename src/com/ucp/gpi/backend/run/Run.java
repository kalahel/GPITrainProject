package com.ucp.gpi.backend.run;

import com.ucp.gpi.backend.builders.NetworkBuilder;
import com.ucp.gpi.backend.builders.TrainBuilder;
import com.ucp.gpi.backend.clock.Clock;
import com.ucp.gpi.frontend.panels.Displayable;
import com.ucp.gpi.backend.model.Line;
import com.ucp.gpi.backend.model.RailwayNetwork;
import com.ucp.gpi.backend.model.Train;

public class Run implements Runnable {

    private static final int TRAIN_FREQ = 100;
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
        if (this.isDisplayed)
            this.displayable.setNetwork(network);

        int nbTrain = 0;
        while (true) {
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

            }
            if (this.isDisplayed) {
                this.displayable.refreshAll(network);
            }
        }
    }

    public static void main(String[] args) {
        Run run = new Run();
        Thread thread = new Thread(run);
        thread.start();
    }

}

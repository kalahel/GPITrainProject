package com.ucp.gpi.run;

import com.ucp.gpi.builders.TrainBuilder;
import com.ucp.gpi.clock.Clock;
import com.ucp.gpi.model.Line;
import com.ucp.gpi.model.RailwayNetwork;
import com.ucp.gpi.model.Train;

public class Run {
	
	private static final int TRAIN_FREQ = 100;
	private static final int DURATION = 1000;
	
	private RailwayNetwork network;
	private Clock clock;
	
	public Run(RailwayNetwork network){
		this.network = network;
	}
	
	public void run(){
		
		TrainBuilder tBuilder = new TrainBuilder();
		
		clock.run();
		
		while(clock.getTotal() < DURATION){
		
			if(clock.getTotal()%TRAIN_FREQ == 0){
				Line firstLine = network.getLines().get(0);
				if(firstLine.getCantons().get(0).isFree()){
					Train newTrain = tBuilder.creat();
					int lastStation = firstLine.getStations().size();
					newTrain.start();
					newTrain.getTrace().setTrace(tBuilder.findTrace(firstLine.getStations().get(0), firstLine.getStations().get(lastStation), firstLine));
				}
			}
		}
	}
}

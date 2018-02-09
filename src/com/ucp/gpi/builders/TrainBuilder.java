package com.ucp.gpi.builders;

import java.util.ArrayList;

import com.ucp.gpi.model.Canton;
import com.ucp.gpi.model.Line;
import com.ucp.gpi.model.Station;
import com.ucp.gpi.model.Trace;
import com.ucp.gpi.model.Train;

public class TrainBuilder {

	
	public TrainBuilder(){
		
	}

    /**
     * This method will be usefull to test the Train object
     * @param ID is the String given to the train
     * @param capacity is the integer given to the train
     * @return return a train object
     */
	public Train testValues(String ID,int capacity){
	    Train train = new Train();
	    train.setID(ID);
	    train.setCapacity(capacity);
	    train.setProgression(0);
	    train.setCurrentDistanceDone(0);
	    train.setNbUsers(0);


	    return train;
    }

	public Train creat(Line line){
		Train train = new Train();
		int lastStation = line.getStations().size();
		train.setTrace(new Trace());
		train.getTrace().setTrace(this.findTrace(line.getStations().get(0), line.getStations().get(lastStation-1), line));
		train = basicInit(train);
		
		return train;
	}
	
	public Train basicInit(Train train){
		Double d = Math.random() * 1000;
		train.setID(String.valueOf(d.intValue())); 
		train.setProgression(0);
		train.setCurrentDistanceDone(0);
		
		return train;
	}
	
	public ArrayList<Canton> findTrace(Station begin, Station end, Line line){
		int i = 0;
		
		ArrayList<Canton> cantonPack = line.getCantons();
		ArrayList<Canton> cantonPool = new ArrayList<Canton>();
		ArrayList<Canton> trace = new ArrayList<Canton>();
		ArrayList<Canton> trace_tmp = new ArrayList<Canton>();
		
		Station currentDeparture = begin;
		
		do{
			for(i=0; i<cantonPack.size(); i++){
				if (cantonPack.get(i).getBeginStation() == currentDeparture)
					cantonPool.add(cantonPack.get(i));
			}
			if (cantonPool.size() == 1){
				trace.add(cantonPool.get(0));
				if (cantonPool.get(0).getEndStation() == end)
					return trace;
				currentDeparture = cantonPool.get(0).getEndStation();
			}
		}while(cantonPool.size() == 1);
		
		if (cantonPool.isEmpty())
			return null;
		if (cantonPool.size() > 1){
			for (i=0; i<cantonPool.size(); i++){
				if ((trace_tmp = findTrace(cantonPool.get(i).getEndStation(), end, line)) != null)
					if (trace.addAll(trace_tmp))
						return trace;
			}
			return null;
		}
		return trace;
	}
}

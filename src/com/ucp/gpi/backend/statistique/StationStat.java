package com.ucp.gpi.backend.statistique;

import java.util.ArrayList;

import com.ucp.gpi.backend.model.Station;

/**
 * @author matthieu
 */
public class StationStat {

	private Station station;
	private ArrayList<Integer> train_occupation;
	
	public StationStat(Station station){
		this.station = station;
		this.train_occupation = new ArrayList<Integer>();
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public ArrayList<Integer> getTrain_occupation() {
		return train_occupation;
	}

	public void setTrain_occupation(ArrayList<Integer> train_occupation) {
		this.train_occupation = train_occupation;
	}
}

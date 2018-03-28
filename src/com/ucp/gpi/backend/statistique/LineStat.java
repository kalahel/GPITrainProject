package com.ucp.gpi.backend.statistique;

import java.util.ArrayList;


/**
 * 
 * @author matthieu
 *
 */
public class LineStat {

	private ArrayList<ArrayList<Integer>> popEvolution;
	
	public LineStat(int nbStationOnLine){
		
		this.popEvolution = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<nbStationOnLine; i++){
			ArrayList<Integer> stationPop = new ArrayList<Integer>();
			popEvolution.add(stationPop);
		}
		
	}

	public ArrayList<ArrayList<Integer>> getPopEvolution() {
		return popEvolution;
	}

	public void setPopEvolution(ArrayList<ArrayList<Integer>> popEvolution) {
		this.popEvolution = popEvolution;
	}
	
	
}

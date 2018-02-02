	package com.ucp.gpi.builders;

import com.ucp.gpi.model.Station;

/**
 * 
 * @author matthieu
 * 23/01/2018
 *
 */
public class StationBuilder {

	private Station station;
	
	public StationBuilder() {
		
	}
	
	public Station CreatStation(String name, String code_UIC) {
		station = new Station();
		station.setName(name);
		station.setID(code_UIC);
		return station;
	}
}

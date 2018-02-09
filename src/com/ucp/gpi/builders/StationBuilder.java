	package com.ucp.gpi.builders;

import com.ucp.gpi.model.Station;
import com.ucp.gpi.statistique.StationStat;
import com.ucp.gpi.utils.Coordinates;

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

	/**
	 * This method will be usefull to the test Classes
	 * @param name is the name given to the station
	 * @param code_UIC is the ID given to the station
	 * @param coordinates are the new coordinates of the station
	 * @param stationStat is the statistique object
	 * @return the new station for the StationTest class
	 */
	public Station testStation(String name, String code_UIC, StationStat stationStat, Coordinates coordinates) {
		station = new Station();
		station.setName(name);
		station.setID(code_UIC);
		station.setStatistique(stationStat);
		station.setCoord(coordinates);

		return station;
	}
}

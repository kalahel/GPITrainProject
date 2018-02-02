package com.ucp.gpi.model;

import com.ucp.gpi.statistique.StationStat;
import com.ucp.gpi.utils.Coordinates;

/**
 * 
 * @author matthieu
 * 23/01/2018
 *
 */
public class Station {

	private String name;
	private String ID;
	private StationStat statistique;
	private Coordinates coord;
	/* ... */
	
	public Station() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public StationStat getStatistique() {
		return statistique;
	}

	public void setStatistique(StationStat statistique) {
		this.statistique = statistique;
	}


	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	@Override
	public String toString() {
		return "Station [name=" + name + ", ID=" + ID + ", statistique=" + statistique + ", coord=" + coord + "]";
	}
}

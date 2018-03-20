package com.ucp.gpi.backend.model;

import java.util.ArrayList;

import com.ucp.gpi.backend.statistique.StationStat;
import com.ucp.gpi.backend.utils.Coordinates;

/**
 * @author matthieu
 * 23/01/2018
 */
public class Station {

    private String name;
    private String ID;
    private StationStat statistique;
    private Coordinates coord;
    private ArrayList<User> userList;
    private boolean occupation;

    public Station() {

    }
    
    public void break_station(){
    	this.setOccupation(true);
    }
    
    public void repair_station(){
    	this.setOccupation(false);
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

    public boolean isOccupation() {
		return occupation;
	}

	public void setOccupation(boolean occupation) {
		this.occupation = occupation;
	}

	@Override
    public String toString() {
        return "Station [name=" + name + ", ID=" + ID + ", statistique=" + statistique + ", coord=" + coord + "]";
    }
}

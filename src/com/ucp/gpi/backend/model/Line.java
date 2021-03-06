package com.ucp.gpi.backend.model;
/**
 * @author matthieu
 * 23/01/2018
 */

import java.util.ArrayList;

import com.ucp.gpi.backend.statistique.LineStat;

public class Line {

    private String ID;
    private String name;
    private ArrayList<Station> stations;
    private int nb_stations;
    private ArrayList<Canton> cantons;
    private int nb_cantons;
    private ArrayList<Train> trains;
    private int nb_train;
    private String color;
    private int capacity;
    private int nbUser;
    private LineStat statistique;


    public Line() {
        stations = new ArrayList<Station>();
        cantons = new ArrayList<Canton>();
        trains = new ArrayList<Train>();
    }
    
    public int getStationPosition(Station station){
    	int i;
    	for (i=0; i<stations.size(); i++){
    		if (stations.get(i) == station)
    			return i;
    	}
    	return stations.size();
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Station> getStations() {
        return stations;
    }


    public void setStations(ArrayList<Station> stations) {
        this.stations = stations;
    }


    public int getNb_stations() {
        return nb_stations;
    }


    public void setNb_stations(int nb_stations) {
        this.nb_stations = nb_stations;
    }


    public ArrayList<Canton> getCantons() {
        return cantons;
    }

    public void setCantons(ArrayList<Canton> cantons) {
        this.cantons = cantons;
    }

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public void setTrains(ArrayList<Train> trains) {
        this.trains = trains;
    }

    public int getNb_train() {
        return nb_train;
    }

    public void setNb_train(int nb_train) {
        this.nb_train = nb_train;
    }

    public int getNb_cantons() {
        return nb_cantons;
    }

    public void setNb_cantons(int nb_cantons) {
        this.nb_cantons = nb_cantons;
    }

    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNbUser() {
        return nbUser;
    }

    public void setNbUser(int nbUser) {
        this.nbUser = nbUser;
    }

    public LineStat getStatistique() {
		return statistique;
	}

	public void setStatistique(LineStat statistique) {
		this.statistique = statistique;
	}

	@Override
    public String toString() {
        return "Line [ID=" + ID + ", name=" + name + ", stations=" + stations + ", nb_stations=" + nb_stations
                + ", cantons=" + cantons + ", nb_cantons=" + nb_cantons + ", trains=" + trains + ", nb_train="
                + nb_train + ", color=" + color + ", capacity=" + capacity + ", nbUser=" + nbUser
                + "]";
    }
}

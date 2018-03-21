package com.ucp.gpi.backend.model;

import java.util.ArrayList;

import com.ucp.gpi.backend.builders.UserFactory;
import com.ucp.gpi.backend.clock.Clock;
import com.ucp.gpi.backend.statistique.StationStat;
import com.ucp.gpi.backend.utils.Coordinates;

/**
 * @author matthieu
 * 23/01/2018
 */
public class Station extends Thread{

    private String stationName;
    private String ID;
    private StationStat statistique;
    private Coordinates coord;
    private ArrayList<User> userList;
    private boolean occupation;
    private int capacity;
    private Line line;

    public Station(){
    	userList = new ArrayList<User>();
    }
    
    @Override
    public void run() {
    	UserFactory ufactory = new UserFactory();
        while (true) {
            try {
                this.sleep(Clock.speed);
            } catch (InterruptedException e) {
                System.out.println("Train " + ID + " didn't sleep !");
                e.printStackTrace();
            }
            if (userList.size() < capacity){
            	User u = ufactory.createUser(this, line);
            	this.userList.add(u);
            	System.out.println(stationName + " Population: " + userList.size() + "/" + capacity);
            }
        }
    }
    
    public void break_station(){
    	this.setOccupation(true);
    }
    
    public void repair_station(){
    	this.setOccupation(false);
    }

    public String getStationName(){
        return stationName;
    }

    public void setStationName(String name) {
        this.stationName = name;
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

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	@Override
    public String toString() {
        return "Station [name=" + stationName + ", ID=" + ID + ", statistique=" + statistique + ", coord=" + coord + "]";
    }
}

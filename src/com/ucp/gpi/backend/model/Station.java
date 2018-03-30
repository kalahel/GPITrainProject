package com.ucp.gpi.backend.model;

import java.util.ArrayList;
import java.util.Random;

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
    private final int maxSpawn = 20;
    private final int minSpawn = 1;

    public Station(){
    	userList = new ArrayList<User>();
    }
    
    public boolean isOnTrace(Trace trace){
    	int i;
    	for (i=0; i<trace.getTrace().size(); i++){
    		if (trace.getTrace().get(i).getBeginStation() == this)
    			return true;
    		else if (trace.getTrace().get(i).getEndStation() == this)
    			return true;
    	}
    	return false;
    }
    
    @Override
    public void run() {
    	UserFactory ufactory = new UserFactory();
    	Random rand = new Random();
    	int i, nbSpawn;
        while (true) {
            try {
                Station.sleep(Clock.populationSpawn);
            } catch (InterruptedException e) {
                //System.out.println("Train " + ID + " didn't sleep !");
                e.printStackTrace();
            }
            if (userList.size() < capacity){
            	nbSpawn = (rand.nextInt(maxSpawn - minSpawn) + minSpawn) % ((this.capacity - this.userList.size()) + 1);
            	for (i = 0; i < nbSpawn; i++){
	            	User u = ufactory.createUser(this, line);
	            	this.userList.add(u);
            	}
            	//System.out.println(stationName + " Population: " + userList.size() + "/" + capacity);
            }
        }
    }
    
    public void break_station(){
        //System.out.println(this.stationName + " is broken !");
    	this.setOccupation(true);
    }
    
    public void repair_station(){
        //System.out.println(this.stationName + " is repaired !");
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

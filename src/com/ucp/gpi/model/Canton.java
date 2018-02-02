package com.ucp.gpi.model;
 /**
  * 
  * @author matthieu
  *	23/01/2018
  *
  */

import java.util.ArrayList;

public class Canton {

	private String ID;
	private ArrayList<Station> ends;
	private double lenght;
	private int occupation;
	private int speed;
	
	public Canton() {
		ends = new ArrayList<Station>();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public ArrayList<Station> getEnds() {
		return ends;
	}

	public void setEnds(ArrayList<Station> ends) {
		this.ends = ends;
	}

	public double getLenght() {
		return lenght;
	}

	public void setLenght(double lenght) {
		this.lenght = lenght;
	}

	public int getOccupation() {
		return occupation;
	}

	public void setOccupation(int occupation) {
		this.occupation = occupation;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Canton [ID=" + ID + ", ends=" + ends + ", lenght=" + lenght + ", occupation=" + occupation + ", speed="
				+ speed + "]";
	}

	
	
	
}

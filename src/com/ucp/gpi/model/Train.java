package com.ucp.gpi.model;

import java.util.ArrayList;

import com.ucp.gpi.utils.Coordinates;
/**
 * 
 * @author matthieu
 *
 */
public class Train {
	
	private String ID;
	private Line line;
	private Canton currentCanton;
	private Station currentStation;
	private Station src;
	private Station dest;
	private int nbUsers;
	private ArrayList<User> Users;
	private int capacity;
	private Coordinates coord;
	private Trace trace;
	
	public Train() {
		
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public Canton getCurrentCanton() {
		return currentCanton;
	}

	public void setCurrentCanton(Canton currentCanton) {
		this.currentCanton = currentCanton;
	}

	public Station getCurrentStation() {
		return currentStation;
	}

	public void setCurrentStation(Station currentStation) {
		this.currentStation = currentStation;
	}

	public Station getSrc() {
		return src;
	}

	public void setSrc(Station src) {
		this.src = src;
	}

	public Station getDest() {
		return dest;
	}

	public void setDest(Station dest) {
		this.dest = dest;
	}

	public int getNbUsers() {
		return nbUsers;
	}

	public void setNbUsers(int nbUsers) {
		this.nbUsers = nbUsers;
	}

	public ArrayList<User> getUsers() {
		return Users;
	}

	public void setUsers(ArrayList<User> users) {
		Users = users;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	@Override
	public String toString() {
		return "Train [ID=" + ID + ", line=" + line + ", currentCanton=" + currentCanton + ", currentStation="
				+ currentStation + ", src=" + src + ", dest=" + dest + ", nbUsers=" + nbUsers + ", Users=" + Users
				+ ", capacity=" + capacity + ", coord=" + coord + "]";
	}
	
}
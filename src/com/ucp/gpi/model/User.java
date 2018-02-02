package com.ucp.gpi.model;

import com.ucp.gpi.clock.Schedule;
import com.ucp.gpi.utils.BoundedCounter;

public class User {

	private String ID;
	private Station currentStation;
	private Train currentTrain;
	private BoundedCounter satisfaction;
	private Station dest;
	private Schedule waitingTime;
	
	public User() {
		
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Station getCurrentStation() {
		return currentStation;
	}

	public void setCurrentStation(Station currentStation) {
		this.currentStation = currentStation;
	}

	public Train getCurrentTrain() {
		return currentTrain;
	}

	public void setCurrentTrain(Train currentTrain) {
		this.currentTrain = currentTrain;
	}

	public BoundedCounter getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(BoundedCounter satisfaction) {
		this.satisfaction = satisfaction;
	}

	public Station getDest() {
		return dest;
	}

	public void setDest(Station dest) {
		this.dest = dest;
	}

	public Schedule getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(Schedule waitingTime) {
		this.waitingTime = waitingTime;
	}
}

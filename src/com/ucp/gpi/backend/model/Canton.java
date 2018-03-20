package com.ucp.gpi.backend.model;

/**
 * @author matthieu
 * 23/01/2018
 */

public class Canton {

    private String ID;
    private Station beginStation;
    private Station endStation;
    private double lenght;
    private boolean occupation;
    private int speed;
    private Train currentTrain;

    public Canton() {
    }

    public boolean isFree() {
        if (occupation == true) {
            return false;
        } else {
            return true;
        }
    }
    
    public void break_canton(){
    	this.setOccupation(true);
    }
    
    public void repair_canton(){
    	this.setOccupation(false);
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    public boolean getOccupation() {
        return occupation;
    }

    public void setOccupation(boolean occupation) {
        this.occupation = occupation;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Station getBeginStation() {
        return beginStation;
    }

    public void setBeginStation(Station beginStation) {
        this.beginStation = beginStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public void setEndStation(Station endStation) {
        this.endStation = endStation;
    }

    public Train getCurrentTrain() {
        return currentTrain;
    }

    public void setCurrentTrain(Train currentTrain) {
        this.currentTrain = currentTrain;
    }

    @Override
    public String toString() {
        return "Canton [ID=" + ID + ", begin=" + beginStation.toString() + ", end=" + endStation.toString() + ", lenght=" + lenght + ", occupation=" + occupation + ", speed="
                + speed + "]";
    }


}

package com.ucp.gpi.backend.model;

import com.ucp.gpi.backend.clock.Clock;
import com.ucp.gpi.backend.utils.Coordinates;

import java.util.ArrayList;

/**
 * @author matthieu
 */
public class Train extends Thread {

    private String ID;
    private Line line;
    private Canton currentCanton;
    private Station currentStation;
    private Station src;
    private Station dest;
    private double progression;
    private double currentDistanceDone;
    private int nbUsers;
    private ArrayList<User> Users;
    private int capacity;
    private Coordinates coord;
    private Trace trace;
    private boolean arrived = false;

    public Train() {

    }

    @Override
    public void run() {
        while (!arrived) {
            try {
                this.sleep(Clock.speed);
            } catch (InterruptedException e) {
                System.out.println("Train " + ID + " didn't sleep !");
                e.printStackTrace();
            }
            if (trace != null) {
                this.updateProgression();
            }
        }
    }

    /**
     * This methode is called at each time iteration to update the position of th train
     */
    public void updateProgression() {
        if (currentStation == null && currentCanton != null) {
            this.currentDistanceDone += this.currentCanton.getSpeed();
            progression = currentDistanceDone / currentCanton.getLenght();

            //if the train reach the end of the canton
            if (progression >= 1) {
                System.out.println("Train " + ID + ": Entré en Gare (" + this.getCurrentCanton().getEndStation().getName() + ")");
                this.getCurrentCanton().setOccupation(false);
                this.getTrace().getTrace().remove(0);
                this.setCurrentStation(currentCanton.getEndStation());
                this.setCurrentCanton(null);

                progression = 0;
                currentDistanceDone = 0;
            } else {
                System.out.println("Train " + ID + ": En transition (" + this.getCurrentCanton().getBeginStation().getName() + " - " + this.getCurrentCanton().getEndStation().getName() + ")");
            }
        } else if (currentCanton == null && currentStation != null) {
            if (trace.getTrace().size() != 0) {
                if (!trace.getTrace().get(0).getOccupation()) {
                    System.out.println("Train " + ID + ": Sorti de Gare (" + this.getCurrentStation().getName() + ")");
                    this.setCurrentCanton(trace.getTrace().get(0));
                    this.getCurrentCanton().setCurrentTrain(this);
                    this.getCurrentCanton().setOccupation(true);
                    this.setCurrentStation(null);
                }
            } else {
                arrived = true;
                System.out.println("Train " + ID + ": Arrivé à destination");
            }
        } else {
            if (trace != null) {
                int nbCanton = this.getTrace().getTrace().size();
                System.out.println("Train " + ID + ": De " + this.getTrace().getTrace().get(0).getBeginStation().getName()
                        + " à destination de " + this.getTrace().getTrace().get(nbCanton - 1).getEndStation().getName());
                this.setCurrentStation(trace.getTrace().get(0).getBeginStation());
            }
        }
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

    public double getProgression() {
        return progression;
    }

    public void setProgression(double progression) {
        this.progression = progression;
    }

    public double getCurrentDistanceDone() {
        return currentDistanceDone;
    }

    public void setCurrentDistanceDone(double currentDistanceDone) {
        this.currentDistanceDone = currentDistanceDone;
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

    public Trace getTrace() {
        return trace;
    }

    public void setTrace(Trace trace) {
        this.trace = trace;
    }

    @Override
    public String toString() {
        return "Train [ID=" + ID + ", line=" + line + ", currentCanton=" + currentCanton + ", currentStation="
                + currentStation + ", src=" + src + ", dest=" + dest + ", nbUsers=" + nbUsers + ", Users=" + Users
                + ", capacity=" + capacity + ", coord=" + coord + "]";
    }

}
package com.ucp.gpi.frontend.data;

import com.ucp.gpi.model.Station;

public class VisualStation {
    private int posX;
    private int posY;
    private Station station;

    public VisualStation(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public VisualStation(int posX, int posY, Station station) {
        this.posX = posX;
        this.posY = posY;
        this.station = station;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}

package com.ucp.gpi.frontend.data;

public class VisualTrain {
    private int posX;
    private int posY;
    private double occupancy;


//    public VisualTrain(int posX, int posY) {
//        this.posX = posX;
//        this.posY = posY;
//    }

    public VisualTrain(int posX, int posY, double occupancy) {
        this.posX = posX;
        this.posY = posY;
        this.occupancy = occupancy;
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

    public double getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(double occupancy) {
        this.occupancy = occupancy;
    }

}

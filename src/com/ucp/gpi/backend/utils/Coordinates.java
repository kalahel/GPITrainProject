package com.ucp.gpi.backend.utils;

/**
 * @author quentin
 * @version 23012017
 */

public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "(x: " + this.x + " / y: " + this.y + ")";
    }

}

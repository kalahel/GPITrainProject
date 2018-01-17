package com.ucp.gpi.frontend.data;

import java.awt.*;
import java.util.ArrayList;

/**
 * The train line will be a secession of canton in order
 */
public class TrainLine {
    private ArrayList<Canton> cantonList;
    private Color color;

    public TrainLine(ArrayList<Canton> cantonList, Color color) {
        this.cantonList = cantonList;
        this.color = color;
    }

    public void addCanton(Canton canton){
        this.cantonList.add(canton);
    }

    public ArrayList<Canton> getCantonList() {
        return cantonList;
    }
}

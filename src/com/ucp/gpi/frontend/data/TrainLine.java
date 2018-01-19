package com.ucp.gpi.frontend.data;

import java.util.ArrayList;

/**
 * The train line will be a secession of canton in order
 */
public class TrainLine {
    private ArrayList<Canton> cantonList;

    public TrainLine(ArrayList<Canton> cantonList) {
        this.cantonList = cantonList;
    }

    public void addCanton(Canton canton){
        this.cantonList.add(canton);
    }

    public ArrayList<Canton> getCantonList() {
        return cantonList;
    }
}

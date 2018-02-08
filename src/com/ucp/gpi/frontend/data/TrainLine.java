package com.ucp.gpi.frontend.data;

import java.util.ArrayList;

/**
 * The train line will be a secession of canton in order
 */
public class TrainLine {
    private ArrayList<VisualCanton> visualCantonList;

    public TrainLine(ArrayList<VisualCanton> visualCantonList) {
        this.visualCantonList = visualCantonList;
    }

    public void addCanton(VisualCanton visualCanton){
        this.visualCantonList.add(visualCanton);
    }

    public ArrayList<VisualCanton> getVisualCantonList() {
        return visualCantonList;
    }
}

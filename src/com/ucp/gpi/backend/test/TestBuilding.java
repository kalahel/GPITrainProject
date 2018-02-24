package com.ucp.gpi.backend.test;

import com.ucp.gpi.backend.builders.LineBuilder;
import com.ucp.gpi.backend.model.Line;

public class TestBuilding {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LineBuilder lb = new LineBuilder();
        Line l = new Line();
        l = lb.creatLineFromFile("B");

        for (int i = 0; i < l.getNb_stations(); i++) {
            if (i != (l.getNb_stations() - 1)) {
                System.out.println(l.getStations().get(i).getName() + "\t\t\t" + l.getCantons().get(i).getBeginStation().getName() + " --> " + l.getCantons().get(i).getEndStation().getName());
            } else {
                System.out.println(l.getStations().get(i).getName());
            }
        }
    }

}

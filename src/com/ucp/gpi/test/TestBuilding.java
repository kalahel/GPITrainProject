package com.ucp.gpi.test;

import com.ucp.gpi.builders.LineBuilder;
import com.ucp.gpi.model.Line;

public class TestBuilding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LineBuilder lb = new LineBuilder();
		Line l = new Line();
		l = lb.CreatLineFromFile("A");
		
		for(int i=0; i<l.getNb_stations(); i++) {
			if(i != (l.getNb_stations()-1)) {
				System.out.println(l.getStations().get(i).getName() + "\t\t\t" + l.getCantons().get(i).getEnds().get(0).getName() + " --> " + l.getCantons().get(i).getEnds().get(1).getName());
			}
			else {
				System.out.println(l.getStations().get(i).getName());
			}
		}
	}

}

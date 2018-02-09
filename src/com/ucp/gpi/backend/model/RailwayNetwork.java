package com.ucp.gpi.backend.model;

import java.util.ArrayList;

/**
 * 
 * @author matthieu
 * 23/01/2018
 *
 */
public class RailwayNetwork {

	private ArrayList<Line> lines;
	private int nb_lines;
	
	public RailwayNetwork() {
		lines = new ArrayList<Line>();
	}

	public ArrayList<Line> getLines() {
		return lines;
	}

	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}

	public int getNb_lines() {
		return nb_lines;
	}

	public void setNb_lines(int nb_lines) {
		this.nb_lines = nb_lines;
	}

	@Override
	public String toString() {
		return "RailwayNetwork [lines=" + lines + ", nb_lines=" + nb_lines + "]";
	}
}

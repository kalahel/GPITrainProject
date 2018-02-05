package com.ucp.gpi.model;

import java.util.ArrayList;

public class Trace {

	private ArrayList<Canton> trace;
	private int nbCanton;
	
	public Trace(){
		
	}
	
	public ArrayList<Canton> getTrace() {
		return trace;
	}
	
	public void setTrace(ArrayList<Canton> trace) {
		this.trace = trace;
	}
	
	public int getNbCanton() {
		return nbCanton;
	}
	
	public void setNbCanton(int nbCanton) {
		this.nbCanton = nbCanton;
	}
	
}

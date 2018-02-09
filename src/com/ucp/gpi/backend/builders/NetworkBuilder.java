package com.ucp.gpi.backend.builders;

import com.ucp.gpi.backend.model.Line;
import com.ucp.gpi.backend.model.RailwayNetwork;

public class NetworkBuilder {

	public NetworkBuilder(){
		
	}
	
	public RailwayNetwork creat(int nbLigne){
		RailwayNetwork network = new RailwayNetwork();
		
		LineBuilder lBuilder = new LineBuilder();
		
		for(int i=0; i<nbLigne; i++){
			Line l = new Line();
			l = lBuilder.creatLineFromFile("A");//a modif si on veut plusieur ligne diff
			network.getLines().add(l);
		}
		
		network.setNb_lines(nbLigne);
		
		return network;
	}
	
}

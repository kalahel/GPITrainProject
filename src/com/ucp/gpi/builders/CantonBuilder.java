package com.ucp.gpi.builders;

import java.util.UUID;

import com.ucp.gpi.model.Canton;
import com.ucp.gpi.model.Station;


/**
 * 
 * @author matthieu
 * 23/01/2018
 *
 */
public class CantonBuilder {

	private int aleaMin = 2;
	private int aleaMax = 8;
	private int constSpeed = 100;
	
	public CantonBuilder() {
		
	}
	
	public Canton creatCanton(Station start, Station end) {
		Canton canton = new Canton();

		canton.setID(UUID.randomUUID().toString());
		canton.setBeginStation(start);
		canton.setEndStation(end);
		canton.setLenght(aleaMin + (Math.random() * (aleaMax - aleaMin)));
		canton.setOccupation(false);
		canton.setSpeed(constSpeed);
		
		return canton;
	}
}

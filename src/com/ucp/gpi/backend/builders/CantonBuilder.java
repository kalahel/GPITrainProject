package com.ucp.gpi.backend.builders;

import java.util.UUID;

import com.ucp.gpi.backend.model.Canton;
import com.ucp.gpi.backend.model.Station;


/**
 * 
 * @author matthieu
 * 23/01/2018
 *
 */
public class CantonBuilder {

	private int aleaMin = 30;
	private int aleaMax = 40;
	private int constSpeed = 2;
	
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

	/**
	 * This class will be useful for the tests
	 * @param ID is the new ID of the canton
	 * @param occupation is the boolean to check if the canton has a train
	 * @param lenght is the new lenght of the canton
	 * @param speed is the train's speed of this current canton
	 * @return a canton for the CantonTest class
	 */
	public Canton testCanton(String ID,Boolean occupation,double lenght,int speed){
		Canton canton = new Canton();
		canton.setOccupation(occupation);
		canton.setID(ID);
		canton.setLenght(lenght);
		canton.setSpeed(speed);

		return canton;
	}
}

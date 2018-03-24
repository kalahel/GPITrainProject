package com.ucp.gpi.backend.builders;

import java.util.Random;

import com.ucp.gpi.backend.model.Line;
import com.ucp.gpi.backend.model.Station;
import com.ucp.gpi.backend.model.User;

/**
 * 
 * @author quentin
 *
 */

public class UserFactory {
	
	public UserFactory(){
		
	}
	
	public User createUser(Station station, Line line){
		Random rand = new Random();
		User user = new User();
		Station destination;
		int stationPosition = line.getStationPosition(station);
		int destPosition = rand.nextInt(line.getStations().size() - stationPosition) + stationPosition;
		destination = line.getStations().get(destPosition);
		user.setCurrentStation(station);
		user.setDest(destination);
		return user;
	}
}

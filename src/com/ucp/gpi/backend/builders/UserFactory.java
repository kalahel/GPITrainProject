package com.ucp.gpi.backend.builders;

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
		User user = new User();
		user.setCurrentStation(station);
		user.setDest(line.getStations().get(line.getStations().size() - 1));
		return user;
	}
}

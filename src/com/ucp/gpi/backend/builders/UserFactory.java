package com.ucp.gpi.backend.builders;

import com.ucp.gpi.backend.model.Line;
import com.ucp.gpi.backend.model.User;

/**
 * 
 * @author quentin
 *
 */

public class UserFactory {
	public UserFactory(){
		
	}
	
	public User createUser(Line line){
		User user = new User();
		user.setCurrentStation(line.getStations().get((int) (Math.random() % line.getStations().size())));
		user.setDest(line.getStations().get(line.getStations().size()));
		return user;
	}
}

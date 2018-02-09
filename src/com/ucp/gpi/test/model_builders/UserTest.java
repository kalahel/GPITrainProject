package com.ucp.gpi.test.model_builders;

import com.ucp.gpi.model.Station;
import com.ucp.gpi.model.Train;
import com.ucp.gpi.model.User;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class has to test the method of the object User
 */
public class UserTest {

    // The User
    private User user = new User();

    // The Station
    private Station station = new Station();

    // The Train
    private Train train = new Train();


    /**
     * We will test if the user object is correctly initialised
     */
    @Test
    public void User(){
        assert user != null;
    }

    /**
     * We will test the ID of the user
     */
    @Ignore
    @Test
    public void getID() {
    }

    @Test
    public void setID() {
        user.setID("TEST");
        assertEquals("TEST",user.getID());
    }

    /**
     * We will test the current station of the user
     */
    @Ignore
    @Test
    public void getCurrentStation() {
        fail("Not implemented yet");
    }

    @Test
    public void setCurrentStation() {
        user.setCurrentStation(station);
        assertEquals(station,user.getCurrentStation());
    }

    /**
     * We will test the train of the user
     */
    @Ignore
    @Test
    public void getCurrentTrain() {
        fail("Not implemented yet");
    }

    @Test
    public void setCurrentTrain() {
        user.setCurrentTrain(train);
        assertEquals(train,user.getCurrentTrain());
    }

    /**
     * We will test the satisfaction of the user
     */
    @Ignore
    @Test
    public void getSatisfaction() {
        fail("Not implemented yet");
    }

    @Ignore
    @Test
    public void setSatisfaction() {
        fail("Not implemented yet");
    }

    /**
     * We will test the destination of the user
     */
    @Ignore
    @Test
    public void getDest() {
        fail("Not implemented yet");
    }

    @Test
    public void setDest() {
        user.setDest(station);
        assertEquals(station,user.getDest());
    }

    /**
     * We will test the waiting time of the user
     */
    @Ignore
    @Test
    public void getWaitingTime() {
        fail("Not implemented yet");
    }

    @Ignore
    @Test
    public void setWaitingTime() {
        fail("Not implemented yet");
    }
}
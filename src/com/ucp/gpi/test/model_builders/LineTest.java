package com.ucp.gpi.test.model_builders;

import com.ucp.gpi.builders.LineBuilder;
import com.ucp.gpi.model.*;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * This class has to test the method of the object Line and its builder
 */
public class LineTest {

    // The line
    private LineBuilder lineBuilder = new LineBuilder();
    private Line line = lineBuilder.testLine("ID","Name",0,0,"couleur",0,0,0);

    // The canton
    private ArrayList<Canton> cantons = new ArrayList<Canton>();

    // The train
    private ArrayList<Train> trains = new ArrayList<Train>();

    // The station
    private ArrayList<Station> stations = new ArrayList<Station>();

    // The User
    private ArrayList<User> users = new ArrayList<User>();

    /**
     * We test if the Line is correctly created
     */
    @Test
    public void Line(){
        assert line != null;
    }

    /**
     * We test the ID of the Line
     */
    @Test
    public void getID() {
        assertEquals("ID",line.getID());
    }

    @Test
    public void setID() {
        line.setID("test");
        assertEquals("test",line.getID());
    }

    /**
     * We test the name of the Line
     */
    @Test
    public void getName() {
        assertEquals("Name",line.getName());
    }

    @Test
    public void setName() {
        line.setName("test");
        assertEquals("test",line.getName());
    }

    /**
     * We test the array of station of the Line
     */
    @Ignore
    @Test
    public void getStations() {
        fail("Not implemented yet");
    }

    @Test
    public void setStations() {
        line.setStations(stations);
        assertEquals(stations,line.getStations());
    }

    /**
     * We test the number of station of the line
     */
    @Test
    public void getNb_stations() {
        assertEquals(0,line.getNb_stations());
    }

    @Test
    public void setNb_stations() {
        line.setNb_stations((int)3.651);
        assertEquals(3,line.getNb_stations());
    }

    /**
     * We test the array of canton of the line
     */
    @Ignore
    @Test
    public void getCantons() {
        fail("Not implemented yet");
    }

    @Test
    public void setCantons() {
        line.setCantons(cantons);
        assertEquals(cantons,line.getCantons());
    }

    /**
     * We test the array of train of the line
     */
    @Ignore
    @Test
    public void getTrains() {
        fail("Not implemented yet");
    }

    @Test
    public void setTrains() {
        line.setTrains(trains);
        assertEquals(trains,line.getTrains());
    }

    /**
     * We test the number of train of the line
     */
    @Test
    public void getNb_train() {
        assertEquals(0,line.getNb_train());
    }

    @Test
    public void setNb_train() {
        line.setNb_train((int)2.064);
        assertEquals(2,line.getNb_train());
    }

    /**
     * We test the number of canton of the line
     */
    @Test
    public void getNb_cantons() {
        assertEquals(0,line.getNb_cantons());
    }

    @Test
    public void setNb_cantons() {
        line.setNb_cantons((int)5.156161);
        assertEquals(5,line.getNb_cantons());
    }

    /**
     * We test the color of the line
     */
    @Test
    public void getColor() {
        assertEquals("couleur",line.getColor());
    }

    @Test
    public void setColor() {
        line.setColor("jaune");
        assertEquals("jaune",line.getColor());
    }

    /**
     * We test the capacity of the train
     */
    @Test
    public void getCapacity() {
        assertEquals(0,line.getCapacity());
    }

    @Test
    public void setCapacity() {
        line.setCapacity((int)15.251);
        assertEquals(15,line.getCapacity());
    }

    /**
     * We test the array of user of the line
     */
    @Ignore
    @Test
    public void getUsers() {
        fail("Not implemented yet");
    }

    @Test
    public void setUsers() {
        line.setUsers(users);
        assertEquals(users,line.getUsers());
    }

    /**
     * We will test the number of user of the line
     */
    @Test
    public void getNbUser() {
        assertEquals(0,line.getNbUser());
    }

    @Test
    public void setNbUser() {
        line.setNbUser((int)4.25);
        assertEquals(4,line.getNbUser());
    }
}
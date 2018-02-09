package com.ucp.gpi.backend.test.model_builders;

import com.ucp.gpi.backend.builders.StationBuilder;
import com.ucp.gpi.backend.builders.TrainBuilder;
import com.ucp.gpi.backend.model.*;
import com.ucp.gpi.backend.utils.Coordinates;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * This class has to test the method of the object Train and its builder
 */
public class TrainTest {

    // The Train
    private TrainBuilder trainBuilder = new TrainBuilder();
    private Train train = trainBuilder.testValues("ID",151);

    // The Line
    private Line line = new Line();

    // The Canton
    private Canton canton = new Canton();

    // The Station
    private Coordinates coordinates = new Coordinates(0,0);
    private StationBuilder stationBuilder = new StationBuilder();
    private Station station = stationBuilder.testStation("name","ID",null,coordinates);

    // The Trace
    private Trace trace = new Trace();

    // The User
    private ArrayList<User> user = new ArrayList();

    @Test
    public void updateProgression() {
        assert train != null;
    }


    /**
     * We test if the Train is correctly created
     */
    @Test
    public void Train(){
        assert train != null;
    }

    /**
     * We test the ID attribute
     */
    @Test
    public void getID() {
        assertEquals("ID",train.getID());
    }

    @Test
    public void setID() {
        train.setID("test");
        assertEquals("The ID is not the same", "test", train.getID());
    }


    /**
     * We test the line attribute
     */
    @Ignore
    @Test
    public void getLine() {
        fail("Error ignored");
    }

    @Test
    public void setLine() {
        train.setLine(line);
        assertEquals("The line is not the same", line, train.getLine());
    }

    /**
     * We test the canton attribute
     */
    @Ignore
    @Test
    public void getCurrentCanton() {
        fail("Error ignored");
    }

    @Test
    public void setCurrentCanton() {
        train.setCurrentCanton(canton);
        assertEquals("The canton is not the same", canton, train.getCurrentCanton());
    }

    @Ignore
    @Test
    public void getCurrentStation() {
        fail("Error ignored");
    }

    /**
     * We test the current Station
     */
    @Test
    public void setCurrentStation() {
        train.setCurrentStation(station);
        assertEquals("The station is not the same", station, train.getCurrentStation());
    }


    /**
     * We test the current source Station
     */
    @Ignore
    @Test
    public void getSrc() {
        fail("Error ignored");
    }

    @Test
    public void setSrc() {
        train.setSrc(station);
        assertEquals("The source station is not the same", station, train.getSrc());
    }

    /**
     * We test the destination Station
     */
    @Ignore
    @Test
    public void getDest() {
        fail("Error ignored");
    }

    @Test
    public void setDest() {
        train.setDest(station);
        assertEquals("The destination station is not the same", station, train.getDest());
    }

    /**
     * We test the progression
     */
    @Test
    public void getProgression() {
        assertEquals(0,train.getProgression(),0);
    }

    @Test
    public void setProgression() {
        train.setProgression(2.022646);
        double getProgression = train.getProgression();
        assertEquals("The progression is not the same", getProgression, 2.022646,0);
    }


    /**
     * We test the distanceDone
     */
    @Test
    public void getCurrentDistanceDone() {
        assertEquals(0,train.getCurrentDistanceDone(),0);
    }

    @Test
    public void setCurrentDistanceDone() {
        train.setLine(line);
        assertEquals("The line is not the same", line, train.getLine());
    }

    /**
     * We test the NbUsers
     */
    @Test
    public void getNbUsers() {
        assertEquals(0,train.getNbUsers());
    }

    @Test
    public void setNbUsers() {
        train.setNbUsers((int)3.0001);
        assertEquals("The NbUsers is not the same", 3, train.getNbUsers());
    }

    /**
     * We test the Users
     */
    @Ignore
    @Test
    public void getUsers() {
        fail("Error ignored");
    }

    @Test
    public void setUsers() {
        train.setUsers(user);
        assertEquals("The Users are not the same", user, train.getUsers());
    }

    /**
     * We test the capacity
     */
    @Test
    public void getCapacity() {
        assertEquals(151,train.getCapacity());
    }

    @Test
    public void setCapacity() {
        train.setLine(line);
        assertEquals("The capacity is not the same", line, train.getLine());
    }

    /**
     * We test the Coord
     */
    @Ignore
    @Test
    public void getCoord() {
    }

    @Test
    public void setCoord() {
        train.setCoord(coordinates);
        assertEquals("The Coord are not the same", coordinates, train.getCoord());
    }

    /**
     * We test the Trace
     */
    @Ignore
    @Test
    public void getTrace() {
        fail("Error ignored");
    }

    @Test
    public void setTrace() {
        train.setTrace(trace);
        assertEquals("The Trace is not the same", trace, train.getTrace());
    }
}
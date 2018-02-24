package com.ucp.gpi.backend.test.model_builders;

import com.ucp.gpi.backend.builders.StationBuilder;
import com.ucp.gpi.backend.model.Station;
import com.ucp.gpi.backend.utils.Coordinates;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This class has to test the method of the object Station and its builder
 */
public class StationTest {

    // The station
    private StationBuilder stationBuilder = new StationBuilder();
    private Station station = stationBuilder.testStation("name", "ID", null, new Coordinates(0, 0));

    // The coordinates
    private Coordinates coordinates = new Coordinates(0, 0);


    /**
     * We test if the station is initialised
     */
    @Test
    public void Station() {
        assert station != null;
    }

    /**
     * We test the name of the station
     */
    @Test
    public void getName() {
        assertEquals("name", station.getName());
    }

    @Test
    public void setName() {
        station.setName("test");
        assertEquals("test", station.getName());
    }

    /**
     * We test the ID of the station
     */
    @Test
    public void getID() {
        assertEquals("ID", station.getID());
    }

    @Test
    public void setID() {
        station.setID("test");
        assertEquals("test", station.getID());
    }

    /**
     * We test the stats of the station
     */
    @Ignore
    @Test
    public void getStatistique() {
        fail("not implemented yet");
    }

    @Ignore
    @Test
    public void setStatistique() {
        fail("not implemented yet");
    }

    /**
     * We test the Coords of the station
     */

    @Ignore
    @Test
    public void getCoord() {
        fail("not implemented yet");
    }

    @Test
    public void setCoord() {
        station.setCoord(coordinates);
        assertEquals(coordinates, station.getCoord());
    }
}
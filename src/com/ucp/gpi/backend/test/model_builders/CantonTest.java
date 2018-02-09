package com.ucp.gpi.backend.test.model_builders;

import com.ucp.gpi.backend.builders.CantonBuilder;
import com.ucp.gpi.backend.model.Canton;
import com.ucp.gpi.backend.model.Station;
import com.ucp.gpi.backend.model.Train;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class has to test the method of the object Canton and its builder
 */
public class CantonTest {

    // The Canton
    private CantonBuilder cantonBuilder = new CantonBuilder();
    private Canton canton = cantonBuilder.testCanton("ID",false,0,0);

    // The Train
    private Train train = new Train();

    // The Station
    private Station station = new Station();



    /**
     * We test if the canton is initialised
     */
    @Test
    public void Canton() {
        assert canton != null;
    }

    /**
     * We test the if the canton is free
     */
    @Test
    public void isFree() {
        assertNotEquals(true,canton.getOccupation());
    }

    /**
     * We test the ID the canton
     */
    @Test
    public void getID() {
        assertEquals("ID",canton.getID());
    }

    @Test
    public void setID() {
        canton.setID("test");
        assertEquals("test",canton.getID());
    }

    /**
     * We test the lenght of the canton
     */
    @Test
    public void getLenght() {
        assertEquals(0,canton.getLenght(),0);
    }

    @Test
    public void setLenght() {
        canton.setLenght(3.32);
        assertEquals(3.32,canton.getLenght(),0);
    }

    /**
     * We test if the canton is occupated by a train
     */
    @Test
    public void getOccupation() {
        assertFalse(canton.getOccupation());
    }

    @Test
    public void setOccupation() {
        canton.setOccupation(true);
        assertTrue(canton.getOccupation());
    }

    /**
     * We test the train's speed of the canton
     */
    @Test
    public void getSpeed() {
        assertEquals(0,canton.getSpeed());
    }

    @Test
    public void setSpeed() {
        canton.setSpeed((int)3.45);
        assertEquals(3,canton.getSpeed());
    }

    /**
     * We test the station at the begin of the canton
     */
    @Ignore
    @Test
    public void getBeginStation() {
        fail("not implemented yet");
    }

    @Test
    public void setBeginStation() {
        canton.setBeginStation(station);
        assertEquals(station,canton.getBeginStation());
    }

    /**
     * We test the station at the end of the canton
     */
    @Ignore
    @Test
    public void getEndStation() {
        fail("not implemented yet");
    }

    @Test
    public void setEndStation() {
        canton.setEndStation(station);
        assertEquals(station,canton.getEndStation());
    }

    /**
     * We test the currentTrain of the canton
     */
    @Ignore
    @Test
    public void getCurrentTrain() {
        fail("not implemented yet");
    }

    @Test
    public void setCurrentTrain() {
        canton.setCurrentTrain(train);
        assertEquals(train,canton.getCurrentTrain());
    }
}
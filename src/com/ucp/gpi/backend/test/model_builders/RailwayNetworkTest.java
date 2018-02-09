package com.ucp.gpi.backend.test.model_builders;

import com.ucp.gpi.backend.builders.NetworkBuilder;
import com.ucp.gpi.backend.model.Line;
import com.ucp.gpi.backend.model.RailwayNetwork;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * This class has to test the method of the object RailwayNetwork and its builder
 */
public class RailwayNetworkTest {

    // The RailwayNetwork
    private NetworkBuilder networkBuilder = new NetworkBuilder();
    private RailwayNetwork railwayNetwork = networkBuilder.creat(15);

    // The Line
    private ArrayList<Line> lines = new ArrayList<>();


    /**
     * We test if the railwayNetwork is initialised
     */
    @Test
    public void RailwayNetwork(){
        assert railwayNetwork != null;
    }

    /**
     * We will test the Array of Lines
     */
    @Ignore
    @Test
    public void getLines() {
        fail("not implemented yet");
    }

    @Test
    public void setLines() {
        railwayNetwork.setLines(lines);
        assertEquals(lines, railwayNetwork.getLines());
    }

    /**
     * We will test the number of Lines
     */
    @Test
    public void getNb_lines() {
        assertEquals(15,railwayNetwork.getNb_lines());
    }

    @Test
    public void setNb_lines() {
        railwayNetwork.setNb_lines((int)3.48454);
        assertEquals(3,railwayNetwork.getNb_lines());
    }
}
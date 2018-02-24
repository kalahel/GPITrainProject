package com.ucp.gpi.backend.test.model_builders;

import com.ucp.gpi.backend.model.Canton;
import com.ucp.gpi.backend.model.Trace;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * This class has to test the method of the object Trace
 */
public class TraceTest {

    // The trace
    private Trace trace = new Trace();

    // The canton
    private ArrayList<Canton> cantons = new ArrayList<Canton>();


    /**
     * We test if the trace is initialised
     */
    @Test
    public void Trace() {
        assert trace != null;
    }

    /**
     * We test the ArrayList of canton
     */
    @Ignore
    @Test
    public void getTrace() {
        fail("Error ignored");
    }

    @Test
    public void setTrace() {
        trace.setTrace(cantons);
        assertEquals(cantons, trace.getTrace());
    }

    /**
     * We test the number of canton of a trace object
     */
    @Ignore
    @Test
    public void getNbCanton() {
        fail("Error ignored");
    }

    @Test
    public void setNbCanton() {
        trace.setNbCanton((int) 3.48454);
        assertEquals(3, trace.getNbCanton());
    }
}
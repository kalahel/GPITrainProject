package com.ucp.gpi;

import com.ucp.gpi.frontend.TrainFrame;
import fr.theshark34.swinger.Swinger;

public class TrainSimulator {
    public static void main(String[] args) {
        Swinger.setResourcePath("/rsc/");
        new TrainFrame();
    }
}

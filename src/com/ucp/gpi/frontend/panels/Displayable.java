package com.ucp.gpi.frontend.panels;

import com.ucp.gpi.backend.model.RailwayNetwork;

public interface Displayable {
    void refreshAll(RailwayNetwork railwayNetwork);
    void setNetwork(RailwayNetwork railwayNetwork);
}

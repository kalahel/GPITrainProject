package com.ucp.gpi.frontend.data;

/**
 * A Canton is a link between two station
 */
public class VisualCanton {
    private VisualStation internalVisualStation, externalVisualStation;

    /**
     *
     * @param internalVisualStation is from where the train will come
     * @param externalVisualStation is to where the train will leave
     */
    public VisualCanton(VisualStation internalVisualStation, VisualStation externalVisualStation) {
        this.internalVisualStation = internalVisualStation;
        this.externalVisualStation = externalVisualStation;
    }

    public VisualStation getInternalVisualStation() {
        return internalVisualStation;
    }

    public void setInternalVisualStation(VisualStation internalVisualStation) {
        this.internalVisualStation = internalVisualStation;
    }

    public VisualStation getExternalVisualStation() {
        return externalVisualStation;
    }

    public void setExternalVisualStation(VisualStation externalVisualStation) {
        this.externalVisualStation = externalVisualStation;
    }
}

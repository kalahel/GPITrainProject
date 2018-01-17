package com.ucp.gpi.frontend.data;

/**
 * A Canton is a link between two station
 */
public class Canton {
    private Station internalStation,externalStation;

    /**
     *
     * @param internalStation is from where the train will come
     * @param externalStation is from where the train will leave
     */
    public Canton(Station internalStation, Station externalStation) {
        this.internalStation = internalStation;
        this.externalStation = externalStation;
    }

    public Station getInternalStation() {
        return internalStation;
    }

    public void setInternalStation(Station internalStation) {
        this.internalStation = internalStation;
    }

    public Station getExternalStation() {
        return externalStation;
    }

    public void setExternalStation(Station externalStation) {
        this.externalStation = externalStation;
    }
}

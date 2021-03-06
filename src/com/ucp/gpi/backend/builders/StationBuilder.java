package com.ucp.gpi.backend.builders;

import com.ucp.gpi.backend.model.Line;
import com.ucp.gpi.backend.model.Station;
import com.ucp.gpi.backend.statistique.StationStat;
import com.ucp.gpi.backend.utils.Coordinates;

/**
 * @author matthieu
 * 23/01/2018
 */
public class StationBuilder {

    private Station station;

    public StationBuilder() {

    }

    public Station CreatStation(String name, String code_UIC, Line line, int capacity) {
        station = new Station();
        station.setStationName(name);
        station.setID(code_UIC);
        station.setOccupation(false);
        station.setLine(line);
        station.setCapacity(capacity);
        station.setStatistique(new StationStat(station));
        return station;
    }

    /**
     * This method will be usefull to the test Classes
     *
     * @param name        is the name given to the station
     * @param code_UIC    is the ID given to the station
     * @param coordinates are the new coordinates of the station
     * @param stationStat is the statistique object
     * @return the new station for the StationTest class
     */
    public Station testStation(String name, String code_UIC, StationStat stationStat, Coordinates coordinates) {
        station = new Station();
        station.setStationName(name);
        station.setID(code_UIC);
        station.setStatistique(stationStat);
        station.setCoord(coordinates);

        return station;
    }
}

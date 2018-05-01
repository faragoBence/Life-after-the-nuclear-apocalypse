package com.codecool.web.service;

import com.codecool.web.exception.WrongDestinationException;
import com.codecool.web.model.Survivor;
import com.codecool.web.model.locations.Location;

public interface LocationService {

    Location getSchool();

    Location getGasStation();

    Location getHospital();

    Location getMilitaryBase();

    void travel(Survivor survivor, String destination) throws WrongDestinationException;

    String description(Location location);
}

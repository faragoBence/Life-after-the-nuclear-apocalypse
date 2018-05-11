package com.codecool.web.service.implementations;

import com.codecool.web.exception.WrongDestinationException;
import com.codecool.web.model.locations.Location;
import com.codecool.web.model.locations.LocationFactory;
import com.codecool.web.model.locations.LocationFactoryImpl;
import com.codecool.web.model.locations.Place;
import com.codecool.web.model.survivors.Survivor;
import com.codecool.web.service.LocationService;

public class LocationServiceImpl implements LocationService {

    private LocationFactory locationFactory;


    public void LocationServiceImpl() {
        locationFactory = new LocationFactoryImpl();
    }

    @Override
    public Location getLocation(String destination) {
        return  locationFactory.getLocation(destination.toUpperCase());
    }

    public Survivor travel(Survivor survivor, String destination) throws WrongDestinationException {
        destination = destination.toUpperCase();
        if (destination.equals(survivor.getCurrentLocation().toUpperCase())) {
            throw new WrongDestinationException();
        }
        Place place = Place.valueOf(destination);
        switch (place) {
            case OUTPOST:
                survivor.setCurrentLocation("Outpost");
                break;
            case GASSTATION:
                survivor.setCurrentLocation("GasStation");
                break;
            case HOSPITAL:
                survivor.setCurrentLocation("Hospital");
                break;
            case MILITARYBASE:
                survivor.setCurrentLocation("MilitaryBase");
                break;
            case SCHOOL:
                survivor.setCurrentLocation("School");
                break;
            default:
                throw new WrongDestinationException();

        }
        return survivor;
    }

    public String description(Location location) {
        return location.getDescription();
    }
}

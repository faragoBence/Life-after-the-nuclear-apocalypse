package com.codecool.web.model.locations;

public class LocationFactoryImpl implements LocationFactory {
    @Override
    public Location getLocation(String place)  {
        Place placeEnum = Place.valueOf(place);
        switch (placeEnum) {
            case GASSTATION:
                return GasStation.getInstance();
            case HOSPITAL:
                return Hospital.getInstance();
            case MILITARYBASE:
                return MilitaryBase.getInstance();
            case SCHOOL:
                return School.getInstance();
            default:
                return null;
        }
    }
}

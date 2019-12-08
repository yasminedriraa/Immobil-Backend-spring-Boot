package com.javainuse.service;

import com.javainuse.model.Location;

import java.util.List;

public interface LocationService {
    Location createLocation(Location location);
    List<Location> getAllLocation();
    Location getLocationByid(Long id);
    Location updateLocation(Long id, Location location);
    void deleteLocation(Long id);
}

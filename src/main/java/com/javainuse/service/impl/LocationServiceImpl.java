package com.javainuse.service.impl;

import com.javainuse.model.Location;
import com.javainuse.repository.LocationRepository;
import com.javainuse.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationByid(Long id) {
        return locationRepository.findById(id).get();
    }

    @Override
    public Location updateLocation(Long id, Location location) {
        Location locationFromDB = getLocationByid(id);
        if (locationFromDB != null) {
            locationFromDB.setId(location.getId());
            locationFromDB.setAdresse(location.getAdresse());
            locationFromDB.setPays(location.getPays());
            locationFromDB.setVille(location.getVille());
            locationFromDB.setRegion(location.getRegion());
            return locationRepository.save(locationFromDB);
        }
        return null;
    }

    @Override
    public void deleteLocation(Long id) {
    locationRepository.deleteById(id);
    }
}

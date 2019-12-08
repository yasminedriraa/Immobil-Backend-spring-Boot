package com.javainuse.controller;

import com.javainuse.model.Location;
import com.javainuse.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping("/location")
    public ResponseEntity<?> createLocation(@RequestBody Location location) {
        return ResponseEntity.ok(locationService.createLocation(location));
    }

    @GetMapping("/location")
    public ResponseEntity<?> getAllLocations() {
        return ResponseEntity.ok(locationService.getAllLocation());
    }

    @GetMapping("/location/{locationId}")
    public ResponseEntity<?> getLocationById(@PathVariable("locationId") Long locationId) {
        return ResponseEntity.ok(locationService.getLocationByid(locationId));
    }

    @PutMapping("/location/{locationId}")
    public ResponseEntity<?> updateLocation(@PathVariable("locationId") Long locationId, @RequestBody Location location) {
        return ResponseEntity.ok(locationService.updateLocation(locationId, location));
    }

    @DeleteMapping("/location/{locationId}")
    public void deleteLocaation(@PathVariable("locationId") Long locationId) {
        locationService.deleteLocation(locationId);
    }
}

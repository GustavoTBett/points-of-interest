package com.gustavoTBett.pointsofinterest.controller;

import com.gustavoTBett.pointsofinterest.dto.LocationInsert;
import com.gustavoTBett.pointsofinterest.model.Location;
import com.gustavoTBett.pointsofinterest.repository.LocationRepository;
import com.gustavoTBett.pointsofinterest.service.LocationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gustavo
 */
@RestController
@RequestMapping("")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationRepository locationRepository;

    @PostMapping
    public ResponseEntity create(@RequestBody LocationInsert locationInsert) {
        Location location = new Location();
        location.setName(locationInsert.getNome());
        location.setX(locationInsert.getX());
        location.setY(locationInsert.getY());
        location = locationRepository.save(location);
        return ResponseEntity.ok(new LocationInsert(location));
    }

    @GetMapping("/{x}&{y}&{dMax}")
    public ResponseEntity getProximity(@PathVariable("x") Long x, @PathVariable("y") Long y, @PathVariable("dMax") Long dMax) {
        if (x == null || y == null) {
            return ResponseEntity.status(404).body("Algum dos campos estão faltandos");
        } else {
            List<Location> locations = locationService.getByProximity(x, y, dMax);
            List<LocationInsert> locationInserts = locations.stream().map(location -> new LocationInsert(location)).toList();
            return ResponseEntity.status(200).body(locationInserts);
        }
    }

    @GetMapping
    public ResponseEntity get() {
        List<Location> locations = locationRepository.findAll();
        List<LocationInsert> locationInserts = locations.stream().map(x -> new LocationInsert(x)).toList();
        return ResponseEntity.ok(locationInserts);
    }
}

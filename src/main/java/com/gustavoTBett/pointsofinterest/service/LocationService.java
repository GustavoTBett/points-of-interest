package com.gustavoTBett.pointsofinterest.service;

import com.gustavoTBett.pointsofinterest.model.Location;
import com.gustavoTBett.pointsofinterest.repository.LocationRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gustavo
 */
@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getByProximity(Long x, Long y, Long distancia) {
        List<Location> combinedLocations = locationRepository.findAll();

        List<Location> result = combinedLocations.stream()
                .filter(location -> isWithinRadius(location, x, y, distancia))
                .collect(Collectors.toList());

        return result;
    }

    private boolean isWithinRadius(Location location, double x, double y, double radius) {
        double distance = Math.sqrt(Math.pow(location.getX() - x, 2) + Math.pow(location.getY() - y, 2));

        return distance <= radius;
    }
}

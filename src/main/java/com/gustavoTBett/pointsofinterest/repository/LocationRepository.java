package com.gustavoTBett.pointsofinterest.repository;

import com.gustavoTBett.pointsofinterest.model.Location;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gustavo
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    
}

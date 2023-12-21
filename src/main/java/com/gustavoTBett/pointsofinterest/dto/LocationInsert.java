package com.gustavoTBett.pointsofinterest.dto;

import com.gustavoTBett.pointsofinterest.model.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author gustavo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationInsert {
    private String nome;
    private Long x;
    private Long y;
    
    public LocationInsert(Location location) {
        nome = location.getName();
        x = location.getX();
        y = location.getY();
    }
}

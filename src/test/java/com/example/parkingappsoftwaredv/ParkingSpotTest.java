package com.example.parkingappsoftwaredv;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingSpotTest {
    @Test
    void newSpotShouldBeAvailable() {
        ParkingSpot spot = new ParkingSpot(1);
        assertFalse(spot.isOccupied());
    }
}

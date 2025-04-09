package com.example.parkingappsoftwaredv;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void shouldCreateParkingLot() {
        ParkingLot lot = new ParkingLot(5);
        assertNotNull(lot);
    }

    @Test
    void shouldBookAvailableSpot() {
        ParkingLot lot = new ParkingLot(3);
        assertTrue(lot.bookSpot(1, "ABC123"));
        assertTrue(lot.getSpots().get(0).isOccupied());
    }

    @Test
    void shouldNotBookOccupiedSpot() {
        ParkingLot lot = new ParkingLot(3);
        lot.bookSpot(1, "ABC123"); // Book first
        assertFalse(lot.bookSpot(1, "XYZ789")); // Try to book same spot
    }

    @Test
    void shouldReleaseOccupiedSpot() {
        ParkingLot lot = new ParkingLot(3);
        lot.bookSpot(1, "ABC123");
        assertTrue(lot.releaseSpot(1));
        assertFalse(lot.getSpots().get(0).isOccupied());
    }
}

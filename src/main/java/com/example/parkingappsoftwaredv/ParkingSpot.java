package com.example.parkingappsoftwaredv;

public class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private String vehicleLicense;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isOccupied = false;
        this.vehicleLicense = "";
    }

    public void occupy(String licensePlate) {
        this.isOccupied = true;
        this.vehicleLicense = licensePlate;
    }

    public void vacate() {
        this.isOccupied = false;
        this.vehicleLicense = "";
    }

    // Getters and setters
    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getVehicleLicense() {
        return vehicleLicense;
    }

    public void occupySpot(String license) {
        this.isOccupied = true;
        this.vehicleLicense = license;
    }

    public void vacateSpot() {
        this.isOccupied = false;
        this.vehicleLicense = "";
    }

    @Override
    public String toString() {
        return "Spot " + spotNumber + ": " +
                (isOccupied ? "Occupied by " + vehicleLicense : "Available");
    }
}

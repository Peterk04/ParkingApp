package com.example.parkingappsoftwaredv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLot {
    private List<ParkingSpot> spots;
    private Scanner scanner;

    public ParkingLot(int capacity) {
        spots = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            spots.add(new ParkingSpot(i));
        }
        scanner = new Scanner(System.in);
    }

    public boolean bookSpot(int spotNumber, String license) {
        // Get the parking spot (array is 0-based, spots are 1-based)
        ParkingSpot spot = spots.get(spotNumber - 1);

        // Check if spot is already occupied
        if (spot.isOccupied()) {
            return false; // Booking failed
        }

        // Mark spot as occupied
        spot.occupy(license);
        return true; // Booking succeeded
    }

    public boolean releaseSpot(int spotNumber) {
        // Get the parking spot
        ParkingSpot spot = spots.get(spotNumber - 1);

        // Check if spot is actually occupied
        if (!spot.isOccupied()) {
            return false; // Release failed
        }

        // Free up the spot
        spot.vacate();
        return true; // Release succeeded
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\nParking Lot Management System");
            System.out.println("1. View all spots");
            System.out.println("2. Park a vehicle");
            System.out.println("3. Remove a vehicle");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    displaySpots();
                    break;
                case 2:
                    parkVehicle();
                    break;
                case 3:
                    removeVehicle();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private void displaySpots() {
        System.out.println("\nCurrent Parking Spots:");
        for (ParkingSpot spot : spots) {
            System.out.println(spot);
        }
    }

    private void parkVehicle() {
        displaySpots();
        System.out.print("Enter spot number to park: ");
        int spotNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (spotNumber < 1 || spotNumber > spots.size()) {
            System.out.println("Invalid spot number.");
            return;
        }

        ParkingSpot spot = spots.get(spotNumber - 1);
        if (spot.isOccupied()) {
            System.out.println("Spot is already occupied.");
        } else {
            System.out.print("Enter vehicle license plate: ");
            String license = scanner.nextLine();
            spot.occupySpot(license);
            System.out.println("Vehicle parked successfully.");
        }
    }

    private void removeVehicle() {
        displaySpots();
        System.out.print("Enter spot number to vacate: ");
        int spotNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (spotNumber < 1 || spotNumber > spots.size()) {
            System.out.println("Invalid spot number.");
            return;
        }

        ParkingSpot spot = spots.get(spotNumber - 1);
        if (!spot.isOccupied()) {
            System.out.println("Spot is already vacant.");
        } else {
            spot.vacateSpot();
            System.out.println("Vehicle removed successfully.");
        }
    }
    public List<ParkingSpot> getSpots() {
        return new ArrayList<>(spots); // Return copy for safety
    }
}

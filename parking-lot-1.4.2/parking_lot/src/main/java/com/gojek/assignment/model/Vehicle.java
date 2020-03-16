package com.gojek.assignment.model;

public class Vehicle {
    private String colour;
    private String registrationNumber;

    public Vehicle(String colour, String registrationNumber) {
        this.colour = colour;
        this.registrationNumber = registrationNumber;
    }

    private ParkingSlot parkingSlot;



    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }
}
